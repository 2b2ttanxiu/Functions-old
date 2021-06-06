package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandKick implements CommandExecutor {
    private Functions a = Functions.getMain();

    public CommandKick() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player target;
        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                sender.sendMessage(this.a.String(1, "Usage-Kick", "/kick <player>"));
                return true;
            }

            if (args.length == 1) {
                if (!this.a.getDisplayNameOnline(args[0])) {
                    sender.sendMessage(this.a.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[1]).replace("%player%", sender.getName()));
                    return true;
                }

                target = this.a.getServer().getPlayer(args[0]);
                sender.sendMessage(this.a.String(1, "Kick", "Kicked %target%").replace("%target%", args[0]).replace("%player%", sender.getName()));
                target.kickPlayer(this.a.getSettings().getString("Kick.Message").replace("%player%", sender.getName()).replace("%target%", args[0]));
            }
        } else {
            if (args.length == 0) {
                if (!this.a.hasPermission(sender.getName(), "functions.command.kick.other")) {
                    sender.sendMessage(this.a.Permission());
                    return true;
                }

                sender.sendMessage(this.a.String(1, "Kick", "Kicked %target%").replace("%target%", sender.getName()).replace("%player%", sender.getName()));
                ((Player)sender).kickPlayer(this.a.getSettings().getString("Kick.Message").replace("%player%", sender.getName()).replace("%target%", sender.getName()));
            }

            if (args.length == 1) {
                if (!this.a.hasPermission(sender.getName(), "functions.command.kick.target")) {
                    sender.sendMessage(this.a.Permission());
                    return true;
                }

                if (!this.a.getDisplayNameOnline(args[0])) {
                    sender.sendMessage(this.a.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[1]).replace("%player%", sender.getName()));
                    return true;
                }

                target = this.a.getServer().getPlayer(args[0]);
                sender.sendMessage(this.a.String(1, "Kick", "Kicked %target%").replace("%target%", args[0]).replace("%player%", sender.getName()));
                target.kickPlayer(this.a.getSettings().getString("Kick.Message").replace("%player%", sender.getName()).replace("%target%", args[0]));
            }
        }

        return true;
    }
}
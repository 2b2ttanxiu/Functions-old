package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandKill implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandKill() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("kill")) {
            Player target;
            if (!(sender instanceof Player)) {
                if (args.length == 0) {
                    sender.sendMessage(this.p.String(1, "Usage-Kill", "/kill <player>"));
                    return true;
                }

                if (!this.p.getDisplayNameOnline(args[0])) {
                    sender.sendMessage(this.p.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[1]).replace("%player%", sender.getName()));
                    return true;
                }

                target = this.p.getServer().getPlayer(args[0]);
                sender.sendMessage(this.p.String(1, "Kill", "%target% died").replace("%target%", args[0]).replace("%player%", sender.getName()));
                target.setHealth(0.0D);
            } else {
                if (args.length == 1) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.kill.target")) {
                        sender.sendMessage(this.p.Permission());
                        return true;
                    }

                    if (!this.p.getDisplayNameOnline(args[0])) {
                        sender.sendMessage(this.p.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[0]).replace("%player%", sender.getName()));
                        return true;
                    }

                    target = this.p.getServer().getPlayer(args[0]);
                    sender.sendMessage(this.p.String(1, "Kill", "%target% died").replace("%target%", args[0]).replace("%player%", sender.getName()));
                    target.setHealth(0.0D);
                    return true;
                }

                if (args.length == 0) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.kill.other")) {
                        sender.sendMessage(this.p.Permission());
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "Kill", "%target% died").replace("%target%", sender.getName()).replace("%player%", sender.getName()));
                    ((Player)sender).setHealth(0.0D);
                    return true;
                }
            }
        }

        return true;
    }
}
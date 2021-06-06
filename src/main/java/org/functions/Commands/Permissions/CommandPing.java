package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;
import org.functions.Tools.getPing;

public class CommandPing implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandPing() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ping")) {
            Player target;
            if (!(sender instanceof Player)) {
                if (args.length == 0) {
                }

                if (!this.p.getDisplayNameOnline(args[0])) {
                    sender.sendMessage(this.p.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[1]).replace("%player%", sender.getName()));
                    return true;
                }

                target = this.p.getServer().getPlayer(args[0]);
                sender.sendMessage(this.p.String(1, "Ping", "%target%'s ping %ping% ms").replace("%target%", args[0]).replace("%player%", sender.getName()).replace("%ping%", getPing.getPing(target) + ""));
                return true;
            }

            if (args.length == 0) {
                if (!this.p.hasPermission(sender.getName(), "functions.command.ping.other")) {
                    sender.sendMessage(this.p.Permission());
                    return true;
                }

                target = (Player)sender;
                sender.sendMessage(this.p.String(1, "Ping", "%target%'s ping %ping% ms").replace("%target%", target.getName()).replace("%player%", sender.getName()).replace("%ping%", getPing.getPing(target) + ""));
                return true;
            }

            if (args.length == 1) {
                if (!this.p.hasPermission(sender.getName(), "functions.command.ping.target")) {
                    sender.sendMessage(this.p.Permission());
                    return true;
                }

                if (!this.p.getDisplayNameOnline(args[0])) {
                    sender.sendMessage(this.p.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[1]).replace("%player%", sender.getName()));
                    return true;
                }

                target = this.p.getServer().getPlayer(args[0]);
                sender.sendMessage(this.p.String(1, "Ping", "%target%'s ping %ping% ms").replace("%target%", args[0]).replace("%player%", sender.getName()).replace("%ping%", getPing.getPing(target) + ""));
                return true;
            }
        }

        return true;
    }
}
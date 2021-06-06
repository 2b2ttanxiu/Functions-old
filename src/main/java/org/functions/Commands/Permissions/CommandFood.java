package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;

public class CommandFood implements CommandExecutor {
    private PlayerNMS nms = new PlayerNMS();

    public CommandFood() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p;
        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                return true;
            }

            if (args.length == 1) {
                if (!this.nms.nms.getDisplayNameOnline(args[0])) {
                    sender.sendMessage(this.nms.nms.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[0]).replace("%player%", sender.getName()));
                    return true;
                }

                p = this.nms.Player(args[0]);
                p.setFoodLevel(100);
                sender.sendMessage(this.nms.nms.String(1, "SetFood", "%target%'s food is max").replace("%target%", args[0]).replace("%food%", p.getFoodLevel() + "").replace("%player%", sender.getName()));
                return true;
            }
        }

        if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.food.others")) {
            sender.sendMessage(this.nms.nms.Permission());
            return true;
        } else if (args.length == 0) {
            p = this.nms.getPlayer(sender);
            p.setFoodLevel(100);
            sender.sendMessage(this.nms.nms.String(1, "SetFood", "%target%'s food is a max").replace("%target%", sender.getName()).replace("%food%", p.getFoodLevel() + "").replace("%player%", sender.getName()));
            return true;
        } else if (args.length == 1) {
            if (!this.nms.nms.getDisplayNameOnline(args[0])) {
                sender.sendMessage(this.nms.nms.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[0]).replace("%player%", sender.getName()));
                return true;
            } else {
                p = this.nms.Player(args[0]);
                p.setFoodLevel(100);
                sender.sendMessage(this.nms.nms.String(1, "SetFood", "%target%'s food is max").replace("%target%", args[0]).replace("%food%", p.getFoodLevel() + "").replace("%player%", sender.getName()));
                return true;
            }
        } else {
            return true;
        }
    }
}
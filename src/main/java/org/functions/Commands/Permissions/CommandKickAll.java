package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerNMS;

import java.util.ArrayList;
import java.util.List;

public class CommandKickAll implements TabExecutor {
    public static void run(JavaPlugin j) {
        j.getCommand("kickall").setTabCompleter(new CommandKickAll());
        j.getCommand("kickall").setExecutor(new CommandKickAll());
    }
    PlayerNMS nms = new PlayerNMS();
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (!nms.nms.hasPermission(sender.getName(),"functions.command.kickall")) {
                sender.sendMessage(nms.nms.Permission());
                return true;
            }
            if (args.length == 1) {
                for (Player p : nms.getOnlinePlayers()) {
                    if (!p.isOp()) {
                        p.kickPlayer(args[0]);
                        sender.sendMessage(nms.nms.String(1,"KickAll","Kick all players,Server in has admin.").replace("%player%", sender.getName()));
                        return true;
                    }
                }
            }
            for (Player p : nms.getOnlinePlayers()) {
                if (!p.isOp()) {
                    p.kickPlayer(nms.replace(p,nms.nms.getSettings().getString("Kick.Message")));
                    sender.sendMessage(nms.nms.String(1,"KickAll","Kick all players,Server in has admin.").replace("%player%", sender.getName()));
                    return true;
                }
            }
        }
        return true;
    }
    public List<String> onTabComplete(CommandSender sender,Command cmd,String s,String[] args) {
        if (!nms.nms.hasPermission(sender.getName(),"functions.command.kickall")) {
            return null;
        }
        List<String> ls = new ArrayList<>();
        for (Player p : nms.getOnlinePlayers()) {
            ls.add(p.getName());
        }
        return ls;
    }
}

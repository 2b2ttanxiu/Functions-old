package org.functions.Commands.Permissions;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerNMS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandPosition implements TabExecutor {
    public static void run(JavaPlugin j) {
        j.getCommand("position").setTabCompleter(new CommandPosition());
        j.getCommand("position").setExecutor(new CommandPosition());
    }
    PlayerNMS nms = new PlayerNMS();
    @SuppressWarnings("all")
    public boolean onCommand(CommandSender sender,Command cmd,String s,String[] args) {
        String name = sender.getName();
        if (sender instanceof Player) {
            if (args.length == 0) {
                if (!nms.nms.hasPermission(name,"functions.command.position.*")) {
                    if (!nms.nms.hasPermission(name,"functions.command.position.me")) {
                        sender.sendMessage(nms.nms.Permission());
                        return true;
                    }
                }
                String loc = nms.changeLocation(nms.getPlayer(sender).getLocation());
                sender.sendMessage(nms.nms.String(1,"Position","%target% position: %position%").replace("%player%",name).replace("%target%",name).replace("%position%",loc));
                return true;
            }

            if (!nms.nms.hasPermission(name,"functions.command.position.*")) {
                if (!nms.nms.hasPermission(name,"functions.command.position.target")) {
                    sender.sendMessage(nms.nms.Permission());
                    return true;
                }
            }
            for (Player p : nms.getOnlinePlayers()) {
                if (args[0].equalsIgnoreCase(p.getName())) {
                    String loc = nms.changeLocation(nms.getPlayer(sender).getLocation());
                    sender.sendMessage(nms.nms.String(1,"Position","%target% position: %position%").replace("%player%",name).replace("%target%",p.getName()).replace("%position%",loc));
                    return true;
                }
            }
        } else {
            if (args.length == 0) {
                sender.sendMessage(nms.nms.String(1,"CommandLength","You command length too short,Please add smonething command"));
                return true;
            }
            for (Player p : nms.getOnlinePlayers()) {
                if (args[0].equalsIgnoreCase(p.getName())) {
                    String loc = nms.changeLocation(nms.getPlayer(false,args[0]).getLocation());
                    sender.sendMessage(nms.nms.String(1,"Position","%target% position: %position%").replace("%player%",name).replace("%target%",p.getName()).replace("%position%",loc));
                    return true;
                }
            }
        }
        return true;
    }
    @SuppressWarnings("all")
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        List<String> ls = new ArrayList<>();
        for (Player p : nms.getOnlinePlayers()) {
            ls.add(p.getName());
        }
        return ls;
    }
}

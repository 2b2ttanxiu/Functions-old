package org.functions.Commands.Permissions;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerNMS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommandWorld implements TabExecutor {
    PlayerNMS nms = new PlayerNMS();
    public static void run(JavaPlugin j) {
        j.getCommand("world").setExecutor(new CommandWorld());
        j.getCommand("world").setTabCompleter(new CommandWorld());
    }
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length == 0) {
//           if (!nms.hasPermission(sender.getName(),"functions.command.world.*")) {
//               if (!nms.hasPermission(sender.getName(),"functions.command.world.list")) {
//                   nms.sendPermission(sender);
//                   return true;
//               }
//           }
        }
        if (args.length == 1) {
            if ("list".equalsIgnoreCase(args[0])) {
                //if (!nms.hasPermission(sender.getName(), "functions.command.world.*")) {
                //    if (!nms.hasPermission(sender.getName(), "functions.command.world.list.*")) {
                //        nms.sendPermission(sender);
                //        return true;
                //    }
                //}
                String WorldList = nms.nms.getSettings().getString("List.Worlds");
                String l = "";
                int i = 0;
                for (World w : nms.getWorlds()) {
                    l = l + WorldList.replace("%world%",w.getName()).replace("%count%",i+"");
                    i++;
                }
                sender.sendMessage(nms.String("ListWorlds","List worlds: %worlds%").replace("%worlds%",WorldList));
                return true;
            }
        }
        if (args.length == 2) {
            if ("teleport".equalsIgnoreCase(args[0]) || "tp".equalsIgnoreCase(args[0])) {
                //if (!nms.hasPermission(sender.getName(), "functions.command.world.*")) {
                //    if (!nms.hasPermission(sender.getName(), "functions.command.world.teleport.*")) {
                //        String name = "";
                //        for (World w : nms.getWorlds()) {
                //            if (args[1].equalsIgnoreCase(w.getName())) {
                //                name = w.getName();
                //            }
                //        }
                //        if (!nms.hasPermission(sender.getName(), "functions.command.world.teleport." + name)) {
                //            nms.sendPermission(sender);
                //            return true;
                //        }
                //    }
                //}
                boolean empty = false;
                String name = "";
                for (World w : nms.getWorlds()) {
                    if (args[1].equalsIgnoreCase(w.getName())) {
                        empty = true;
                        name = w.getName();
                    }
                }
                if (!empty) {
                    sender.sendMessage(nms.String("NoEmptyWorld", "The world(%world%) no empty.").replace("%world%", args[1]));
                    return true;
                }
                Location loc = nms.getWorld(name).getSpawnLocation();
                Player p = nms.getPlayer(sender);
                p.teleport(loc);
                sender.sendMessage(nms.String("Teleport","You teleport to world spawn").replace("%player%",sender.getName()).replace("%target%",sender.getName()));
                return true;
            }
            if ("create-void".equalsIgnoreCase(args[0]) || "add-void".equalsIgnoreCase(args[0])) {
                //if (!nms.hasPermission(sender.getName(), "functions.command.world.*")) {
                //    if (!nms.hasPermission(sender.getName(), "functions.command.world.create")) {
                //        nms.sendPermission(sender);
                //        return true;
                //    }
                //}
                if ("logs".equalsIgnoreCase(args[1]) || "cache".equalsIgnoreCase(args[1]) || "plugins".equalsIgnoreCase(args[1])) {
                    sender.sendMessage(nms.String("CreateWorldToDirs","You create to %world% dirs").replace("%world%",args[1]));
                    return true;
                }
                WorldCreator worldCreator = new WorldCreator(args[1]);
                World overworld = nms.getWorlds().get(0);
                World w = Bukkit.createWorld(worldCreator);
                w.setDifficulty(overworld.getDifficulty());
                //.getPopulators().add();

            }
            if ("delete".equalsIgnoreCase(args[0])) {
                if ("logs".equalsIgnoreCase(args[1]) || "cache".equalsIgnoreCase(args[1]) || "plugins".equalsIgnoreCase(args[1])) {
                    sender.sendMessage(nms.String("CreateWorldToDirs","You create to %world% dirs").replace("%world%",args[1]));
                    return true;
                }

            }
        }
        return true;
    }
    public List<String> onTabComplete(CommandSender sender,Command cmd,String s,String[] args) {
        List<String> ls = new ArrayList<>();
        return ls;
    }
}

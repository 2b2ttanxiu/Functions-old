package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerNMS;
import org.functions.scoreboard.ScoreBoard;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandToggle implements TabExecutor {
    public static void run(JavaPlugin j) {
        j.getCommand("toggle").setTabCompleter(new CommandToggle());
        j.getCommand("toggle").setExecutor(new CommandToggle());
    }
    PlayerNMS nms = new PlayerNMS();
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(nms.nms.String(0, "OnlyPlayer", "§cOnly player execute command!").replace("%player%", sender.getName()));
            return true;
        }
        Configuration config = nms.nms.getData();
        boolean Boolean;
        boolean is;
        if (args.length == 0) {
            sender.sendMessage(nms.nms.String(1,"Usage-Toggle","Usage: /toggle <actionbar|tab|scoreboard>"));
            return true;
        }
        if (args[0].equalsIgnoreCase("tab")) {
            if (!nms.nms.hasPermission(sender.getName(),"functions.command.toggle.*")) {
                if (!nms.nms.hasPermission(sender.getName(), "functions.command.toggle.tab")) {
                    sender.sendMessage(nms.nms.Permission());
                    return true;
                }
            }
                if (config.getBoolean(sender.getName()+".toggle.tab")) {
                    is = true;
                    Boolean = false;
                } else {
                    Boolean = true;
                    is = false;
                    nms.sendTabList(nms.getPlayer(sender),"","");
                }
                config.set(sender.getName()+".toggle.tab",Boolean);
                String b = nms.StringBoolean(is);
                nms.nms.saveData();
                sender.sendMessage(nms.nms.String(1,"Toggle","You toggle {0}{1}").replace("{0}",b).replace("{1}",args[0]));
                return true;
        }
        if ("scoreboard".equalsIgnoreCase(args[0]) || "sb".equalsIgnoreCase(args[0])) {
            if (!nms.nms.hasPermission(sender.getName(),"functions.command.toggle.*")) {
                if (!nms.nms.hasPermission(sender.getName(),"functions.command.toggle.scoreboard")) {
                    sender.sendMessage(nms.nms.Permission());
                    return true;
                }
            }
            if (config.getBoolean(sender.getName()+".toggle.scoreboard")) {
                is = true;
                Boolean = false;
            } else {
                Boolean = true;
                is = false;
                ScoreBoard.cancel(nms.getPlayer(sender));
            }
            config.set(sender.getName()+".toggle.scoreboard",Boolean);
            String b = nms.StringBoolean(is);
            nms.nms.saveData();
            sender.sendMessage(nms.nms.String(1,"Toggle","You toggle {0}{1}").replace("{0}",b).replace("{1}",args[0]));
            return true;
        }
        if ("actionbar".equalsIgnoreCase(args[0]) || "ab".equalsIgnoreCase(args[0])) {
            if (!nms.nms.hasPermission(sender.getName(),"functions.command.toggle.*")) {
                if (!nms.nms.hasPermission(sender.getName(),"functions.command.toggle.actionbar")) {
                    sender.sendMessage(nms.nms.Permission());
                    return true;
                }
            }
            if (config.getBoolean(sender.getName()+".toggle.actionbar")) {
                is = true;
                Boolean = false;
            } else {
                Boolean = true;
                is = false;
            }
            config.set(sender.getName()+".toggle.actionbar",Boolean);
            String b = nms.StringBoolean(is);
            nms.nms.saveData();
            sender.sendMessage(nms.nms.String(1,"Toggle","You toggle {0}{1}").replace("{0}",b).replace("{1}",args[0]));
            return true;
        }
        return true;
    }
    public List<String> onTabComplete(CommandSender sender,Command cmd,String s,String[] args) {
        List<String> ls = new ArrayList<>();
        if (!nms.nms.hasPermission(sender.getName(),"functions.command.toggle.*")) {
            if (nms.nms.hasPermission(sender.getName(),"functions.command.toggle.actionbar")) {
                ls.add("actionbar");
            }
            if (nms.nms.hasPermission(sender.getName(),"functions.command.toggle.scoreboard")) {
                ls.add("scoreboard");
            }
            if (nms.nms.hasPermission(sender.getName(),"functions.command.toggle.tab")) {
                ls.add("tab");
            }
            ls.add("actionbar");
            ls.add("scoreboard");
            ls.add("tab");
        }
        return ls;
    }
}

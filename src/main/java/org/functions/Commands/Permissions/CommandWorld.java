package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerNMS;

import java.util.ArrayList;
import java.util.List;

public class CommandWorld implements TabExecutor {
    PlayerNMS nms = new PlayerNMS();
    public static void run(JavaPlugin j) {
        j.getCommand("world").setExecutor(new CommandWorld());
        j.getCommand("world").setTabCompleter(new CommandWorld());
    }
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        return true;
    }
    public List<String> onTabComplete(CommandSender sender,Command cmd,String s,String[] args) {
        List<String> ls = new ArrayList<>();
        return ls;
    }
}

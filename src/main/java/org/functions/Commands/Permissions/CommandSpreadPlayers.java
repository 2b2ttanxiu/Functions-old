package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerNMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommandSpreadPlayers implements TabExecutor {
    public static void run(JavaPlugin j) {
        j.getCommand("spreadplayers").setExecutor(new CommandSpreadPlayers());
        j.getCommand("spreadplayers").setTabCompleter(new CommandSpreadPlayers());
    }
    PlayerNMS nms = new PlayerNMS();
    public boolean onCommand(CommandSender sender,Command cmd,String s,String[] args) {
        int minloc = Integer.parseInt(args[2]);
        int maxloc = Integer.parseInt(args[3]);
        String ran = "";
        Random r = new Random();
        int max = 0;
        int min = 0;
        for (int i = 0;i < 2;i++) {
            max = r.nextInt(maxloc+1);
            min = r.nextInt(minloc+1);
        }
        for (int i = 0;i <2;i++) {
            if (r.nextInt(2) == 0) {
                if (r.nextInt(2) == 1) {
                    min = Integer.parseInt("-"+min);
                } else {
                    max = Integer.parseInt("-"+max);
                }
            }
        }
        return true;
    }
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        List<String> ls = new ArrayList<>();
        if (args.length == 5) {
            for (Player p : nms.getOnlinePlayers()) {
                ls.add(p.getName());
            }
            return ls;
        }
        return ls;
    }
}

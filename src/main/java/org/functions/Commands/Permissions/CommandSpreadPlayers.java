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
        double minloc = Double.parseDouble(args[1]);
        double maxloc = Double.parseDouble(args[2]);
        Player p = Bukkit.getPlayer(args[0]);
        Random r = new Random();
        World playerWorld = Bukkit.getWorlds().get(0); // 获得主世界
        double randX = r.nextInt(maxloc) - minloc;
        double randZ = r.nextInt(maxloc) - minloc;
        Location offset = new Location(playerWorld, randX, 0, randZ).toHighestLocation(); // 获得最高的非空气方块
        p.teleport(player.getLocation().add(offset)); // add 加算距离
        player.sendMessage(nms.nms.String(1,"SpreadPlayers-Successfully","Successfully players spread players to location.");
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

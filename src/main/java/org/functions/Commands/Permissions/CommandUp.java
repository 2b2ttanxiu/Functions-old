package org.functions.Commands.Permissions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;

public class CommandUp implements CommandExecutor {
    PlayerNMS nms = new PlayerNMS();

    public CommandUp() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        } else {
            Player p = this.nms.getPlayer(sender);
            int y = Integer.parseInt(args[0]);
            int max = p.getLocation().getBlockY() + y;
            if (max > p.getLocation().getWorld().getMaxHeight()) {
                max = p.getLocation().getWorld().getMaxHeight();
            }

            Location l = p.getLocation();
            Location loc = new Location(l.getWorld(), Double.parseDouble(l.getBlockX() + ""), Double.parseDouble(max + ""), Double.parseDouble(l.getBlockZ() + ""));
            p.teleport(loc);
            Block b = p.getLocation().getBlock();
            if (b.getType() == Material.AIR) {
                p.getLocation().getBlock().setType(Material.GLASS);
            }

            return true;
        }
    }
}
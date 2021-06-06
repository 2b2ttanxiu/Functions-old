package org.functions.Listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.functions.API.PlayerNMS;

public class DispenseOn implements Listener {
    private PlayerNMS nms = new PlayerNMS();

    public DispenseOn() {
    }

    @EventHandler
    public void run(BlockDispenseEvent b) {
        if ((b.getBlock().getLocation().getY() == (double)(b.getBlock().getWorld().getMaxHeight() - 1) || b.getBlock().getLocation().getY() == 0.0D || b.getBlock().getLocation().getY() == -64.0D) && b.getItem().getType().name().endsWith("SHULKER_BOX")) {
            b.setCancelled(true);
            String space = ",";
            Location loc = b.getBlock().getLocation();
            String l = loc.getWorld().getName() + space + loc.getX() + space + loc.getY() + space + loc.getZ() + space + loc.getYaw() + space + loc.getPitch();
            String[] Loc = l.split(",");
            this.nms.sendOPs(this.nms.nms.Prefix() + "§c[ERROR] One of the players tried to crash the server! Position: " + this.nms.toLocationString(Loc));
            this.nms.nms.sendConsole(1, "§c[ERROR] One of the players tried to crash the server! Position: " + this.nms.toLocationString(Loc));
        }

    }
}
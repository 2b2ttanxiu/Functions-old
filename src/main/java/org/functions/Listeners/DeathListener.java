package org.functions.Listeners;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.functions.API.PlayerNMS;

public class DeathListener implements Listener {
    private PlayerNMS nms = new PlayerNMS();

    public DeathListener() {
    }

    @EventHandler
    public void run(PlayerDeathEvent b) {
        UUID id = b.getEntity().getUniqueId();
        Location loc = b.getEntity().getLocation();
        String world = loc.getWorld().getName();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        float yaw = loc.getYaw();
        float pitch = loc.getPitch();
        String sp = ",";
        String locs = world + sp + x + sp + y + sp + z + sp + yaw + sp + pitch;
        this.nms.getDeath(id).setDeath(locs);
    }
}
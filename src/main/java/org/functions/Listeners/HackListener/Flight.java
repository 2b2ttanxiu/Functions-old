package org.functions.Listeners.HackListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.functions.API.PlayerNMS;

public class Flight implements Listener {
    PlayerNMS nms = new PlayerNMS();

    public Flight() {
    }

    @EventHandler
    public void run(PlayerMoveEvent b) {
        if (!b.getPlayer().isFlying()) {
            double aa = b.getFrom().getX();
            double ab = b.getFrom().getY();
            double ac = b.getFrom().getZ();
            double ad = b.getTo().getX();
            double ae = b.getTo().getY();
            double af = b.getTo().getZ();
            b.getFrom().getZ();
        }

    }
}
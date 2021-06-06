package org.functions.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.functions.API.CPS;
import org.functions.API.PlayerNMS;

public class ClickListener implements Listener {
    private PlayerNMS nms = new PlayerNMS();
    CPS cps = new CPS();

    public ClickListener() {
    }

    @EventHandler
    public void run(PlayerInteractEvent b) {
        if (b.getAction().toString().contains("CLICK")) {
            this.cps.countCPS();
            this.cps.set(b.getPlayer().getUniqueId());
        }

    }
}
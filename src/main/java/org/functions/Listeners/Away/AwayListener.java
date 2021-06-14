package org.functions.Listeners.Away;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.functions.API.PlayerNMS;

public class AwayListener implements Listener {
    PlayerNMS nms = new PlayerNMS();
    @EventHandler
    public void join(PlayerQuitEvent b) {
        nms.getaway(b.getPlayer().getUniqueId()).resetTime();
        nms.getaway(b.getPlayer().getUniqueId()).cancel();
    }
    @EventHandler
    public void click(PlayerInteractEvent b) {
        nms.getaway(b.getPlayer().getUniqueId()).resetTime();
        nms.getaway(b.getPlayer().getUniqueId()).cancel();
    }
    @EventHandler
    public void chat(AsyncPlayerChatEvent b) {
        nms.getaway(b.getPlayer().getUniqueId()).resetTime();
        nms.getaway(b.getPlayer().getUniqueId()).cancel();
    }
    @EventHandler
    public void drops(PlayerDropItemEvent b) {
        nms.getaway(b.getPlayer().getUniqueId()).resetTime();
        nms.getaway(b.getPlayer().getUniqueId()).cancel();
    }
}

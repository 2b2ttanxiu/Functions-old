package org.functions.Listeners.Shop;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;

public class MenuListener implements Listener {
    @EventHandler
    public void itemdrop(PlayerDropItemEvent event) {
    }
    public void close(InventoryCloseEvent event) {
        if (event.getInventory().equals(InventoryType.PLAYER)) {
            return;
        }
        if (event.getPlayer() instanceof Player) {
            Player p = (Player) event.getPlayer();
        }
    }
    public void drag(InventoryDragEvent event) {
        event.setCancelled(true);
    }
    @EventHandler
    public void click(InventoryClickEvent click) {
        if (click.getInventory().equals(InventoryType.PLAYER)) {
            click.setCancelled(true);
        }
        if (click.getWhoClicked() instanceof Player) {
            Player p = (Player) click.getWhoClicked();
            if (click.isLeftClick()) {
                if (click.isShiftClick()) {
                    click.setCancelled(true);
                }
                click.setCancelled(true);
            }
            if (click.isRightClick()) {
                if (click.isShiftClick()) {
                    click.setCancelled(true);
                }
                click.setCancelled(true);
            }
        }
    }
}

package org.functions.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.functions.API.PlayerManger;
import org.functions.API.PlayerNMS;

public class InventoryClose implements Listener {
    PlayerNMS nms = new PlayerManger();

    public InventoryClose() {
    }

    @EventHandler
    public void run(InventoryCloseEvent b) {
        if (b.getView().getTitle().equals(this.nms.nms.String(0, "AnvilGui", "Anvil Gui")) && b.getInventory().getStorageContents() != null) {
            b.getPlayer().openInventory(b.getInventory());
        }

        if (b.getView().getTitle().equals(this.nms.nms.String(0, "CreativeGui", "Creative Gui")) && b.getInventory().getSize() != 0) {
            b.getPlayer().openInventory(b.getInventory());
        }

        if (b.getView().getTitle().equals(this.nms.nms.String(0, "EnchantingGui", "Enchanting Gui")) && b.getInventory().getSize() != 0) {
            b.getPlayer().openInventory(b.getInventory());
        }

    }
}
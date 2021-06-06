package org.functions.Listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.functions.API.PlayerNMS;

public class GameRuleListener implements Listener {
    PlayerNMS nms = new PlayerNMS();

    public GameRuleListener() {
    }

    @EventHandler
    public void MobGrieving(EntityExplodeEvent b) {
        EntityType type = b.getEntity().getType();
        FileConfiguration set = this.nms.nms.getSettings();
        if (set.getBoolean("GameRule.MobGriefing." + type.toString())) {
            b.setCancelled(true);
        }

    }

    public void KeepInventoryDrops(PlayerDeathEvent b) {
        b.getDrops().clear();
    }

    @EventHandler
    public void KeepInventory(PlayerDeathEvent b) {
        FileConfiguration set = this.nms.nms.getSettings();
        if (set.getBoolean("GameRule.KeepInventory.DropsInventory", set.getBoolean("GameRule.KeepInventory.Inventory"))) {
            b.getDrops().clear();
            if (b.getDrops().size() != 0) {
                b.getDrops().clear();
                if (b.getDrops().size() != 0) {
                    b.getDrops().clear();
                }
            }
            b.setKeepInventory(set.getBoolean("GameRule.KeepInventory.Inventory"));
            b.setKeepLevel(set.getBoolean("GameRule.KeepInventory.Level",set.getBoolean("GameRule.KeepInventory.Inventory")));
            if (set.contains("GameRule.KeepInventory.DroppedXp")) {
                b.setDroppedExp(set.getInt("GameRule.KeepInventory.DroppedXp"));
            }
        }
    }
}
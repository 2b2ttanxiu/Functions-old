package org.functions.Listeners;

import java.util.UUID;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.functions.API.PlayerNMS;

public class StatusListener implements Listener {
    private PlayerNMS nms = new PlayerNMS();
    private UUID id;

    public StatusListener() {
    }

    @EventHandler
    public void mine(BlockBreakEvent b) {
        this.id = b.getPlayer().getUniqueId();
        int i = this.nms.nms.getStatus().getInt(this.id.toString() + ".Block.Mine");
        ++i;
        this.nms.nms.getStatus().set(this.id.toString() + ".Block.Mine", i);
        this.nms.nms.saveStatus();
    }

    @EventHandler
    public void place(BlockPlaceEvent b) {
        this.id = b.getPlayer().getUniqueId();
        int i = this.nms.nms.getStatus().getInt(this.id.toString() + ".Block.Place");
        ++i;
        this.nms.nms.getStatus().set(this.id.toString() + ".Block.Place", i);
        this.nms.nms.saveStatus();
    }

    @EventHandler
    public void death(PlayerDeathEvent b) {
        this.id = b.getEntity().getPlayer().getUniqueId();
        int i = this.nms.nms.getStatus().getInt(this.id.toString() + ".Death");
        ++i;
        this.nms.nms.getStatus().set(this.id.toString() + ".Death", i);
        this.nms.nms.saveStatus();
    }

    @EventHandler
    public void Command(PlayerCommandPreprocessEvent b) {
        this.id = b.getPlayer().getUniqueId();
        int i = this.nms.nms.getStatus().getInt(this.id.toString() + ".Commanded");
        ++i;
        this.nms.nms.getStatus().set(this.id.toString() + ".Commanded", i);
        this.nms.nms.saveStatus();
    }
}

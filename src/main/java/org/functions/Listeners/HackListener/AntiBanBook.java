package org.functions.Listeners.HackListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

public class AntiBanBook implements Listener {
    public AntiBanBook() {
    }

    @EventHandler
    public void run(PlayerEditBookEvent b) {
        b.getPreviousBookMeta();
    }
}

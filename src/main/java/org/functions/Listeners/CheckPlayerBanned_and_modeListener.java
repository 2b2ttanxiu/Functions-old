package org.functions.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import org.functions.Main.Functions;

public class CheckPlayerBanned_and_modeListener implements Listener {
    private Functions a = Functions.getMain();

    public CheckPlayerBanned_and_modeListener() {
    }

    @EventHandler
    public void run(AsyncPlayerPreLoginEvent b) {
        if (this.a.getSettings().getBoolean("Maintenance")) {
            if (!this.a.hasPermission(b.getName(), "functions.maintenance")) {
                b.disallow(Result.KICK_OTHER, this.a.String(1, "Maintenance_ing", "Server of Maintenance ing..."));
            }
        }
    }
}
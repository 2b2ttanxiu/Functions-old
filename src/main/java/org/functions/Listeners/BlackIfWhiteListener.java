package org.functions.Listeners;

import java.util.Iterator;
import java.util.List;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import org.functions.Main.Functions;

public class BlackIfWhiteListener implements Listener {
    private Functions a = Functions.getMain();

    public BlackIfWhiteListener() {
    }

    @EventHandler
    public void run(AsyncPlayerPreLoginEvent b) {
        List<String> WhiteName = this.a.getSettings().getStringList("WhiteName.List");
        boolean black = this.a.getSettings().getBoolean("Banned.Black.Enable");
        boolean white = this.a.getSettings().getBoolean("WhiteName.Enable");
        if (black) {
            if (this.a.getBanned().getString("Banned." + b.getName()) != null) {
                b.disallow(Result.KICK_BANNED, this.a.String(1, "Banned", "You are permanently banned from this server!\n\n\nReason: %reason%").replace("%player%", b.getName()).replace("%reason%", this.a.getBanned().getString("Banned." + b.getName() + ".Reason")));
            }

            if (this.a.getBanned().getString("Banned-ip." + b.getAddress().getHostAddress().replace(".", "'")) != null) {
                b.disallow(Result.KICK_BANNED, this.a.String(1, "Banned", "You are permanently banned from this server!\n\n\nReason: %reason%").replace("%player%", b.getName()).replace("%reason%", this.a.getBanned().getString("Banned-ip." + b.getAddress().getHostAddress().replace(".", "_") + ".Reason")));
            }
        }

        if (white) {
            boolean io = true;
            Iterator var6 = WhiteName.iterator();

            while(var6.hasNext()) {
                String x = (String)var6.next();
                if (x.equals(b.getName())) {
                    io = false;
                }
            }

            if (io) {
                b.disallow(Result.KICK_OTHER, this.a.String(1, "NameNotWhiteName", "You are not add whitelist!\n\n\nPlease contact the server administrators if you believe that this is in error.").replace("%player%", b.getName()));
            }
        }

    }
}
package org.functions.Listeners;

import java.util.Iterator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.functions.Main.Functions;

public class QuitListener implements Listener {
    private Functions a = Functions.getMain();

    public QuitListener() {
    }

    @EventHandler
    public void run(PlayerQuitEvent b) {
        Iterator var2 = this.a.ListGroup().iterator();

        while(var2.hasNext()) {
            String x = (String)var2.next();
            if (this.a.getData().getString(b.getPlayer().getName() + ".Group").equals(x)) {
                if (this.a.getGroup().getString(this.a.getGroup(b.getPlayer().getName()) + ".Format.Quit").equals("none")) {
                    b.setQuitMessage("");
                } else {
                    b.setQuitMessage(this.a.getGroup().getString(x + ".Format.Quit").replace("%player%", b.getPlayer().getName()).replace("%world%", b.getPlayer().getWorld().getName()).replace("%prefix%", this.a.getPrefix(this.a.getGroup(b.getPlayer().getName()), b.getPlayer().getName())).replace("%suffix%", this.a.getSuffix(this.a.getGroup(b.getPlayer().getName()), b.getPlayer().getName())).replace("%date%", this.a.getDate()).replace("%time%", this.a.getTime()).replace("&", "§"));
                }
            }
        }

    }
}

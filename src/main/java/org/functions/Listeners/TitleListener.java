package org.functions.Listeners;

import java.io.File;
import java.util.List;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.util.CachedServerIcon;
import org.functions.Main.Functions;
import org.functions.Tools.TPS;

public class TitleListener implements Listener {
    private Functions a = Functions.getMain();

    public TitleListener() {
    }

    @EventHandler
    public void run(ServerListPingEvent b) throws Exception {
        if (this.a.getSettings().getBoolean("Maintenance")) {
            List<String> ls = a.getTitle().getStringList("Smode.List." + this.a.getTitle().getString("Enabled"));
            String motd = ls.get(a.getTitle().getInt("TitleLine"));
            b.setMotd(motd.replace("&", "§").replace("%max%", b.getMaxPlayers() + "").replace("%online%", b.getNumPlayers() + "").replace("/n", "\n").replace("%server%", this.a.getServerName()).replace("%date%", this.a.getDate()).replace("%time%", this.a.getTime()).replace("%tps%", a.nms().getTPS()).replace("%prefix_my%", this.a.Prefix()).replace("%starttime%", this.a.getStartTime()));
            b.setMaxPlayers(this.a.getTitle().getInt("Smode.MaxPlayers"));
            CachedServerIcon c = this.a.getServer().loadServerIcon(new File(this.a.getDataFolder(), "serviceModeIcon.png"));
            b.setServerIcon(c);
            return;
        }

        List<String> ls = this.a.getTitle().getStringList("Title.List." + this.a.getTitle().getString("Enabled"));
        String motd = ls.get(a.getTitle().getInt("TitleLine"));
        b.setMotd(motd.replace("&", "§").replace("%max%", b.getMaxPlayers() + "").replace("%online%", b.getNumPlayers() + "").replace("/n", "\n").replace("%server%", this.a.getServerName()).replace("%date%", this.a.getDate()).replace("%time%", this.a.getTime()).replace("%prefix_my%", this.a.Prefix()).replace("%tps%", a.nms().getTPS()).replace("%starttime%", this.a.getStartTime()));
        b.setMaxPlayers(this.a.getTitle().getInt("MaxPlayers"));
        CachedServerIcon c = null;
        c = this.a.getServer().loadServerIcon(new File(this.a.getDataFolder(), "server-icon.png"));
        b.setServerIcon(c);
    }
}
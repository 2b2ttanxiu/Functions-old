package org.functions.Listeners;

import java.util.Iterator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.functions.Main.Functions;
import org.functions.Tools.GameModeAPI;

public class JoinListener implements Listener {
    private Functions a = Functions.getMain();
    private long Long = System.currentTimeMillis();

    public JoinListener() {
    }

    @EventHandler
    public void run(PlayerJoinEvent b) {
        if (this.a.getData().getString(b.getPlayer().getName()) == null) {
            this.a.getData().set(b.getPlayer().getName() + ".Group", this.a.getSettings().getString("Join.Group"));
            this.a.getData().set(b.getPlayer().getName() + ".Type.Chat", this.a.getSettings().getString("Join.Type.Chat"));
            this.a.SaveConfig();
        }
        if (a.getSettings().getBoolean("Join.forceGameMode")) {
            GameModeAPI.GameModeAPI(b.getPlayer(), this.a.getSettings().getInt("Join.forceGameMode"));
        }
        this.a.getData().set(b.getPlayer().getName() + ".ChatTime", this.Long);
        this.a.getData().set(b.getPlayer().getName() + ".CommandTime", this.Long);
        this.a.SaveConfig();
        Iterator var2 = this.a.ListGroup().iterator();

        while(var2.hasNext()) {
            String x = (String)var2.next();
            if (this.a.getData().getString(b.getPlayer().getName() + ".Group").equals(x)) {
                if (this.a.getGroup().getString(this.a.getGroup(b.getPlayer().getName()) + ".Format.Join").equals("none")) {
                    b.setJoinMessage("");
                } else {
                    b.setJoinMessage(this.a.getGroup().getString(x + ".Format.Join").replace("%player%", b.getPlayer().getName()).replace("%world%", b.getPlayer().getWorld().getName()).replace("%prefix%", this.a.getPrefix(this.a.getGroup(b.getPlayer().getName()), b.getPlayer().getName())).replace("%suffix%", this.a.getSuffix(this.a.getGroup(b.getPlayer().getName()), b.getPlayer().getName())).replace("%date%", this.a.getDate()).replace("%time%", this.a.getTime()).replace("&", "§"));
                }
            }
        }

        if (this.a.getData().getBoolean(b.getPlayer().getName() + ".Info.Enable")) {
            b.getPlayer().sendMessage(this.a.String(1, "Information-true", "Your have new information.Please keep your eyes open").replace("%player%", b.getPlayer().getName()));
        } else {
            b.getPlayer().sendMessage(this.a.String(1, "Information-false", "Your have no new information to check").replace("%player%", b.getPlayer().getName()));
        }

        if (!this.a.getGroup().getString(this.a.getGroup(b.getPlayer().getName()) + ".Message_Welcome").equals("none")) {
            String msg = this.a.getGroup().getString(this.a.getGroup(b.getPlayer().getName()) + ".Message_Welcome").replace("%online%", this.a.OnlinePlayers(b.getPlayer().getName())).replace("%tps%", a.nms().getTPS()).replace("%servername%", this.a.getServerName()).replace("%player%", b.getPlayer().getName()).replace("/n", "\n").replace("&", "§");
            b.getPlayer().sendMessage(a.nms().replace(b.getPlayer(),msg));
        }

        if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("Private")) {
            b.getPlayer().sendMessage(this.a.String(1, "Type-Chat", "You Chat Channel is a %type% channel").replace("%type%", "Private").replace("%player%", b.getPlayer().getName()));
        }

        if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("Group")) {
            b.getPlayer().sendMessage(this.a.String(1, "Type-Chat", "You Chat Channel is a %type% channel").replace("%type%", "Group").replace("%player%", b.getPlayer().getName()));
        }

        if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("World")) {
            b.getPlayer().sendMessage(this.a.String(1, "Type-Chat", "You Chat Channel is a %type% channel").replace("%type%", "World").replace("%player%", b.getPlayer().getName()));
        }

        if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("Public")) {
            b.getPlayer().sendMessage(this.a.String(1, "Type-Chat", "You Chat Channel is a %type% channel").replace("%type%", "Public").replace("%player%", b.getPlayer().getName()));
        }

    }
}
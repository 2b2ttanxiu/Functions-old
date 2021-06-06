package org.functions.Listeners;

import java.util.Iterator;
import java.util.List;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.functions.Main.Functions;

public class CommandListener implements Listener {
    private Functions a = Functions.getMain();

    public CommandListener() {
    }

    @EventHandler
    public void run(PlayerCommandPreprocessEvent b) {
        long Long = System.currentTimeMillis();
        long l = this.a.getData().getLong(b.getPlayer().getName() + ".CommandTime");
        long L = Long - l;
        Iterator var8 = this.a.ListGroup().iterator();

        while(var8.hasNext()) {
            String x = (String)var8.next();
            if (this.a.getData().getString(b.getPlayer().getName() + ".Group").equals(x) && !this.a.getGroup().getString(x + ".Delay.CommandTime").equals("none")) {
                if (L <= this.a.getGroup().getLong(x + ".Delay.CommandTime")) {
                    b.getPlayer().sendMessage(this.a.String(1, "DelayChat", "Please wait %delay%s!").replace("%delay%", "" + ((double)this.a.getGroup().getLong(x + ".Delay.CommandTime") - ((double)Long - (double)l)) / 1000.0D));
                    b.setCancelled(true);
                } else {
                    this.a.getData().set(b.getPlayer().getName() + ".CommandTime", Long);
                    this.a.SaveConfig();
                }
            }
        }

        String cmd = b.getMessage().split(" ")[0].replace("/", "");
        List<String> White_Command = this.a.getSettings().getStringList("Command.White.List");
        List<String> Black_Command = this.a.getSettings().getStringList("Command.Black.List");
        boolean black = this.a.getSettings().getBoolean("Command.Black.Enable");
        boolean white = this.a.getSettings().getBoolean("Command.White.Enable");
        Iterator var15;
        String x;
        if (black) {
            var15 = Black_Command.iterator();

            while(var15.hasNext()) {
                x = (String)var15.next();
                boolean is;
                if (x.equals(cmd)) {
                    is = true;
                } else {
                    is = false;
                }

                if (is) {
                    b.setCancelled(true);
                    b.getPlayer().sendMessage(this.a.String(1, "CommandIfBlack", "I'm sorry, but you do not have permission to perform %command%.Please contact the server administrators if you believe that this is in error.").replace("%player%", b.getPlayer().getName()).replace("%command%", cmd));
                }
            }
        }

        if (white) {
            boolean io = true;
            var15 = White_Command.iterator();

            while(var15.hasNext()) {
                x = (String)var15.next();
                if (x.equals(cmd)) {
                    io = false;
                }
            }

            if (io) {
                b.setCancelled(true);
                b.getPlayer().sendMessage(this.a.String(1, "CommandIfWhite", "I'm sorry, but you do not have permission to perform %command%.Please contact the server administrators if you believe that this is in error.").replace("%player%", b.getPlayer().getName()).replace("%command%", cmd));
            }
        }

    }
}
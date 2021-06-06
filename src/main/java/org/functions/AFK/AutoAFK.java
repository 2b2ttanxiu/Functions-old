package org.functions.AFK;

import java.util.Iterator;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class AutoAFK implements Runnable {
    public AutoAFK() {
    }

    public static boolean AFK(String DisplayName) {
        boolean inf = false;
        if (Functions.getMain().getData().getBoolean(DisplayName + ".AFK.CommandAFK")) {
            inf = true;
        }

        return inf;
    }

    public static void setAFK(String DisplayName) {
        if (!AFK(DisplayName)) {
            if (!Functions.getMain().getData().getBoolean(".AFK.AutoAFK")) {
                Functions.getMain().getData().set(DisplayName + ".AFK.AutoAFK", true);
                Functions.getMain().SaveConfig();
            }
        }
    }

    public void run() {
        Iterator var1 = Functions.getMain().getServer().getOnlinePlayers().iterator();

        while(var1.hasNext()) {
            Player p = (Player)var1.next();
            if (Functions.getMain().getData().getBoolean(p.getName() + ".AFK.ifAFK")) {
                Functions.getMain().getData().set(p.getName() + ".AFK.interval", 0);
            }

            Functions.getMain().getData().set(p.getName() + ".AFK.ifAFK", false);
            if (!Functions.getMain().getData().getBoolean(p.getName() + ".AFK.ifAFK")) {
                int i = Functions.getMain().getData().getInt(p.getName() + ".AFK.interval") + 1;
                Functions.getMain().getData().set(p.getName() + ".AFK.interval", i);
            }

            if (Functions.getMain().getSettings().getInt("AFK.interval") <= Functions.getMain().getData().getInt(p.getName() + ".AFK.interval")) {
                setAFK(p.getName());
            }
        }

        Functions.getMain().SaveConfig();
    }
}
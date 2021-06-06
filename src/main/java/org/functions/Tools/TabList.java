package org.functions.Tools;

import java.util.Iterator;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;
import org.functions.API.WorldTime;
import org.functions.Main.Functions;
import org.functions.net.minecraft.server.Handler;

public class TabList implements Runnable {
    private Functions a = Functions.getMain();
    private PlayerNMS nms = new PlayerNMS();

    public TabList() {
    }

    public void run() {
        Iterator var1 = this.a.getServer().getOnlinePlayers().iterator();
        WorldTime t = new WorldTime();
        while(var1.hasNext()) {
            Player p = (Player)var1.next();
            if (this.a.getTab().getBoolean("TabList")) {
                World world = p.getWorld();
                this.nms.sendTabList(p, this.nms.TabListHeader(p).replace("%worldtime%", t.get(world.getTime() / 20 * 1200 + (60000 * 6))).replace("%worldday%", world.getFullTime() / 18000L+""), this.nms.TabListFooter(p).replace("%worldtime%", t.get(world.getTime() / 20 * 1200 + (60000 * 6))).replace("%worldday%", world.getFullTime() / 18000L+""));
            }

            String str = this.nms.ActionBar(p);
            if (str.equals("none")) {
                return;
            }

            Handler handler = new Handler();
            handler.sendActionBar(p, str);
        }

    }
}
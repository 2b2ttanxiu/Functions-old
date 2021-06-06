package org.functions.Utlis;

import java.util.Iterator;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Users extends User implements Runnable {
    public Users() {
    }

    public void run() {
        this.initUser();
    }

    public void initUser() {
        Iterator var1 = this.nms.getOnlinePlayers().iterator();

        while(var1.hasNext()) {
            Player p = (Player)var1.next();
            this.init(p);
        }

        OfflinePlayer[] var5 = this.nms.getOffline();
        int var6 = var5.length;

        for(int var3 = 0; var3 < var6; ++var3) {
            OfflinePlayer p = var5[var3];
            this.init(this.nms.getServer().getOfflinePlayer(p.getUniqueId()).getPlayer());
        }

    }
}
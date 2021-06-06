package org.functions.Tools;

import java.util.Iterator;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class TabCheck implements Runnable {
    private Functions a = Functions.getMain();
    private int i = 0;

    public TabCheck() {
    }

    public void run() {
        Iterator var1 = this.a.getServer().getOnlinePlayers().iterator();

        while(var1.hasNext()) {
            Player p = (Player)var1.next();
            ++this.i;
            String DisplayName = p.getName();
            String PlayerPrefix = this.a.getPrefix(this.a.getGroup(DisplayName), DisplayName);
            String PlayerSuffix = this.a.getSuffix(this.a.getGroup(DisplayName), DisplayName);
            String PlayerPing = getPing.getPing(p) + "";
            String PlayerHealth = (int)p.getHealth() + "";
            String PlayerLevel = p.getLevel() + 1 + "";
            String ListPlayer = this.a.getTab().getString("TabListPlayer").replace("&", "§").replace("%player%", DisplayName).replace("%suffix%", PlayerSuffix).replace("%prefix%", PlayerPrefix).replace("%level%", PlayerLevel).replace("%health%", PlayerHealth).replace("%ping%", PlayerPing);
            p.setPlayerListName(ListPlayer);
            p.setCustomName(ListPlayer);
            p.setCustomNameVisible(true);
            p.showPlayer(this.a, p);
            p.hidePlayer(this.a, p);
        }

    }
}
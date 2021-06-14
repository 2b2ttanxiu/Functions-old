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
        for (Player p : a.getServer().getOnlinePlayers()) {
            ++this.i;
            String DisplayName = p.getName();
            String PlayerPrefix = this.a.getPrefix(this.a.getGroup(DisplayName), DisplayName);
            String PlayerSuffix = this.a.getSuffix(this.a.getGroup(DisplayName), DisplayName);
            String PlayerPing = getPing.getPing(p) + "";
            String PlayerHealth = (int)p.getHealth() + "";
            String PlayerLevel = p.getLevel() + 1 + "";
            String ListPlayer = this.a.getTab().getString("TabListPlayer").replace("&", "§").replace("%player%", DisplayName).replace("%suffix%", PlayerSuffix).replace("%prefix%", PlayerPrefix).replace("%level%", PlayerLevel).replace("%health%", PlayerHealth).replace("%ping%", PlayerPing);
            //p.setPlayerListName(ListPlayer);
            //p.setDisplayName(ListPlayer);
            //p.setCustomName(ListPlayer);
            //p.setCustomNameVisible(true);
            //a.sendConsole(1,"test");
            //a.nms().setDisplayName(p.getUniqueId()).setAll();
            //a.sendConsole(1,"a");
            //p.showPlayer(a, p);
            //p.hidePlayer(a, p);
        }

    }
}
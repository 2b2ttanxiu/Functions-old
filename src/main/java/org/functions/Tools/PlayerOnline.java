package org.functions.Tools;

import java.util.Iterator;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;
import org.functions.money.Money;

public class PlayerOnline implements Runnable {
    private Functions a = Functions.getMain();

    public PlayerOnline() {
    }

    public void run() {
        Iterator var1 = this.a.getServer().getOnlinePlayers().iterator();

        while(var1.hasNext()) {
            Player p = (Player)var1.next();
            Iterator var3;
            String x;
            if (p.isOp()) {
                if (this.a.getOP().getStringList("Administrators").size() == 0) {
                    p.setOp(false);
                }

                var3 = this.a.getOP().getStringList("Administrators").iterator();

                while(var3.hasNext()) {
                    x = (String)var3.next();
                    if (!x.equals(p.getName())) {
                        p.setOp(false);
                    }
                }
            }

            if (!p.isOp()) {
                var3 = this.a.getOP().getStringList("Administrators").iterator();

                while(var3.hasNext()) {
                    x = (String)var3.next();
                    if (x.equals(p.getName())) {
                        p.setOp(true);
                    }
                }
            }
            Money m = new Money(p.getUniqueId());
            m.checkMoney();
            CheckData data = new CheckData(p);
            data.run();
            if (this.a.getBanned().getString("Banned." + p.getName()) != null) {
                p.kickPlayer(this.a.String(1, "Banned", "You are permanently banned from this server!\n\n\nReason: %reason%").replace("%player%", p.getName()).replace("%reason%", this.a.getBanned().getString("Banned." + p.getName() + ".Reason")));
            }

            if (this.a.getBanned().getString("Banned-ip." + p.getAddress().getAddress().getHostAddress().replace(".", "_")) != null) {
                p.kickPlayer(this.a.String(1, "Banned", "You are permanently banned from this server!\n\n\nReason: %reason%").replace("%player%", p.getName()).replace("%reason%", this.a.getBanned().getString("Banned-ip." + p.getAddress().getAddress().getHostAddress().replace(".", "_") + ".Reason")));
            }
        }

    }
}
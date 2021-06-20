package org.functions.Tools;

import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;

import java.util.UUID;

public class AwayRunnable implements Runnable{
    PlayerNMS nms = new PlayerNMS();
    public void run() {
        if (!nms.nms.getSettings().getBoolean("AwayFromKeyBoard.enable")) return;
        for (Player p : nms.getOnlinePlayers()) {
            UUID uuid = p.getUniqueId();
            if (nms.getaway(p.getUniqueId()).getTime()==0) {
                p.sendMessage(nms.replace(p,nms.nms.String(1,"QuitAfk","You quit the away from keyboard.")));
                return;
            }
            nms.getaway(p.getUniqueId()).addTime();
            if (nms.getaway(p.getUniqueId()).getTime() == nms.nms.getSettings().getInt("AwayFromKeyBoard.StartCount")) {
                nms.getaway(p.getUniqueId()).setType(org.functions.API.AFK.Away.Type.AWAY);
                p.sendMessage(nms.replace(p,nms.nms.String(1,"StartAfk","You away from keyboard.")));
                return;
            }
            for (String s : nms.nms.getSettings().getStringList("AwayFromKeyBoard.Texts")) {
                int t = Integer.parseInt(s.split(":")[0]);
                String txt = s.split(":")[1];
                if ((nms.getaway(uuid).getTime() - nms.nms.getSettings().getInt("AwayFromKeyBoard.StartCount")) == t) {
                    p.sendMessage(nms.replace(p,nms.nms.Prefix() + txt));
                }
            }
            if ((nms.getaway(uuid).getTime() - nms.nms.getSettings().getInt("AwayFromKeyBoard.StartCount")) >= nms.nms.getSettings().getInt("AwayFromKeyBoard.TimeoutKick")) {
                p.kickPlayer(nms.replace(p,nms.nms.Prefix() + nms.nms.getSettings().getString("AwayFromKeyBoard.KickMessage")));
            }
        }
    }
}

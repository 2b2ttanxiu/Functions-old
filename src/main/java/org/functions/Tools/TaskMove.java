package org.functions.Tools;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;

public class TaskMove implements Runnable {
    PlayerNMS nms = new PlayerNMS();
    public void run() {
        for (Player p : nms.getOnlinePlayers()) {
            Location old = p.getLocation();
            //if (old.equals(p.get))
        }
    }
}

package org.functions.Tools;

import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;
import org.functions.scoreboard.ScoreBoard;

public class OnScoreBoard implements Runnable {
    PlayerNMS nms = new PlayerNMS();
    public void run() {
        for (Player p : nms.getOnlinePlayers()) {
            ScoreBoard.run(p);
        }
    }
}

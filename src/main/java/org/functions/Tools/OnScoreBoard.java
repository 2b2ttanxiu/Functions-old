package org.functions.Tools;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.functions.API.PlayerDisplay;
import org.functions.API.PlayerNMS;
import org.functions.scoreboard.ScoreBoard;

public class OnScoreBoard implements Runnable {
    PlayerNMS nms = new PlayerNMS();
    public void run() {
        for (Player pl : nms.getOnlinePlayers()) {
            if (!nms.nms.getData().getBoolean(pl.getName()+".toggle.scoreboard")) {
                ScoreBoard.run(pl);
            } else {
                Scoreboard b = nms.getServer().getScoreboardManager().getNewScoreboard();
                for (Player p : nms.getOnlinePlayers()) {
                    Team team = b.registerNewTeam(p.getName());
                    PlayerDisplay d = nms.getPlayerDisplay(p.getUniqueId());
                    team.setPrefix(d.getPrefix());
                    team.setSuffix(d.getSuffix());
                    team.addEntry(p.getName());
                }
                pl.setScoreboard(b);
            }
        }
    }
}

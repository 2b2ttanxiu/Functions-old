package org.functions.scoreboard;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.functions.API.PlayerManger;
import org.functions.API.PlayerNMS;

public class ScoreBoard {
    static List<String> score = new ArrayList();
    static PlayerNMS nms = new PlayerManger();

    public ScoreBoard() {
    }

    public static void run(Player player) {
        Scoreboard b = nms.getServer().getScoreboardManager().getNewScoreboard();
        Objective obj = b.registerNewObjective("Functions", "dummy");
        if (nms.nms.getGroup().getBoolean(nms.nms.getGroup(player.getName()) + ".ScoreBoardEnabled")) {
            if (nms.nms.getData().getBoolean(player.getName() + ".HideScoreBoard", true)) {
                if (player.getScoreboard().getObjective(DisplaySlot.SIDEBAR) != null) {
                    player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).unregister();
                    player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
                }

                score = nms.nms.getGroup().getStringList(nms.nms.getGroup(player.getName()) + ".ScoreBoard");
                int i = score.size();
                String title = nms.nms.getGroup().getString(nms.nms.getGroup(player.getName()) + ".ScoreBoardDisplayName");
                obj.setDisplayName(nms.replace(player, title));
                obj.setDisplaySlot(DisplaySlot.SIDEBAR);

                for(int s = 0; s < i; ++s) {
                    String sf = nms.replace(player, (String)score.get(s));
                    Score sc = obj.getScore(nms.replace(player,sf));
                    sc.setScore(i - s - 1);
                }

                player.setScoreboard(b);
                return;
            }

            if (player.getScoreboard().getObjective(DisplaySlot.SIDEBAR) != null) {
                player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).unregister();
                player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
            }
        }

        if (player.getScoreboard().getObjective(DisplaySlot.SIDEBAR) != null) {
            player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).unregister();
            player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
        }

    }
}
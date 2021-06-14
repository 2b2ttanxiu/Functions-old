package org.functions.scoreboard;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.functions.API.PlayerDisplay;
import org.functions.API.PlayerManger;
import org.functions.API.PlayerNMS;

public class ScoreBoard {
    static List<String> score = new ArrayList();
    static PlayerNMS nms = new PlayerManger();
    public static void cancel(Player p) {
        Scoreboard b = nms.getServer().getScoreboardManager().getNewScoreboard();
        b.clearSlot(DisplaySlot.SIDEBAR);
        p.setScoreboard(b);
    }
    public static void run(Player player) {
        Scoreboard b = nms.getServer().getScoreboardManager().getNewScoreboard();
        Objective obj = b.registerNewObjective("Functions", "dummy");
        if (nms.nms.getGroup().getBoolean(nms.nms.getGroup(player.getName()) + ".ScoreBoardEnabled")) {
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
                for (Player p : nms.getOnlinePlayers()) {
                    Team team = b.registerNewTeam(p.getName());
                    PlayerDisplay d = nms.getPlayerDisplay(p.getUniqueId());
                    team.setPrefix(d.getPrefix());
                    team.setSuffix(d.getSuffix());
                    team.addEntry(p.getName());
                }
                player.setScoreboard(b);
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
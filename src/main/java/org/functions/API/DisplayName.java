package org.functions.API;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.functions.scoreboard.ScoreBoard;

import java.util.UUID;

public class DisplayName {
    UUID uuid;
    String me;
    Player p;
    PlayerNMS nms = new PlayerNMS();
    ScoreboardManager sc;
    Team team;
    Scoreboard teamb;
    String suffix;
    String prefix;
    public DisplayName(UUID uuid) {
        this.uuid = uuid;
        p = nms.getPlayer(uuid);
        me = p.getName();
        sc = nms.getServer().getScoreboardManager();
        teamb = sc.getNewScoreboard();
        team = teamb.registerNewTeam(me);
        team.addEntry(me);
        PlayerDisplay d = nms.getPlayerDisplay(uuid);
        suffix = d.getSuffix();
        prefix = d.getSuffix();
    }
    public void setAll() {
        team.setPrefix(suffix);
        team.setPrefix(prefix);
        p.setScoreboard(teamb);
    }
    public void setSuffix() {

    }
    public void cancel() {
        team.removeEntry(me);
    }
}

package org.functions.Tools;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.functions.API.PlayerNMS;
import org.functions.Main.Functions;
import org.functions.Utlis.DrewMath;

import java.util.List;

public class DisplayScoreBoard {
    Scoreboard board;
    String name;
    String type;
    boolean is;
    boolean run;

    public DisplayScoreBoard(ScoreboardManager manager, String DisplayScoreBoardName, String TypeScoreBoard) {
        this.board = manager.getNewScoreboard();
        this.name = DisplayScoreBoardName;
        this.type = TypeScoreBoard;
    }

    public void setRun(boolean run) {
        this.is = run;
    }

    public void run(Player Player, List<String> score) {
        if (this.is) {
            Objective objective = this.board.registerNewObjective("FunctionsBoard", this.type);
            objective.setDisplayName(this.name);
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            int i = score.size();
            PlayerNMS nms = new PlayerNMS();
            Status status = new Status(Player.getUniqueId(), nms);
            String DisplayName = Player.getName();
            String PlayerPrefix = nms.nms.getPrefix(nms.nms.getGroup(DisplayName), DisplayName);
            String PlayerSuffix = nms.nms.getSuffix(nms.nms.getGroup(DisplayName), DisplayName);
            double health = Player.getMaxHealth();
            double Health = Player.getHealth();
            double AutoHealth = DrewMath.round(Health / health * 100.0D, 1);

            for(int s = 0; s < i; ++s) {
                Score sc = objective.getScore(((String)score.get(s)).replace("&", "§").replace("%group%", Functions.getMain().getGroup(Player.getName())).replace("%prefix%", PlayerPrefix).replace("%suffix%", PlayerSuffix).replace("%ping%", nms.ping(Player)).replace("%tps%", TPS.TPS()).replace("%online%", nms.getOnline() + "").replace("%player%", Player.getName()).replace("%displayname%", PlayerPrefix + Player.getName() + PlayerSuffix).replace("%autoHealth%", AutoHealth + "").replace("%status%", status.getStatus()));
                sc.setScore(i - s - 1);
            }

            Player.setScoreboard(this.board);
            this.run = true;
        } else if (this.run) {
            this.board.clearSlot(DisplaySlot.SIDEBAR);
            Player.setScoreboard(this.board);
            this.run = false;
        }

    }
}
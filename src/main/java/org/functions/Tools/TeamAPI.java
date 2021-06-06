package org.functions.Tools;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.functions.Main.Functions;

public class TeamAPI implements Runnable {
    public TeamAPI() {
    }

    public void run() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Functions.getMain().sendConsole(1, "Team 1");
        Iterator var2 = Functions.getMain().getServer().getOnlinePlayers().iterator();

        while (var2.hasNext()) {
            Player p = (Player) var2.next();
            Scoreboard team = manager.getNewScoreboard();
            Functions.getMain().sendConsole(1, "Team 2");
            team.registerNewTeam(p.getName());
            team.getTeam(p.getName()).addEntry(p.getName());
            Functions.getMain().sendConsole(1, "Team 3");
            team.getTeam(p.getName()).setPrefix(Functions.getMain().getPrefix(Functions.getMain().getGroup(p.getName()), p.getName()));
            Functions.getMain().sendConsole(1, "Team 4");
            team.getTeam(p.getName()).setSuffix(Functions.getMain().getPrefix(Functions.getMain().getGroup(p.getName()), p.getName()));
            Functions.getMain().sendConsole(1, "Team 5");
        }

    }
}
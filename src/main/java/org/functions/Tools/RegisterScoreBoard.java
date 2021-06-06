package org.functions.Tools;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.ScoreboardManager;

public class RegisterScoreBoard {
    ScoreboardManager boards;
    String name;
    String type;
    Player ps;
    List<String> score;

    public RegisterScoreBoard(ScoreboardManager manager, String DisplayScoreBoardName, String TypeScoreBoard, Player p, List<String> scores) {
        this.boards = manager;
        this.name = DisplayScoreBoardName;
        this.type = TypeScoreBoard;
        this.ps = p;
        this.score = scores;
    }

    public void register() {
        DisplayScoreBoard board = new DisplayScoreBoard(this.boards, this.name, this.type);
        board.setRun(true);
        board.run(this.ps, this.score);
    }

    public void unregister() {
        DisplayScoreBoard board = new DisplayScoreBoard(this.boards, this.name, this.type);
        board.setRun(false);
        board.run(this.ps, this.score);
    }
}

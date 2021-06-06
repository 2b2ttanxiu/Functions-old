package org.functions.Tools;

import org.bukkit.entity.Player;
import org.functions.API.PlayerManger;

public class CheckData {
    PlayerManger nms = new PlayerManger();
    Player p;
    public CheckData(Player p) {
        this.p = p;
    }
    public void run() {
            nms.nms.getData().addDefault(p.getName() + ".Group", nms.nms.getSettings().getString("Join.Group"));
            nms.nms.getData().addDefault(p.getName() + ".Type.Chat", nms.nms.getSettings().getString("Join.Type.Chat"));
            nms.nms.getData().options().copyDefaults(true);
            nms.nms.getData().options().copyHeader();
            nms.nms.SaveConfig();
        }
    }

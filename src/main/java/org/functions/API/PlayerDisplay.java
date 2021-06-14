package org.functions.API;

import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;

import java.util.UUID;

public class PlayerDisplay {
    PlayerNMS nms = new PlayerNMS();
    UUID uuid;
    Player p;
    String me;
    String Suffix;
    String Prefix;
    String format;
    public PlayerDisplay(UUID uuid) {
        this.uuid = uuid;
        p = nms.getPlayer(uuid);
        me = p.getName();
        Suffix = nms.nms.getSuffix(me);
        Prefix = nms.nms.getPrefix(me);
    }
    public String getSuffix() {return Suffix;}
    public String getPrefix() {return Prefix;}
}

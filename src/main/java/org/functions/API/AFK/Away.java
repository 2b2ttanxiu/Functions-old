package org.functions.API.AFK;

import org.bukkit.configuration.Configuration;
import org.functions.API.PlayerNMS;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Away{
    UUID uuid;
    Type type;
    boolean task;
    public enum Type {
        AWAY,
        NULL,
        NONE
    }
    PlayerNMS nms = new PlayerNMS();
    Configuration main = nms.nms.getAway();
    Configuration settings = nms.nms.getSettings();
    public Away(UUID uuid) {
        this.uuid = uuid;
    }
    public void setType(Type type) {
        main.set(uuid+".Type",type+"");
        save();
    }
    public void setTime(long time) {
        main.set(uuid+".Time",time);
        save();
    }
    public Type getType() {
        return (Type)main.get(uuid+".Type");
    }
    public void cancel() {
        main.set(uuid+".Type",Type.NONE);
        save();
    }
    public void run() {
        main.set(uuid+".Type",Type.AWAY);
        save();
    }
    public void save() {
        try {
            nms.nms.getAway().save(new File(nms.nms.getDataFolder(),"AwayFromKeyBoard.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addTime() {
        int i = main.getInt(uuid+".count");
        i = i + 1;
        main.set(uuid+".count",i);
        save();
    }
    public int getTime() {
        return main.getInt(uuid+".count");
    }
    public void resetTime() {
        main.set(uuid+".count",0);
        save();
    }
}

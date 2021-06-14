package org.functions.API.AFK;

import org.functions.API.PlayerNMS;

import java.util.UUID;

public class Away{
    UUID uuid;
    Type type;
    boolean task;
    enum Type {
        COMMAND,
        AWAY,
    }
    PlayerNMS nms = new PlayerNMS();
    public Away(UUID uuid) {
        this.uuid = uuid;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Type getType() {
        return type;
    }
    public void cancel() {
        task = false;
    }
    public void setTask(boolean task) {
        this.task = task;
    }
    public boolean getTask() {
        return task;
    }
}

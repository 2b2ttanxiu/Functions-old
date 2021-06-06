package org.functions.Tools;

import java.util.UUID;
import org.functions.API.PlayerNMS;

public class Status {
    UUID id;
    PlayerNMS nms;

    public Status(UUID id, PlayerNMS nms) {
        this.id = id;
        this.nms = nms;
    }

    public int getDeath() {
        return this.nms.nms.getStatus().getInt(this.id.toString() + ".Death");
    }

    public int getCommanded() {
        return this.nms.nms.getStatus().getInt(this.id.toString() + ".Commanded");
    }

    public int getBlock(StatusType type) {
        if (type == StatusType.MINE) {
            return this.nms.nms.getStatus().getInt(this.id.toString() + ".Block.Mine");
        } else {
            return type == StatusType.PLACE ? this.nms.nms.getStatus().getInt(this.id.toString() + ".Block.Place") : -1;
        }
    }

    public int getStatusType(StatusType type) {
        if (type == StatusType.MINE) {
            return this.nms.nms.getStatus().getInt(this.id.toString() + ".Block.Mine");
        } else if (type == StatusType.PLACE) {
            return this.nms.nms.getStatus().getInt(this.id.toString() + ".Block.Place");
        } else if (type == StatusType.DEATH) {
            return this.nms.nms.getStatus().getInt(this.id.toString() + ".Death");
        } else if (type == StatusType.COMMANDED) {
            return this.nms.nms.getStatus().getInt(this.id.toString() + ".Commanded");
        } else if (type == StatusType.JOIN) {
            return this.nms.nms.getStatus().getInt(this.id.toString() + ".Join");
        } else {
            return type == StatusType.QUIT ? this.nms.nms.getStatus().getInt(this.id.toString() + ".Quit") : -1;
        }
    }

    public String getStatus() {
        return this.nms.nms.getSettings().getString("List.Status").replace("%death%", this.getDeath() + "").replace("%commanded%", this.getCommanded() + "").replace("%mineblock%", this.getBlock(StatusType.MINE) + "").replace("%placeblock%", this.getBlock(StatusType.PLACE) + "");
    }
}
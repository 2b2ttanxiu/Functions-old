package org.functions.API;

import org.bukkit.entity.Player;

public class AutoMessage {
    public AutoMessage() {
    }

    public void sendMessage(Object Object, String Message) {
        ((Player)Object).sendMessage(Message);
    }
}

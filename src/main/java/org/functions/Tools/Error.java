package org.functions.Tools;

import org.functions.Main.Functions;
import org.functions.net.minecraft.server.Message;

public class Error {
    public Error(Message Message) {
    }

    public void send(Message message) {
        Error error = new Error(message);
        Functions.getMain().sendConsole(1, "§c" + error + "");
    }
}

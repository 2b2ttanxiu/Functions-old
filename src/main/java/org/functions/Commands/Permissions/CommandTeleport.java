package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.functions.API.PlayerNMS;
import org.functions.Main.Functions;

public class CommandTeleport implements CommandExecutor {
    private Functions a = Functions.getMain();
    private PlayerNMS nms = new PlayerNMS();

    public CommandTeleport() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        return true;
    }
}
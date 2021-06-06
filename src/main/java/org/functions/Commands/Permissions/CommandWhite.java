package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.functions.Main.Functions;

public class CommandWhite implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandWhite() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("white")) {
        }

        return true;
    }
}

package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandCalc implements CommandExecutor {
    public CommandCalc() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("calc")) {
            boolean calc = args[1].contains("=...");
            if (calc) {
            }
        }

        return true;
    }
}
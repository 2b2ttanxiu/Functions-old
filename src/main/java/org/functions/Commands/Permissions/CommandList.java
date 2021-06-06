package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandList implements CommandExecutor {
    private Functions a = Functions.getMain();

    public CommandList() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("list")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(this.a.String(1, "ListPlayers", "Online Players: %online%").replace("%online%", this.a.getServer().getOnlinePlayers().toString()));
                return true;
            } else if (!this.a.hasPermission(sender.getName(), "functions.command.list.others")) {
                sender.sendMessage(this.a.Permission());
                return true;
            } else {
                sender.sendMessage(this.a.String(1, "ListPlayers", "Online Players: %online%").replace("%online%", this.a.OnlinePlayers(sender.getName())));
                return true;
            }
        } else {
            return true;
        }
    }
}
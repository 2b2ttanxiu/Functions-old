package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;

public class CommandXP implements CommandExecutor {
    PlayerNMS nms = new PlayerNMS();

    public CommandXP() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("xp")) {
            boolean l = args[0].endsWith("l") || args[0].endsWith("L");
            boolean mode = args[0].startsWith("-") || args[0].startsWith("=") || args[0].startsWith("+");
            Player p = this.nms.getPlayer(sender);
            int Level = p.getLevel();
            boolean var7 = Level < 0;
            if (var7) {
                Level *= -1;
            }

            if (l) {
                int L = Integer.parseInt(args[0].replace("l", "").replace("L", ""));
                if (mode) {
                    p.setLevel(p.getLevel() + L);
                }
            }
        }

        return true;
    }
}
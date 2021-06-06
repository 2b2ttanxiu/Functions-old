package org.functions.Commands.Permissions;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;
import org.functions.Main.Functions;

public class CommandBack implements CommandExecutor {
    private Functions a = Functions.getMain();
    private PlayerNMS nms = new PlayerNMS();

    public CommandBack() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = this.nms.getPlayer(sender);
            UUID id = this.nms.getPlayer(sender).getUniqueId();
            if (!this.nms.getDeath(id).isDeath()) {
                sender.sendMessage(this.a.String(1, "UnKnownBack", "Unknown latest death!").replace("%player%", sender.getName()));
                return true;
            } else {
                Location loc = this.nms.getDeath(id).getDeath();
                p.teleport(loc);
                sender.sendMessage(this.a.String(1, "TeleportBack", "Teleport the latest death(%location%)!").replace("%location%", this.nms.getDeath(id).toString()).replace("%player%", p.getName()));
                if (this.a.getSettings().getBoolean("resetBack")) {
                    this.nms.getDeath(id).resetDeath();
                }

                return true;
            }
        } else {
            return true;
        }
    }
}
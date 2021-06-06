package org.functions.Commands.Permissions;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandPardon implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandPardon() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pardon")) {
            List ls;
            if (!(sender instanceof Player)) {
                if (args.length == 0) {
                    sender.sendMessage(this.p.String(1, "Usage-Pardon", "Usage: /pardon <player>"));
                    return true;
                } else {
                    ls = this.p.getBanned().getStringList("BannedList");
                    if (ls.size() == 0) {
                        sender.sendMessage(this.p.String(1, "BannedListOfAir", "BannedList of null!"));
                        return true;
                    } else {
                        ls.remove(args[0]);
                        this.p.getBanned().set("BannedList", ls);
                        this.p.getBanned().set("Banned." + args[0], (Object)null);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "Pardon", "Success pardon %target%").replace("%target%", args[0]).replace("%player%", sender.getName()));
                        return true;
                    }
                }
            } else if (!this.p.hasPermission(sender.getName(), "functions.command.pardon.others")) {
                sender.sendMessage(this.p.Permission());
                return true;
            } else if (args.length == 0) {
                sender.sendMessage(this.p.String(1, "Usage-Pardon", "Usage: /pardon <player>"));
                return true;
            } else {
                ls = this.p.getBanned().getStringList("BannedList");
                if (ls.size() == 0) {
                    sender.sendMessage(this.p.String(1, "BannedListOfAir", "BannedList of null!"));
                    return true;
                } else {
                    ls.remove(args[0]);
                    this.p.getBanned().set("BannedList", ls);
                    this.p.getBanned().set("Banned." + args[0], (Object)null);
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "Pardon", "Success pardon %target%").replace("%target%", args[0]).replace("%player%", sender.getName()));
                    return true;
                }
            }
        } else {
            return true;
        }
    }
}

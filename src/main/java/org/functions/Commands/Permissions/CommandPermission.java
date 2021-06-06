package org.functions.Commands.Permissions;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandPermission implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandPermission() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        List ls;
        if (cmd.getName().equalsIgnoreCase("permission")) {
            if (!(sender instanceof Player)) {
                if (args[1].equalsIgnoreCase("add")) {
                    if (this.p.hasPermission(args[0], args[2])) {
                        sender.sendMessage(this.p.String(1, "PlayerHasPermission", "%target% has %permission%").replace("%target%", args[0]).replace("%player%", sender.getName()).replace("%permission%", args[2]));
                        return true;
                    }

                    ls = this.p.getPermission().getStringList(args[0]);
                    ls.add(args[2]);
                    this.p.getPermission().set(args[0], ls);
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "PlayerAddPermission", "%permission% add to %target%").replace("%target%", args[0]).replace("%player%", sender.getName()).replace("%permission%", args[2]));
                    return true;
                }

                if (args[2].equalsIgnoreCase("remove")) {
                    if (!this.p.hasPermission(args[0], args[2])) {
                        sender.sendMessage(this.p.String(1, "PlayerNotHasPermission", "%target%'s no has %permission%").replace("%target%", args[0]).replace("%player%", sender.getName()).replace("%permission%", args[2]));
                        return true;
                    }

                    ls = this.p.getPermission().getStringList(args[0]);
                    ls.remove(args[2]);
                    this.p.getPermission().set(args[0], ls);
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "PlayerAddPermission", "%permission% add to %target%").replace("%target%", args[0]).replace("%player%", sender.getName()).replace("%permission%", args[2]));
                    return true;
                }

                if (args[2].equalsIgnoreCase("list")) {
                    ls = this.p.getPermission().getStringList(args[0]);
                    if (ls.size() == 0) {
                        sender.sendMessage(this.p.String(1, "PlayerNotHasPermissionList", "%target%'s no has permissions").replace("%target%", args[0]).replace("%player%", sender.getName()));
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "PlayerListPermission", "%target%'s permission: %permission%").replace("%permission%", ls.toString().replace("[", "").replace("]", "")).replace("%target%", args[0]).replace("%player%", sender.getName()));
                    return true;
                }
            }
        } else {
            if (!this.p.hasPermission(sender.getName(), "functions.command.permission.others")) {
                sender.sendMessage(this.p.Permission());
                return true;
            }

            if (args[1].equalsIgnoreCase("add")) {
                if (this.p.hasPermission(args[0], args[2])) {
                    sender.sendMessage(this.p.String(1, "PlayerHasPermission", "%target% has %permission%").replace("%target%", args[0]).replace("%player%", sender.getName()).replace("%permission%", args[2]));
                    return true;
                }

                ls = this.p.getPermission().getStringList(args[0]);
                ls.add(args[2]);
                this.p.getPermission().set(args[0], ls);
                this.p.SaveConfig();
                sender.sendMessage(this.p.String(1, "PlayerAddPermission", "%permission% add to %target%").replace("%target%", args[0]).replace("%player%", sender.getName()).replace("%permission%", args[2]));
                return true;
            }

            if (args[2].equalsIgnoreCase("remove")) {
                if (!this.p.hasPermission(args[0], args[2])) {
                    sender.sendMessage(this.p.String(1, "PlayerNotHasPermission", "%target%'s no has %permission%").replace("%target%", args[0]).replace("%player%", sender.getName()).replace("%permission%", args[2]));
                    return true;
                }

                ls = this.p.getPermission().getStringList(args[0]);
                ls.remove(args[2]);
                this.p.getPermission().set(args[0], ls);
                this.p.SaveConfig();
                sender.sendMessage(this.p.String(1, "PlayerAddPermission", "%permission% add to %target%").replace("%target%", args[0]).replace("%player%", sender.getName()).replace("%permission%", args[2]));
                return true;
            }

            if (args[2].equalsIgnoreCase("list")) {
                ls = this.p.getPermission().getStringList(args[0]);
                if (ls.size() == 0) {
                    sender.sendMessage(this.p.String(1, "PlayerNotHasPermissionList", "%target%'s no has permissions").replace("%target%", args[0]).replace("%player%", sender.getName()));
                    return true;
                }

                sender.sendMessage(this.p.String(1, "PlayerListPermission", "%target%'s permission: %permission%").replace("%permission%", ls.toString().replace("[", "").replace("]", "")).replace("%target%", args[0]).replace("%player%", sender.getName()));
                return true;
            }
        }

        return true;
    }
}
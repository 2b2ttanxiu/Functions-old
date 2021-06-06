package org.functions.Commands.Permissions;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandBan implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandBan() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ban")) {
            List ls;
            if (!(sender instanceof Player)) {
                if (args.length == 0) {
                    sender.sendMessage(this.p.String(1, "Usage-Ban", "Usage: /ban <player> [Reason...]"));
                    return true;
                }

                if (args.length == 1) {
                    if (this.p.getBanned().getString("Banned." + args[0]) != null) {
                        sender.sendMessage(this.p.String(1, "BannedTrue", "%target% if banned!").replace("%target%", args[0]).replace("%player%", sender.getName()));
                        return true;
                    }

                    ls = this.p.getBanned().getStringList("BannedList");
                    ls.add(args[0]);
                    this.p.getBanned().set("BannedList", ls);
                    sender.sendMessage(this.p.String(1, "BannedPlayer", "Success %target% if banned!").replace("%target%", args[0]).replace("%player%", sender.getName()));
                    this.p.getBanned().set("Banned." + args[0] + ".Reason", this.p.getSettings().getString("BannedReason").replace("%date%", this.p.getDate()).replace("%time%", this.p.getTime()).replace("%from%", sender.getName()));
                    this.p.SaveConfig();
                    return true;
                }

                if (args.length == 2) {
                    if (this.p.getBanned().getString("Banned." + args[0]) != null) {
                        sender.sendMessage(this.p.String(1, "BannedTrue", "%target% if banned!").replace("%target%", args[0]).replace("%player%", sender.getName()));
                        return true;
                    }

                    ls = this.p.getBanned().getStringList("BannedList");
                    ls.add(args[0]);
                    this.p.getBanned().set("BannedList", ls);
                    sender.sendMessage(this.p.String(1, "BannedPlayer", "Success %target% if banned!").replace("%target%", args[0]).replace("%player%", sender.getName()));
                    this.p.getBanned().set("Banned." + args[0] + ".Reason", args[1].replace("%date%", this.p.getDate()).replace("%time%", this.p.getTime()).replace("%from%", sender.getName()));
                    this.p.SaveConfig();
                    return true;
                }
            }

            if (!this.p.hasPermission(sender.getName(), "functions.command.ban.others")) {
                sender.sendMessage(this.p.Permission());
                return true;
            }

            if (args.length == 0) {
                sender.sendMessage(this.p.String(1, "Usage-Ban", "Usage: /ban <player> [Reason...]"));
                return true;
            }

            if (args.length == 1) {
                if (this.p.getBanned().getString("Banned." + args[0]) != null) {
                    sender.sendMessage(this.p.String(1, "BannedTrue", "%target% if banned!").replace("%target%", args[0]).replace("%player%", sender.getName()));
                    return true;
                }

                ls = this.p.getBanned().getStringList("BannedList");
                ls.add(args[0]);
                this.p.getBanned().set("BannedList", ls);
                sender.sendMessage(this.p.String(1, "BannedPlayer", "Success %target% if banned!").replace("%target%", args[0]).replace("%player%", sender.getName()));
                this.p.getBanned().set("Banned." + args[0] + ".Reason", this.p.getSettings().getString("BannedReason").replace("%date%", this.p.getDate()).replace("%time%", this.p.getTime()).replace("%from%", sender.getName()));
                this.p.SaveConfig();
                return true;
            }

            if (args.length == 2) {
                if (this.p.getBanned().getString("Banned." + args[0]) != null) {
                    sender.sendMessage(this.p.String(1, "BannedTrue", "%target% if banned!").replace("%target%", args[0]).replace("%player%", sender.getName()));
                    return true;
                }

                ls = this.p.getBanned().getStringList("BannedList");
                ls.add(args[0]);
                this.p.getBanned().set("BannedList", ls);
                sender.sendMessage(this.p.String(1, "BannedPlayer", "Success %target% if banned!").replace("%target%", args[0]).replace("%player%", sender.getName()));
                this.p.getBanned().set("Banned." + args[0] + ".Reason", args[1].replace("%date%", this.p.getDate()).replace("%time%", this.p.getTime()).replace("%from%", sender.getName()));
                this.p.SaveConfig();
                return true;
            }
        }

        return true;
    }
}

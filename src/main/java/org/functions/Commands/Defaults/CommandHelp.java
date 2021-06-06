package org.functions.Commands.Defaults;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;
import org.functions.Tools.TPS;

public class CommandHelp implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandHelp() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("help")) {
            if (sender instanceof Player) {
                if (!this.p.hasPermission(sender.getName(), "functions.command.help.others")) {
                    sender.sendMessage(this.p.Permission());
                    return true;
                } else if (args.length == 0) {
                    sender.sendMessage(this.p.getHelp().getString("DefaultHelp").replace("&", "§").replace("%player%", sender.getName()).replace("/n", "\n").replace("%time%", this.p.getTime()).replace("%data%", this.p.getDate()).replace("%servername%", this.p.getServerName()).replace("%online%", this.p.OnlinePlayers(sender.getName())).replace("%tps%", TPS.TPS()));
                    return true;
                } else if (this.p.getHelp().getString("Helps." + args[0]) == null) {
                    sender.sendMessage(this.p.getHelp().getString("DefaultHelp").replace("&", "§").replace("%player%", sender.getName()).replace("/n", "\n").replace("%time%", this.p.getTime()).replace("%data%", this.p.getDate()).replace("%servername%", this.p.getServerName()).replace("%online%", this.p.OnlinePlayers(sender.getName())).replace("%tps%", TPS.TPS()));
                    return true;
                } else if (!this.p.hasPermission(sender.getName(), "functions.command.help.page." + args[0]) && !this.p.hasPermission(sender.getName(), "functions.command.page.*")) {
                    sender.sendMessage(this.p.getHelp().getString("DefaultHelp").replace("&", "§").replace("%player%", sender.getName()).replace("/n", "\n").replace("%time%", this.p.getTime()).replace("%data%", this.p.getDate()).replace("%servername%", this.p.getServerName()).replace("%online%", this.p.OnlinePlayers(sender.getName())).replace("%tps%", TPS.TPS()));
                    return true;
                } else {
                    sender.sendMessage(this.p.getHelp().getString("Helps." + args[0]).replace("&", "§").replace("%player%", sender.getName()).replace("/n", "\n").replace("%time%", this.p.getTime()).replace("%data%", this.p.getDate()).replace("%servername%", this.p.getServerName()).replace("%online%", this.p.OnlinePlayers(sender.getName())).replace("%tps%", TPS.TPS()));
                    return true;
                }
            } else if (args.length == 0) {
                sender.sendMessage(this.p.getHelp().getString("DefaultHelp").replace("&", "§").replace("%player%", sender.getName()).replace("/n", "\n").replace("%time%", this.p.getTime()).replace("%data%", this.p.getDate()).replace("%servername%", this.p.getServerName()).replace("%online%", this.p.getServer().getOnlinePlayers().size() + "").replace("%tps%", TPS.TPS()));
                return true;
            } else if (this.p.getHelp().getString("Helps." + args[0]) == null) {
                sender.sendMessage(this.p.getHelp().getString("DefaultHelp").replace("&", "§").replace("%player%", sender.getName()).replace("/n", "\n").replace("%time%", this.p.getTime()).replace("%data%", this.p.getDate()).replace("%servername%", this.p.getServerName()).replace("%online%", this.p.getServer().getOnlinePlayers().size() + "").replace("%tps%", TPS.TPS()));
                return true;
            } else {
                sender.sendMessage(this.p.getHelp().getString("Helps." + args[0]).replace("&", "§").replace("%player%", sender.getName()).replace("/n", "\n").replace("%time%", this.p.getTime()).replace("%data%", this.p.getDate()).replace("%servername%", this.p.getServerName()).replace("%online%", this.p.getServer().getOnlinePlayers().size() + "").replace("%tps%", TPS.TPS()));
                return true;
            }
        } else {
            return true;
        }
    }
}

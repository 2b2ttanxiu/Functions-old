package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerNMS;

public class CommandHelpOp implements CommandExecutor {
    PlayerNMS nms = new PlayerNMS();

    public CommandHelpOp() {
    }

    public static void run(JavaPlugin javaPlugin) {
        javaPlugin.getCommand("helpop").setExecutor(new CommandHelpOp());
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(this.nms.nms.String(1, "Usage-HelpOP", "Usage: /helpOp <op|message> <message...>"));
            return true;
        } else {
            Player p;
            String m;
            int i;
            String format;
            if (!this.nms.nms.getDisplayNameOnline(args[0])) {
                if (this.nms.getOP() == null) {
                    sender.sendMessage(this.nms.nms.String(1, "AdminNoOnline", "The admins offline."));
                    return true;
                } else {
                    p = this.nms.getOP();
                    m = "";

                    for(i = 0; i < args.length; ++i) {
                        m = m + args[i] + " ";
                    }

                    format = this.nms.nms.getGroup().getString(this.nms.nms.getGroup(sender.getName()) + ".Format.HelpOP");
                    format = format.replace("%message%", m).replace("%date%", this.nms.nms.getDate()).replace("%time%", this.nms.nms.getTime()).replace("%player%", sender.getName()).replace("%target%", p.getName());
                    sender.sendMessage(format);
                    p.sendMessage(format);
                    return true;
                }
            } else if (this.nms.nms.getDisplayNameOnline(args[0])) {
                p = this.nms.getPlayer(false, args[0]);
                if (p.isOp()) {
                    m = "";

                    for(i = 1; i < args.length; ++i) {
                        m = m + args[i] + " ";
                    }

                    format = this.nms.nms.getGroup().getString(this.nms.nms.getGroup(sender.getName()) + ".Format.HelpOP");
                    format = format.replace("%message%", m).replace("%date%", this.nms.nms.getDate()).replace("%time%", this.nms.nms.getTime()).replace("%player%", sender.getName()).replace("%target%", p.getName());
                    sender.sendMessage(format);
                    p.sendMessage(format);
                    return true;
                } else if (this.nms.getOP() == null) {
                    sender.sendMessage(this.nms.nms.String(1, "AdminNoOnline", "The admins offline."));
                    return true;
                } else {
                    p = this.nms.getOP();
                    m = "";

                    for(i = 0; i < args.length; ++i) {
                        m = m + args[i] + " ";
                    }

                    format = this.nms.nms.getGroup().getString(this.nms.nms.getGroup(sender.getName()) + ".Format.HelpOP");
                    format = format.replace("%message%", m).replace("%date%", this.nms.nms.getDate()).replace("%time%", this.nms.nms.getTime()).replace("%player%", sender.getName()).replace("%target%", p.getName());
                    sender.sendMessage(format);
                    p.sendMessage(format);
                    return true;
                }
            } else if (this.nms.getOP() == null) {
                sender.sendMessage(this.nms.nms.String(1, "AdminNoOnline", "The admins offline."));
                return true;
            } else {
                p = this.nms.getOP();
                m = "";

                for(i = 0; i < args.length; ++i) {
                    m = m + args[i] + " ";
                }

                format = this.nms.nms.getGroup().getString(this.nms.nms.getGroup(sender.getName()) + ".Format.HelpOP");
                format = format.replace("%message%", m).replace("%date%", this.nms.nms.getDate()).replace("%time%", this.nms.nms.getTime()).replace("%player%", sender.getName()).replace("%target%", p.getName());
                sender.sendMessage(format);
                p.sendMessage(format);
                return true;
            }
        }
    }
}
package org.functions.Commands.Defaults;

import java.util.Iterator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandMessage implements CommandExecutor {
    private Functions a = Functions.getMain();

    public CommandMessage() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if (cmd.getName().equalsIgnoreCase("msg")) {
            if (args.length < 1) {
                sender.sendMessage(this.a.String(1, "Usage-Message", "Usage: /msg <player> [message...]").replace("%player%", sender.getName()));
                return true;
            }

            if (!this.a.getDisplayNameOnline(args[0])) {
                sender.sendMessage(this.a.String(1, "Message-TargetOffline", "§cTarget is offline,you not send message to target").replace("%player%", sender.getName()).replace("%target%", args[0]));
                return true;
            }

            if (this.a.getDisplayName(sender.getName()).equals(args[0])) {
                sender.sendMessage(this.a.String(1, "Message-If_me", "§cYou can't send a message like yourself!").replace("%player%", sender.getName()).replace("%target%", args[0]));
                return true;
            }

            String x;
            if (!(sender instanceof Player)) {
                Player target = this.a.getServer().getPlayer(args[0]);
                x = "";

                for(int i = 1; i < args.length; ++i) {
                    x = x + args[i] + " ";
                }

                x = x.replace("&", "§");
                a.sendTargetMessage(((Player)sender),target,x);
                return true;
            }

            if (!this.a.hasPermission(sender.getName(), "functions.command.message.others")) {
                sender.sendMessage(this.a.Permission());
                return true;
            }

            Iterator var5 = this.a.ListGroup().iterator();

            while(var5.hasNext()) {
                x = (String)var5.next();
                if (this.a.getData().getString(sender.getName() + ".Group").equals(x) && this.a.getGroup().getBoolean(x + ".Color")) {
                    Player target = this.a.getServer().getPlayer(args[0]);
                    if (target.equals(sender)) {
                        sender.sendMessage(this.a.String(1, "Message-If_me", "§cYou can't send a message like yourself!").replace("%player%", sender.getName()).replace("%target%", args[0]));
                        return true;
                    }

                    String msg = "";

                    for(int i = 1; i < args.length; ++i) {
                        msg = msg + args[i] + " ";
                    }

                    Iterator var13 = this.a.getGroup().getStringList(x + ".Anti-Key-Words.List").iterator();

                    while(var13.hasNext()) {
                        String s = (String)var13.next();
                        if (msg.contains(s) && this.a.getGroup().getString(x + ".Anti-Key-Words.Replace." + s) != null) {
                            msg = msg.replace(s, this.a.getGroup().getString(x + ".Anti-Key-Words.Replace." + s));
                        }
                    }

                    msg = msg.replace("&", "§");
                    a.sendTargetMessage(((Player)sender),target,msg);
                    return true;
                }
            }
        }

        return true;
    }
}
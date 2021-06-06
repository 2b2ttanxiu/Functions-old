package org.functions.Commands.Permissions;

import java.util.Iterator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandSay implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandSay() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("say")) {
            if (!(sender instanceof Player)) {
                String msg = "";

                for(int i = 0; i < args.length; ++i) {
                    msg = msg + args[i] + " ";
                }

                Iterator var12 = this.p.getServer().getOnlinePlayers().iterator();

                while(var12.hasNext()) {
                    Player pl = (Player)var12.next();
                    pl.sendMessage(this.p.String(0, "SayFormat", "§6[%servername%]§f %message%").replace("%message%", msg.replace("&", "§")));
                }

                this.p.sendConsole(0, this.p.String(0, "SayFormat", "§6[%servername%]§f %message%").replace("%message%", msg.replace("&", "§")));
                return true;
            }

            if (!this.p.hasPermission(sender.getName(), "functions.command.say.others")) {
                sender.sendMessage(this.p.Permission());
                return true;
            }

            Iterator var5 = this.p.ListGroup().iterator();

            while(var5.hasNext()) {
                String x = (String)var5.next();
                if (this.p.getData().getString(sender.getName() + ".Group").equals(x)) {
                    String msg;
                    int i;
                    String ss;
                    Iterator var13;
                    Player pl;
                    if (this.p.getGroup().getBoolean(x + ".Color")) {
                        msg = "";

                        for(i = 0; i < args.length; ++i) {
                            msg = msg + args[i] + " ";
                        }

                        var13 = this.p.getGroup().getStringList(x + ".Anti-Key-Words.List").iterator();

                        while(var13.hasNext()) {
                            ss = (String)var13.next();
                            if (msg.contains(ss) && this.p.getGroup().getString(x + ".Anti-Key-Words.Replace." + ss) != null) {
                                msg = msg.replace(s, this.p.getGroup().getString(x + ".Anti-Key-Words.Replace." + ss));
                            }
                        }

                        var13 = this.p.getServer().getOnlinePlayers().iterator();

                        while(var13.hasNext()) {
                            pl = (Player)var13.next();
                            pl.sendMessage(this.p.Say(sender.getName(), this.p.getGroup(sender.getName()), msg.replace("&", "§")));
                        }

                        this.p.sendConsole(0, this.p.Say(sender.getName(), this.p.getGroup(sender.getName()), msg.replace("&", "§")));
                        return true;
                    }

                    msg = "";

                    for(i = 0; i < args.length; ++i) {
                        msg = msg + args[i] + " ";
                    }

                    var13 = this.p.getGroup().getStringList(x + ".Anti-Key-Words.List").iterator();

                    while(var13.hasNext()) {
                        ss = (String)var13.next();
                        if (msg.contains(ss) && this.p.getGroup().getString(x + ".Anti-Key-Words.Replace." + ss) != null) {
                            msg = msg.replace(s, this.p.getGroup().getString(x + ".Anti-Key-Words.Replace." + ss));
                        }
                    }

                    var13 = this.p.getServer().getOnlinePlayers().iterator();

                    while(var13.hasNext()) {
                        pl = (Player)var13.next();
                        pl.sendMessage(this.p.Say(sender.getName(), this.p.getGroup(sender.getName()), msg));
                    }

                    this.p.sendConsole(0, this.p.Say(sender.getName(), this.p.getGroup(sender.getName()), msg));
                    return true;
                }
            }
        }

        return true;
    }
}
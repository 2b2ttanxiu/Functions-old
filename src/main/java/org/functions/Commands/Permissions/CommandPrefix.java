package org.functions.Commands.Permissions;

import java.util.Iterator;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandPrefix implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandPrefix() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("prefix")) {
            String prefix;
            int i;
            boolean is;
            Iterator var8;
            String x;
            List ls;
            if (!(sender instanceof Player)) {
                if (args.length == 0) {
                    sender.sendMessage(this.p.String(1, "Usage-Prefix", "/prefix <add|set> <prefix...>\n/prefix <reset>\n/prefix <remove> <prefix amount>"));
                    return true;
                }

                if (args[1].equalsIgnoreCase("set")) {
                    prefix = "";

                    for(i = 2; i < args.length; ++i) {
                        prefix = prefix + args[i] + " ";
                    }

                    prefix = prefix.replace("' ", "").replace("'", "");
                    this.p.getData().set(args[0] + ".Prefix", prefix);
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "SetPrefix", "Success set %target%'s prefix!").replace("%prefix%", prefix).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("reset")) {
                    this.p.resetPrefix(args[0]);
                    sender.sendMessage(this.p.String(1, "ResetPrefix", "Reset %target%'s prefix").replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("add")) {
                    prefix = "";

                    for(i = 2; i < args.length; ++i) {
                        prefix = prefix + args[i] + " ";
                    }

                    prefix = prefix.replace("' ", "").replace("'", "");
                    ls = this.p.getData().getStringList(args[0] + ".List.Prefix");
                    is = true;
                    var8 = ls.iterator();

                    while(var8.hasNext()) {
                        x = (String)var8.next();
                        if (x.equals(prefix)) {
                            is = false;
                        }
                    }

                    if (is) {
                        ls.add(prefix);
                        this.p.getData().set(args[0] + ".List.Prefix", ls);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "AddPrefix", "Success add %prefix% to %target% prefix").replace("%prefix%", prefix).replace("%target%", args[0]));
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "IfAddPrefix", "%target%'s has %prefix% in the list!").replace("%prefix%", prefix).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("use")) {
                    ls = this.p.getData().getStringList(args[0] + ".List.Prefix");
                    if (ls.size() == 0) {
                        sender.sendMessage(this.p.String(1, "ListPrefix", "%target%'s prefix no in the list").replace("%target%", args[0]));
                        return true;
                    }

                    i = Integer.parseInt(args[2]);
                    this.p.getData().set(args[0] + ".Prefix", ls.get(i));
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "SetPrefix", "Success set %target%'s prefix!").replace("%prefix%", (CharSequence)ls.get(i)).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("remove")) {
                    prefix = "";

                    for(i = 2; i < args.length; ++i) {
                        prefix = prefix + args[i] + " ";
                    }

                    prefix = prefix.replace("' ", "").replace("'", "");
                    ls = this.p.getData().getStringList(args[0] + ".List.Prefix");
                    is = true;
                    if (ls.size() == 0) {
                        sender.sendMessage(this.p.String(1, "ListPrefix", "%target%'s prefix no in the list").replace("%target%", args[0].replace("%prefix%", prefix)));
                        return true;
                    }

                    var8 = ls.iterator();

                    while(var8.hasNext()) {
                        x = (String)var8.next();
                        if (!x.equals(prefix)) {
                            is = false;
                        }
                    }

                    if (is) {
                        ls.add(prefix);
                        this.p.getData().set(args[0] + ".List.Prefix", ls);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "RemovePrefix", "Success remove %target%'s prefix").replace("%prefix%", prefix).replace("%target%", args[0]));
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "IfRemovePrefix", "%target%'s not has %prefix% in the list!").replace("%prefix%", prefix).replace("%target%", args[0]));
                    return true;
                }
            } else {

                if (args.length == 0) {
                    sender.sendMessage(this.p.String(1, "Usage-Prefix", "/prefix <add|set> <prefix...>\n/prefix <reset>\n/prefix <remove> <prefix amount>"));
                    return true;
                }
                if (args[1].equalsIgnoreCase("reset")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.*")) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.reset")) {
                            sender.sendMessage(this.p.Permission());
                            return true;
                        }
                    }
                    if (!args[0].equals(sender.getName())) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.*")) {
                            if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.reset.target")) {
                                sender.sendMessage(this.p.Permission());
                                return true;
                            }
                        }
                    }
                    this.p.resetPrefix(args[0]);
                    sender.sendMessage(this.p.String(1, "ResetPrefix", "Reset %target%'s prefix").replace("%target%", args[0]));
                    return true;
                }
                if (args[1].equalsIgnoreCase("use")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.*")) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.use")) {
                            sender.sendMessage(this.p.Permission());
                            return true;
                        }
                    }
                    if (!args[0].equals(sender.getName())) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.*")) {
                            if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.use.target")) {
                                sender.sendMessage(this.p.Permission());
                                return true;
                            }
                        }
                    }
                    ls = this.p.getData().getStringList(args[0] + ".List.Prefix");
                    if (ls.size() == 0) {
                        sender.sendMessage(this.p.String(1, "ListPrefix", "%target%'s prefix no in the list").replace("%target%", args[0]));
                        return true;
                    }

                    i = Integer.parseInt(args[2]);
                    this.p.getData().set(args[0] + ".Prefix", ls.get(i));
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "SetPrefix", "Success set %target%'s prefix!").replace("%prefix%", (CharSequence)ls.get(i)).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("set")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.*")) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.set")) {
                            sender.sendMessage(this.p.Permission());
                            return true;
                        }
                    }
                    if (!args[0].equals(sender.getName())) {
                        if (!args[0].equals(sender.getName())) {
                            if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.*")) {
                                if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.set.target")) {
                                    sender.sendMessage(this.p.Permission());
                                    return true;
                                }
                            }
                        }
                    }
                    prefix = "";

                    for(i = 2; i < args.length; ++i) {
                        prefix = prefix + args[i] + " ";
                    }

                    prefix = prefix.replace("' ", "").replace("'", "");
                    this.p.getData().set(args[0] + ".Prefix", prefix);
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "SetPrefix", "Success set %target%'s prefix!").replace("%prefix%", prefix).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("add")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.*")) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.add")) {
                            sender.sendMessage(this.p.Permission());
                            return true;
                        }
                    }
                    if (!args[0].equals(sender.getName())) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.*")) {
                            if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.add.target")) {
                                sender.sendMessage(this.p.Permission());
                                return true;
                            }
                        }
                    }
                    prefix = "";

                    for(i = 2; i < args.length; ++i) {
                        prefix = prefix + args[i] + " ";
                    }

                    prefix = prefix.replace("' ", "").replace("'", "");
                    ls = this.p.getData().getStringList(args[0] + ".List.Prefix");
                    is = true;
                    var8 = ls.iterator();

                    while(var8.hasNext()) {
                        x = (String)var8.next();
                        if (x.equals(prefix)) {
                            is = false;
                        }
                    }

                    if (is) {
                        ls.add(prefix);
                        this.p.getData().set(args[0] + ".List.Prefix", ls);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "AddPrefix", "Success add %prefix% to %target% prefix").replace("%prefix%", prefix).replace("%target%", args[0]));
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "IfAddPrefix", "%target%'s has %prefix% in the list!").replace("%prefix%", prefix).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("remove")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.*")) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.remove")) {
                            sender.sendMessage(this.p.Permission());
                            return true;
                        }
                    }
                    if (!args[0].equals(sender.getName())) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.*")) {
                            if (!this.p.hasPermission(sender.getName(), "functions.command.prefix.remove.target")) {
                                sender.sendMessage(this.p.Permission());
                                return true;
                            }
                        }
                    }
                    prefix = "";

                    for(i = 2; i < args.length; ++i) {
                        prefix = prefix + args[i] + " ";
                    }

                    prefix = prefix.replace("' ", "").replace("'", "");
                    ls = this.p.getData().getStringList(args[0] + ".List.Prefix");
                    is = true;
                    if (ls.size() == 0) {
                        sender.sendMessage(this.p.String(1, "ListPrefix", "%target%'s prefix no in the list").replace("%target%", args[0].replace("%prefix%", prefix)));
                        return true;
                    }

                    var8 = ls.iterator();

                    while(var8.hasNext()) {
                        x = (String)var8.next();
                        if (!x.equals(prefix)) {
                            is = false;
                        }
                    }

                    if (is) {
                        ls.add(prefix);
                        this.p.getData().set(args[0] + ".List.Prefix", ls);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "RemovePrefix", "Success remove %target%'s prefix").replace("%prefix%", prefix).replace("%target%", args[0]));
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "IfRemovePrefix", "%target%'s not has %prefix% in the list!").replace("%prefix%", prefix).replace("%target%", args[0]));
                    return true;
                }
            }
        }

        return true;
    }
}
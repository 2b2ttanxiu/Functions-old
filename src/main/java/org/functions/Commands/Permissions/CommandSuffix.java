package org.functions.Commands.Permissions;

import java.util.Iterator;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandSuffix implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandSuffix() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("suffix")) {
            List ls;
            boolean is;
            int i;
            Iterator var8;
            String x;
            String suffix;
            String none;
            if (!(sender instanceof Player)) {
                if (args.length == 0) {
                    sender.sendMessage(this.p.String(1, "Usage-Suffix", "/suffix <add|set> <suffix...>\n/prefix <reset>\n/prefix <remove> <suffix amount>"));
                    return true;
                }

                if (args[1].equalsIgnoreCase("set")) {
                    suffix = "";

                    for(i = 2; i < args.length; ++i) {
                        suffix = suffix + args[i] + " ";
                    }

                    suffix = suffix.replace("' ", "").replace("'", "");
                    none = "";
                    if (args[3].equals("")) {
                        none = none + " ";
                    }

                    this.p.getData().set(args[0] + ".Suffix", none + suffix);
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "SetSuffix", "Success set %target%'s suffix!").replace("%suffix%", suffix).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("reset")) {
                    this.p.resetSuffix(args[0]);
                    sender.sendMessage(this.p.String(1, "ResetSuffix", "Reset %target%'s suffix").replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("use")) {
                    ls = this.p.getData().getStringList(args[0] + ".List.Suffix");
                    if (ls.size() == 0) {
                        sender.sendMessage(this.p.String(1, "ListPrefix", "%target%'s suffix no in the list").replace("%target%", args[0]));
                        return true;
                    }

                    i = Integer.parseInt(args[2]);
                    this.p.getData().set(args[0] + ".Suffix", ls.get(i));
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "SetSuffix", "Success set %target%'s suffix!").replace("%prefix%", (CharSequence)ls.get(i)).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("add")) {
                    suffix = "";

                    for(i = 2; i < args.length; ++i) {
                        suffix = suffix + args[i] + " ";
                    }

                    suffix = suffix.replace("' ", "").replace("'", "");
                    ls = this.p.getData().getStringList(args[0] + ".List.Suffix");
                    is = true;
                    var8 = ls.iterator();

                    while(var8.hasNext()) {
                        x = (String)var8.next();
                        if (x.equals(suffix)) {
                            is = false;
                        }
                    }

                    if (is) {
                        ls.add(suffix);
                        this.p.getData().set(args[0] + ".List.Suffix", ls);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "AddSuffix", "Success add \"%suffix%\" to %target% suffix").replace("%suffix%", suffix).replace("%target%", args[0]));
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "IfAddSuffix", "%target%'s has \"%suffix%\" in the list!").replace("%suffix%", suffix).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("remove")) {
                    ls = this.p.getData().getStringList(args[0] + ".List.Suffix");
                    is = true;
                    if (ls.size() == 0) {
                        sender.sendMessage(this.p.String(1, "ListSuffix", "%target%'s suffix no in the list").replace("%target%", args[0]));
                        return true;
                    }

                    i = Integer.parseInt(args[2]);
                    if (ls.get(i) == null) {
                        is = false;
                    }

                    if (is) {
                        ls.remove(i);
                        this.p.getData().set(args[0] + ".List.Suffix", ls);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "RemoveSuffix", "Success remove %target%'s suffix").replace("%target%", args[0]));
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "IfRemoveSuffix", "%target%'s not has suffix in the list!").replace("%target%", args[0]));
                    return true;
                }
            } else {
                if (args.length == 0) {
                    sender.sendMessage(this.p.String(1, "Usage-Suffix", "/suffix <add|set> <suffix...>\n/prefix <reset>\n/prefix <remove> <suffix amount>"));
                    return true;
                }

                if (args[1].equalsIgnoreCase("set")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.*")) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.set")) {
                            sender.sendMessage(this.p.Permission());
                            return true;
                        }
                    }
                    if (!args[0].equals(sender.getName())) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.*")) {
                            if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.set.target")) {
                                sender.sendMessage(this.p.Permission());
                                return true;
                            }
                        }
                    }
                    suffix = "";

                    for(i = 2; i < args.length; ++i) {
                        suffix = suffix + args[i] + " ";
                    }

                    suffix = suffix.replace("' ", "").replace("'", "");
                    none = "";
                    if (args[3].equals("")) {
                        none = none + " ";
                    }

                    this.p.getData().set(args[0] + ".Suffix", none + suffix);
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "SetSuffix", "Success set %target%'s suffix!").replace("%suffix%", suffix).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("reset")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.*")) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.reset")) {
                            sender.sendMessage(this.p.Permission());
                            return true;
                        }
                    }
                    if (!args[0].equals(sender.getName())) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.*")) {
                            if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.reset.target")) {
                                sender.sendMessage(this.p.Permission());
                                return true;
                            }
                        }
                    }
                    this.p.resetSuffix(args[0]);
                    sender.sendMessage(this.p.String(1, "ResetSuffix", "Reset %target%'s suffix").replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("use")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.*")) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.use")) {
                            sender.sendMessage(this.p.Permission());
                            return true;
                        }
                    }
                    if (!args[0].equals(sender.getName())) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.*")) {
                            if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.use.target")) {
                                sender.sendMessage(this.p.Permission());
                                return true;
                            }
                        }
                    }
                    ls = this.p.getData().getStringList(args[0] + ".List.Suffix");
                    if (ls.size() == 0) {
                        sender.sendMessage(this.p.String(1, "ListPrefix", "%target%'s suffix no in the list").replace("%target%", args[0]));
                        return true;
                    }

                    i = Integer.parseInt(args[2]);
                    this.p.getData().set(args[0] + ".Suffix", ls.get(i));
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "SetSuffix", "Success set %target%'s suffix!").replace("%prefix%", (CharSequence)ls.get(i)).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("add")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.*")) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.add")) {
                            sender.sendMessage(this.p.Permission());
                            return true;
                        }
                    }
                    if (!args[0].equals(sender.getName())) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.*")) {
                            if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.add.target")) {
                                sender.sendMessage(this.p.Permission());
                                return true;
                            }
                        }
                    }
                    suffix = "";

                    for(i = 2; i < args.length; ++i) {
                        suffix = suffix + args[i] + " ";
                    }

                    suffix = suffix.replace("' ", "").replace("'", "");
                    ls = this.p.getData().getStringList(args[0] + ".List.Suffix");
                    is = true;
                    var8 = ls.iterator();

                    while(var8.hasNext()) {
                        x = (String)var8.next();
                        if (x.equals(suffix)) {
                            is = false;
                        }
                    }

                    if (is) {
                        ls.add(suffix);
                        this.p.getData().set(args[0] + ".List.Suffix", ls);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "AddSuffix", "Success add \"%suffix%\" to %target% suffix").replace("%suffix%", suffix).replace("%target%", args[0]));
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "IfAddSuffix", "%target%'s has \"%suffix%\" in the list!").replace("%suffix%", suffix).replace("%target%", args[0]));
                    return true;
                }

                if (args[1].equalsIgnoreCase("remove")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.*")) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.remove")) {
                            sender.sendMessage(this.p.Permission());
                            return true;
                        }
                    }
                    if (!args[0].equals(sender.getName())) {
                        if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.*")) {
                            if (!this.p.hasPermission(sender.getName(), "functions.command.suffix.remove.target")) {
                                sender.sendMessage(this.p.Permission());
                                return true;
                            }
                        }
                    }
                    ls = this.p.getData().getStringList(args[0] + ".List.Suffix");
                    is = true;
                    if (ls.size() == 0) {
                        sender.sendMessage(this.p.String(1, "ListSuffix", "%target%'s suffix no in the list").replace("%target%", args[0]));
                        return true;
                    }

                    i = Integer.parseInt(args[2]);
                    if (ls.get(i) == null) {
                        is = false;
                    }

                    if (is) {
                        ls.remove(i);
                        this.p.getData().set(args[0] + ".List.Suffix", ls);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "RemoveSuffix", "Success remove %target%'s suffix").replace("%target%", args[0]));
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "IfRemoveSuffix", "%target%'s not has suffix in the list!").replace("%target%", args[0]));
                    return true;
                }
            }
        }

        return true;
    }
}

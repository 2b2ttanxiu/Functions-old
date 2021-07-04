package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerNMS;
import org.functions.money.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommandMoney implements TabExecutor {
    PlayerNMS nms = new PlayerNMS();
    public static void run(JavaPlugin j) {
        j.getCommand("money").setExecutor(new CommandMoney());
        j.getCommand("money").setTabCompleter(new CommandMoney());
    }
    public boolean onCommand(CommandSender sender,Command cmd,String s,String[] args) {
        if (cmd.getName().equalsIgnoreCase("money")) {
            if (sender instanceof Player) {
                if (args.length < 1) return true;
                UUID id = nms.getPlayer(false, args[0]).getUniqueId();
                String me = sender.getName();
                Money m = nms.money(id);
                String regex = m.format();
                if ("give".equalsIgnoreCase(args[1]) || "add".equalsIgnoreCase(args[1])) {
                    if (!nms.nms.hasPermission(me, "functions.command.money.*")) {
                        if (!nms.nms.hasPermission(me, "functions.command.money.give") || nms.nms.hasPermission(me,"functions.command.money.add")) {
                            sender.sendMessage(nms.nms.Permission());
                            return true;
                        }
                    }
                    if (!args[2].matches(regex)) {
                        sender.sendMessage(nms.nms.String(1, "matchesMaths", "&cYou number has text, matches: {0}").replace("%player%", me).replace("%target%", args[0]).replace("{0}", regex));
                        return true;
                    }
                    double d = Double.parseDouble(args[2]);
                    m.addMoney(d);
                    sender.sendMessage(nms.nms.String(1, "GiveMoney", "You give money to %target% %make_money%,Now %target% has %money%").replace("%player%", me).replace("%target%", args[0]).replace("%make_money%", d + "").replace("%money%", m.getMoney() + ""));
                    return true;
                }
                if ("remove".equalsIgnoreCase(args[1])) {
                    if (!args[2].matches(regex)) {
                        sender.sendMessage(nms.nms.String(1, "matchesMaths", "&cYou number has text, matches: {0}").replace("%player%", me).replace("%target%", args[0]).replace("{0}", regex));
                        return true;
                    }
                    double d = Double.parseDouble(args[2]);
                    if (!m.IfRemoveMoney(d)) {
                        sender.sendMessage(nms.nms.String(1, "IfRemoveMoney", "You remove money if %target% has %money%").replace("%player%", me).replace("%target%", args[0]).replace("%make_money%", d + "").replace("%money%", m.getMoney() + ""));
                        return true;
                    }
                    m.removeMoney(d);
                    sender.sendMessage(nms.nms.String(1, "GiveMoney", "You give money to %target%'s %money%").replace("%player%", me).replace("%target%", args[0]).replace("%make_money%", d + "").replace("%money%", m.getMoney() + ""));
                    return true;
                }
                if ("set".equalsIgnoreCase(args[1])) {
                    if (!nms.nms.hasPermission(me, "functions.command.money.*")) {
                        if (!nms.nms.hasPermission(me, "functions.command.money.set")) {
                            sender.sendMessage(nms.nms.Permission());
                            return true;
                        }
                    }
                    if (!args[2].matches(regex)) {
                        sender.sendMessage(nms.nms.String(1, "matchesMaths", "&cYou number has text, matches: {0}").replace("%player%", me).replace("%target%", args[0]).replace("{0}", regex));
                        return true;
                    }
                    double d = Double.parseDouble(args[2]);
                    m.setMoney(d);
                    sender.sendMessage(nms.nms.String(1, "setMoney", "You set money to %target%'s %money%").replace("%player%", me).replace("%target%", args[0]).replace("%make_money%", d + "").replace("%money%", m.getMoney() + ""));
                    return true;
                }
                if ("reset".equalsIgnoreCase(args[1])) {
                    m.resetMoney();
                    sender.sendMessage(nms.nms.String(1, "resetMoney", "You reset %target% user money").replace("%player%", me).replace("%target%", args[0]).replace("%make_money%", 0 + "").replace("%money%", m.getMoney() + ""));
                    return true;
                }
                if ("pay".equalsIgnoreCase(args[1])) {
                    if (!nms.nms.hasPermission(me, "functions.command.money.*")) {
                        if (!nms.nms.hasPermission(me, "functions.command.money.pay")) {
                            sender.sendMessage(nms.nms.Permission());
                            return true;
                        }
                    }
                    if (!args[2].matches(regex)) {
                        sender.sendMessage(nms.nms.String(1, "matchesMaths", "&cYou number has text, matches: {0}").replace("%player%", me).replace("%target%", args[0]).replace("{0}", regex));
                        return true;
                    }
                    double d = Double.parseDouble(args[2]);
                    UUID uuid1 = nms.getPlayer(sender).getUniqueId();
                    if (!nms.money(uuid1).IfPayMoney(d)) {
                        sender.sendMessage(nms.nms.String(1, "IfPayMoney", "You don't pay money to %target% user, you user no many money").replace("%player%", me).replace("%target%", args[0]).replace("%make_money%", d + "").replace("%money%", m.getMoney() + ""));
                        return true;
                    }
                    m.PayMoney(id, d);
                    sender.sendMessage(nms.nms.String(1, "PayMoney", "You pay to %target%").replace("%player%", me).replace("%target%", args[0]).replace("%make_money%", d + "").replace("%money%", m.getMoney() + ""));
                    return true;
                }
                if ("query".equalsIgnoreCase(args[1])) {
                    if (!nms.nms.hasPermission(me, "functions.command.money.*")) {
                        if (!nms.nms.hasPermission(me, "functions.command.money.query")) {
                            sender.sendMessage(nms.nms.Permission());
                            return true;
                        }
                    }
                    sender.sendMessage(nms.nms.String(1, "QueryMoney", "%target% has %money%").replace("%player%", me).replace("%target%", args[0]).replace("%money%", m.getMoney() + ""));
                    return true;
                }
                if (!nms.nms.hasPermission(me, "functions.command.money.*")) {
                    if (!nms.nms.hasPermission(me, "functions.command.money.query")) {
                        sender.sendMessage(nms.nms.Permission());
                        return true;
                    } else {
                        sender.sendMessage(nms.nms.String(1, "QueryMoney", "%target% has %money%").replace("%player%", me).replace("%target%", args[0]).replace("%money%", m.getMoney() + ""));
                        return true;
                    }
                }
            } else {
                UUID id = nms.getPlayer(false,args[0]).getUniqueId();
                String me = sender.getName();
                Money m = nms.money(id);
                String regex = m.format();
                if ("give".equalsIgnoreCase(args[1]) || "add".equalsIgnoreCase(args[1])) {
                    if (!args[2].matches(regex)) {
                        sender.sendMessage(nms.nms.String(1,"matchesMaths","&cYou number has text, matches: {0}").replace("%player%",me).replace("%target%",args[0]).replace("{0}",regex));
                        return true;
                    }
                    double d = Double.parseDouble(args[2]);
                    m.addMoney(d);
                    sender.sendMessage(nms.nms.String(1,"GiveMoney","You give money to %target% %make_money%,Now %target% has %money%").replace("%player%",me).replace("%target%",args[0]).replace("%make_money%",d+"").replace("%money%",m.getMoney()+""));
                    return true;
                }
                if ("remove".equalsIgnoreCase(args[1])) {
                    if (!args[2].matches(regex)) {
                        sender.sendMessage(nms.nms.String(1,"matchesMaths","&cYou number has text, matches: {0}").replace("%player%",me).replace("%target%",args[0]).replace("{0}",regex));
                        return true;
                    }
                    double d = Double.parseDouble(args[2]);
                    if (!m.IfRemoveMoney(d)) {
                        sender.sendMessage(nms.nms.String(1,"IfRemoveMoney","You remove money if %target% has %money%").replace("%player%",me).replace("%target%",args[0]).replace("%make_money%",d+"").replace("%money%",m.getMoney()+""));
                        return true;
                    }
                    m.removeMoney(d);
                    sender.sendMessage(nms.nms.String(1,"GiveMoney","You give money to %target%'s %money%").replace("%player%",me).replace("%target%",args[0]).replace("%make_money%",d+"").replace("%money%",m.getMoney()+""));
                    return true;
                }
                if ("set".equalsIgnoreCase(args[1])) {
                    if (!args[2].matches(regex)) {
                        sender.sendMessage(nms.nms.String(1,"matchesMaths","&cYou number has text, matches: {0}").replace("%player%",me).replace("%target%",args[0]).replace("{0}",regex));
                        return true;
                    }
                    double d = Double.parseDouble(args[2]);
                    m.setMoney(d);
                    sender.sendMessage(nms.nms.String(1,"setMoney","You set money to %target%'s %money%").replace("%player%",me).replace("%target%",args[0]).replace("%make_money%",d+"").replace("%money%",m.getMoney()+""));
                    return true;
                }
                if ("reset".equalsIgnoreCase(args[1])) {
                    m.resetMoney();
                    sender.sendMessage(nms.nms.String(1,"resetMoney","You reset %target% user money").replace("%player%",me).replace("%target%",args[0]).replace("%make_money%",0+"").replace("%money%",m.getMoney()+""));
                    return true;
                }
                if ("query".equalsIgnoreCase(args[1])) {
                    sender.sendMessage(nms.nms.String(1,"QueryMoney","%target% has %money%").replace("%player%",me).replace("%target%",args[0]).replace("%money%",m.getMoney()+""));
                    return true;
                }
                sender.sendMessage(nms.nms.String(1,"QueryMoney","%target% has %money%").replace("%player%",me).replace("%target%",args[0]).replace("%money%",m.getMoney()+""));
                return true;
            }
        }
        return true;
    }
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> ls = new ArrayList<>();
        if (args.length == 0 || args.length == 1) {
            for (Player p : nms.getOnlinePlayers()) {
                ls.add(p.getName());
            }
        }
        if (args.length == 2) {
            ls.add("add");
            ls.add("give");
            ls.add("remove");
            ls.add("reset");
            ls.add("set");
            ls.add("query");
            ls.add("pay");
        }
        return ls;
    }

}

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

public class CommandPay implements TabExecutor {
    public static void run(JavaPlugin j) {
        j.getCommand("pay").setExecutor(new CommandPay());
        j.getCommand("pay").setTabCompleter(new CommandPay());
    }
    PlayerNMS nms = new PlayerNMS();
    public boolean onCommand(CommandSender sender,Command cmd,String s,String[] args) {
        if (cmd.getName().equalsIgnoreCase("pay")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(nms.nms.String(0, "OnlyPlayer", "§cOnly player execute command!").replace("%player%", sender.getName()));
                return true;
            }
            if (!nms.nms.getDisplayNameOnline(args[0])) {
                sender.sendMessage(nms.nms.String(1, "Message-TargetOffline", "§cTarget is offline,you not send message to target").replace("%player%", sender.getName()).replace("%target%", args[0]));
                return true;
            }
            Player target = nms.getPlayer(false,args[0]);
            Player me = nms.getPlayer(sender);
            UUID id = me.getUniqueId();
            UUID uuid1 = target.getUniqueId();
            Money m = nms.money(id);
            String regex = m.format();
            if (!args[1].matches(regex)) {
                sender.sendMessage(nms.nms.String(1, "matchesMaths", "&cYou number has text, matches: {0}").replace("%player%", me.getName()).replace("%target%", args[0]).replace("{0}", regex));
                return true;
            }
            double d = Double.parseDouble(args[1]);
            if (!nms.money(uuid1).IfPayMoney(d)) {
                sender.sendMessage(nms.nms.String(1, "IfPayMoney", "You don't pay money to %target% user, you user no many money").replace("%player%", me.getName()).replace("%target%", args[0]).replace("%make_money%", d + "").replace("%money%", m.getMoney() + ""));
                return true;
            }
            m.PayMoney(uuid1,d);
            me.sendMessage(nms.nms.String(1,"PayTarget","You pay to %target% %make_money%,You has %money%").replace("%player%",me.getName()).replace("%target%",args[0]).replace("%make_money%",d+"").replace("%money%",m.getMoney()+""));
            target.sendMessage(nms.nms.String(1,"CopyTarget","You copy %target%'s %make_money%,You has %money%").replace("%player%",me.getName()).replace("%target%",args[0]).replace("%make_money%",d+"").replace("%money%",nms.money(uuid1).getMoney()+""));
            return true;
        }
        return true;
    }
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        List<String> ls = new ArrayList<>();
        if (args.length == 0 || args.length == 1) {
            for (Player p : nms.getOnlinePlayers()) {
                ls.add(p.getName());
            }
        }
        if (args.length == 2) {
            ls.add(nms.money(nms.getPlayer(sender).getUniqueId()).getMoney()+"");
        }
        return ls;
    }
}

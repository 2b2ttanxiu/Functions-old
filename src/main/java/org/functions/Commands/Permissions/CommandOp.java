package org.functions.Commands.Permissions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandOp implements TabExecutor {
    private Functions p = Functions.getMain();

    public CommandOp() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("op")) {
            if (!sender.isOp()) {
                sender.sendMessage(this.p.Permission());
                return true;
            } else if (args.length == 0) {
                sender.sendMessage(this.p.String(1, "Usage-op", "/op <player>"));
                return true;
            } else {
                List<String> ls = this.p.getOP().getStringList("Administrators");
                Iterator var6 = this.p.getOP().getStringList("Administrators").iterator();

                String x;
                do {
                    if (!var6.hasNext()) {
                        ls.add(args[0]);
                        p.getData().set(args[0] + ".Group",p.getSettings().getString("OP-setGroup"));
                        this.p.getOP().set("Administrators", ls);
                        p.SaveOP();
                        sender.sendMessage(this.p.String(1, "GiveAdministrator", "Give %target% server administrator").replace("%player%", sender.getName()).replace("%target%", args[0]));
                        return true;
                    }

                    x = (String)var6.next();
                } while(!x.equals(args[0]));

                sender.sendMessage(this.p.String(1, "Administrator-TargetIf", "§c%target% if server administrator!").replace("%player%", sender.getName()).replace("%target%", args[0]));
                return true;
            }
        } else {
            return true;
        }
    }
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> s = new ArrayList();
        Iterator var6 = this.p.nms().getOnlinePlayers().iterator();

        while(var6.hasNext()) {
            Player p = (Player)var6.next();
            if (!p.isOp()) {
                s.add(p.getName());
            }
        }

        return s;
    }
}

package org.functions.Commands.Permissions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandDeop implements TabExecutor {
    private Functions p = Functions.getMain();

    public CommandDeop() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("deop")) {
            return true;
        } else if (!sender.isOp()) {
            sender.sendMessage(this.p.Permission());
            return true;
        } else {
            List<String> ls = p.getOP().getStringList("Administrators");;
            if (args.length != 0) {
                if (ls.size() == 0) {
                    sender.sendMessage(this.p.String(1, "Administrator-Null", "§cServer administrator of null!,Pleases use /op <player> add server administrator.").replace("%player%", sender.getName()));
                    return true;
                } else {
                    boolean is = false;
                    for (String f : p.getOP().getStringList("Administrators")) {
                        if (args[0].equals(f)) {
                            ls.remove(f);
                            is = true;
                        }
                    }
                    if (is) {
                        p.getData().set(args[0] + ".Group",p.getSettings().getString("Join.Group"));
                        p.getOP().set("Administrators", ls);
                        p.SaveOP();
                        sender.sendMessage(this.p.String(1, "DeleteAdministrator", "Remove %target% server administrator").replace("%player%", sender.getName()).replace("%target%", args[0]));
                        return true;
                    }
                    sender.sendMessage(this.p.String(1, "NoAdministrator-TargetIf", "§c%target% no if server administrator!").replace("%player%", sender.getName()).replace("%target%", args[0]));
                    return true;
                }
            } else {
                String list = "";
                for (String la : ls) {
                    list = list + la + " ";
                }
                sender.sendMessage(this.p.String(1, "AdministratorList", "List op: %list%").replace("%list%", list));
                return true;
            }
        }
    }
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> s = new ArrayList();
        if (!sender.isOp()) {
            return s;
        }
        Iterator var6 = this.p.nms().getOnlinePlayers().iterator();

        while(var6.hasNext()) {
            Player p = (Player)var6.next();
            if (p.isOp()) {
                s.add(p.getName());
            }
        }

        return s;
    }
}

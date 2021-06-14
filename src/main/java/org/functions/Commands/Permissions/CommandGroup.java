package org.functions.Commands.Permissions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandGroup implements TabExecutor {
    private Functions p = Functions.getMain();

    public CommandGroup() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("group")) {
            if (args.length == 0) {
                sender.sendMessage(this.p.String(1, "Usage-Group", "/group <Group> <player>"));
            }
            if (!(sender instanceof Player)) {
                List<String> ls;
                String x = "";
                boolean is = false;
                ls = this.p.ListGroup();
                for (String sf : ls) {
                    if (args[0].equals(sf)) {
                        is = true;
                        x = sf;
                    }
                }
                if (!is) {
                    sender.sendMessage(p.String(1, "NoGroup", "&cNo Group name,Please change group"));
                    return true;
                }
                if (args[0].equals(this.p.getGroup(args[1]))) {
                    sender.sendMessage(this.p.String(1, "TargetInGroup", "%target% in the %group%").replace("%target%", args[1]).replace("%group%", args[0]));
                    return true;
                }
                this.p.getData().set(args[1] + ".Group", args[0]);
                this.p.SaveConfig();
                sender.sendMessage(this.p.String(1, "setGroup", "%target% set %group%").replace("%target%", args[1]).replace("%group%", args[0]));
                return true;
            } else {
                if (!this.p.hasPermission(sender.getName(), "functions.command.group.others")) {
                    sender.sendMessage(this.p.Permission());
                    return true;
                }
                List<String> ls;
                String x = "";
                boolean is = false;
                ls = this.p.ListGroup();
                for (String sf : ls) {
                    if (args[0].equals(sf)) {
                        is = true;
                        x = sf;
                    }
                }
                if (!is) {
                    sender.sendMessage(p.String(1, "NoGroup", "&cNo Group name,Please change group"));
                    return true;
                }
                if (args[0].equals(this.p.getGroup(args[1]))) {
                    sender.sendMessage(this.p.String(1, "TargetInGroup", "%target% in the %group%").replace("%target%", args[1]).replace("%group%", args[0]));
                    return true;
                }
                this.p.getData().set(args[1] + ".Group", args[0]);
                this.p.SaveConfig();
                sender.sendMessage(this.p.String(1, "setGroup", "%target% set %group%").replace("%target%", args[1]).replace("%group%", args[0]));
                return true;
            }
        }
        return true;
    }
    public List<String> onTabComplete (CommandSender sender,Command cmd,String s,String[] args) {
        List<String> ls = new ArrayList<>();
        if (p.hasPermission(sender.getName(), "functions.command.group.others")) {
            if (args.length == 0 || args.length == 1) {
                ls = p.ListGroup();
            }
            if (args.length == 2) {
                for (Player p : p.nms().getOnlinePlayers()) {
                    ls.add(p.getName());
                }
            }
        }
        return ls;
    }
}
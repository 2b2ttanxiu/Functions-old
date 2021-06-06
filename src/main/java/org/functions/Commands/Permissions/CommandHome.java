package org.functions.Commands.Permissions;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;

public class CommandHome implements CommandExecutor {
    private PlayerNMS nms = new PlayerNMS();

    public CommandHome() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("home") && sender instanceof Player) {
            if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.home.others")) {
                sender.sendMessage(this.nms.nms.Permission());
                return true;
            }

            UUID id = this.nms.getPlayer(sender).getUniqueId();
            String Loc;
            String x;
            if (args.length == 0) {
                String List = "";
                int i = 0;
                x = this.nms.nms.getGroup().getString(this.nms.nms.getGroup(sender.getName()) + ".List.Home");

                String[] arg;
                for(Iterator var20 = this.nms.house(id).getList().iterator(); var20.hasNext(); List = List + x.replace("%home%", Loc).replace("%count%", i + "").replace("%location%", this.nms.toLocationString(arg))) {
                    Loc = (String)var20.next();
                    arg = this.nms.house(id).getLocation(Loc);
                    ++i;
                }

                sender.sendMessage(this.nms.nms.String(1, "ListHouse", "List Warps: %homes%").replace("%homes%", List));
                return true;
            }

            Iterator var6;
            String space;
            Location loc;
            Player p;
            if (args.length == 1) {
                var6 = this.nms.house(id).getList().iterator();

                while(var6.hasNext()) {
                    space = (String)var6.next();
                    if (args[0].equalsIgnoreCase(space)) {
                        loc = this.nms.house(id).get(space);
                        p = this.nms.getPlayer(sender);
                        p.teleport(loc);
                        sender.sendMessage(this.nms.nms.String(1, "TeleportHouse", "Teleport the %home%(%location%)").replace("%home%", space).replace("%location%", this.nms.toLocationString(this.nms.house(id).getLocation(space))));
                        return true;
                    }
                }
            }

            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("teleport")) {
                    var6 = this.nms.house(id).getList().iterator();

                    while(var6.hasNext()) {
                        space = (String)var6.next();
                        if (args[1].equalsIgnoreCase(space)) {
                            loc = this.nms.house(id).get(space);
                            p = this.nms.getPlayer(sender);
                            p.teleport(loc);
                            sender.sendMessage(this.nms.nms.String(1, "TeleportHouse", "Teleport the %home%(%location%)").replace("%home%", space).replace("%location%", this.nms.toLocationString(this.nms.house(id).getLocation(space))));
                            return true;
                        }
                    }
                }

                boolean is;
                Iterator var13;
                List ls;
                if (args[0].equalsIgnoreCase("add")) {
                    is = false;
                    var13 = this.nms.house(id).getList().iterator();

                    while(var13.hasNext()) {
                        x = (String)var13.next();
                        if (x.equals(args[1])) {
                            is = true;
                        }
                    }

                    if (is) {
                        sender.sendMessage(this.nms.nms.String(1, "InHouse", "%home% of in the homes!").replace("%home%", args[1]).replace("%player%", sender.getName()).replace("%target%", sender.getName()));
                        return true;
                    }

                    ls = this.nms.house(id).getList();
                    ls.add(args[1]);
                    this.nms.house(id).setList(ls);
                    x = ",";
                    loc = this.nms.getPlayer(sender).getLocation();
                    Loc = loc.getWorld().getName() + x + loc.getX() + x + loc.getY() + x + loc.getZ() + x + loc.getYaw() + x + loc.getPitch();
                    this.nms.house(id).set(args[1], Loc);
                    sender.sendMessage(this.nms.nms.String(1, "addHouse", "Successfully add %home%").replace("%home%", args[1]));
                    return true;
                }

                if (args[0].equalsIgnoreCase("reset")) {
                    is = false;
                    var13 = this.nms.house(id).getList().iterator();

                    while(var13.hasNext()) {
                        x = (String)var13.next();
                        if (x.equals(args[1])) {
                            is = true;
                        }
                    }

                    if (!is) {
                        sender.sendMessage(this.nms.nms.String(1, "noInHouse", "%home% of don't in the homes!").replace("%home%", args[1]));
                        return true;
                    }

                    space = ",";
                    loc = this.nms.getPlayer(sender).getLocation();
                    Loc = loc.getWorld().getName() + space + loc.getX() + space + loc.getY() + space + loc.getZ() + space + loc.getYaw() + space + loc.getPitch();
                    this.nms.house(id).reset(args[1], Loc);
                    sender.sendMessage(this.nms.nms.String(1, "resetHouse", "Successfully reset %home% location your location").replace("%player%", sender.getName()).replace("%home%", args[1]));
                    return true;
                }

                if (args[0].equalsIgnoreCase("remove")) {
                    is = false;
                    var13 = this.nms.house(id).getList().iterator();

                    while(var13.hasNext()) {
                        x = (String)var13.next();
                        if (x.equals(args[1])) {
                            is = true;
                        }
                    }

                    if (!is) {
                        sender.sendMessage(this.nms.nms.String(1, "noInHouse", "%home% of don't in the homes!").replace("%home%", args[1]));
                        return true;
                    }

                    ls = this.nms.house(id).getList();
                    ls.remove(args[1]);
                    this.nms.house(id).setList(ls);
                    this.nms.house(id).remove(args[1]);
                    sender.sendMessage(this.nms.nms.String(1, "RemoveHouse", "Successfully remove %home%").replace("%home%", args[1]));
                    return true;
                }
            }
        }

        return true;
    }
}
package org.functions.Commands.Permissions;

import java.util.Iterator;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;
import org.functions.Main.Functions;

public class CommandWarp implements TabExecutor {
    private Functions a = Functions.getMain();
    private PlayerNMS nms = new PlayerNMS();

    public CommandWarp() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("warp")) {
            String Warp;
            String[] arg;
            double Y;
            double Z;
            float yaw;
            float pitch;
            Location Loc;
            Player p;
            boolean is;
            Iterator var20;
            String warp;
            World world;
            double X;
            Iterator var28;
            String xs;
            int i;
            if (sender instanceof Player) {
                if (!this.a.hasPermission(sender.getName(), "functions.command.warp.others")) {
                    sender.sendMessage(this.a.Permission());
                    return true;
                }

                if (args.length == 0) {
                    warp = this.a.getSettings().getString("List.Warp");
                    Warp = "";
                    i = 0;

                    for(var28 = this.a.getWarps().iterator(); var28.hasNext(); Warp = Warp + warp.replace("%warp%", xs).replace("%location%", this.nms.toLocationString(arg)).replace("%count%", i + "")) {
                        xs = (String)var28.next();
                        arg = this.a.getWarp().getString("Warps." + xs + ".Location").split(",");
                        ++i;
                    }

                    sender.sendMessage(this.a.String(1, "ListWarp", "List Warps: %warps%").replace("%warps%", Warp));
                    return true;
                }

                Iterator var6;
                String list;
                if (args.length == 1) {
                    is = false;
                    var6 = this.a.getWarps().iterator();

                    while(var6.hasNext()) {
                        list = (String)var6.next();
                        if (list.equals(args[0])) {
                            is = true;
                        }
                    }

                    if (is) {
                        arg = this.a.getWarp().getString("Warps." + args[0] + ".Location").split(",");
                        p = this.nms.getPlayer(sender);
                        world = this.nms.getWorld(arg[0]);
                        X = Double.parseDouble(arg[1]);
                        Y = Double.parseDouble(arg[2]);
                        Z = Double.parseDouble(arg[3]);
                        yaw = Float.parseFloat(arg[4]);
                        pitch = Float.parseFloat(arg[5]);
                        Loc = this.nms.Location(world, X, Y, Z, yaw, pitch);
                        p.teleport(Loc);
                        sender.sendMessage(this.a.String(1, "TeleportWarp", "%target% Teleport the %warp%(%location%)").replace("%target%", p.getName()).replace("%player%", p.getName()).replace("%warp%", args[0]).replace("%location%", this.nms.toLocationString(p)));
                        return true;
                    }
                }

                if (args.length == 3 && args[0].equalsIgnoreCase("teleport")) {
                    if (!this.a.getDisplayNameOnline(args[2])) {
                        sender.sendMessage(this.a.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[1]).replace("%player%", sender.getName()));
                        return true;
                    }

                    p = this.nms.getPlayer(args[2]);
                    is = false;
                    var20 = this.a.getWarps().iterator();

                    while(var20.hasNext()) {
                        Warp = (String)var20.next();
                        if (Warp.equals(args[1])) {
                            is = true;
                        }
                    }

                    if (!is) {
                        sender.sendMessage(this.a.String(1, "UnknownWarp", "§cUnknown warp!").replace("%warp%", args[1]));
                    }

                    if (is) {
                        arg = this.a.getWarp().getString("Warps." + args[1] + ".Location").split(",");
                        world = this.nms.getWorld(arg[0]);
                        X = Double.parseDouble(arg[1]);
                        Y = Double.parseDouble(arg[2]);
                        Z = Double.parseDouble(arg[3]);
                        yaw = Float.parseFloat(arg[4]);
                        pitch = Float.parseFloat(arg[5]);
                        Loc = this.nms.Location(world, X, Y, Z, yaw, pitch);
                        p.teleport(Loc);
                        sender.sendMessage(this.a.String(1, "TeleportWarp", "%target% Teleport the %warp%(%location%)").replace("%target%", p.getName()).replace("%player%", p.getName()).replace("%warp%", args[1]).replace("%location%", this.nms.toLocationString(p)));
                        return true;
                    }
                }

                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("teleport")) {
                        is = false;
                        var6 = this.a.getWarps().iterator();

                        while(var6.hasNext()) {
                            list = (String)var6.next();
                            if (list.equals(args[1])) {
                                is = true;
                            }
                        }

                        if (!is) {
                            sender.sendMessage(this.a.String(1, "UnknownWarp", "§cUnknown warp!").replace("%warp%", args[1]));
                        }

                        if (is) {
                            arg = this.a.getWarp().getString("Warps." + args[1] + ".Location").split(",");
                            p = this.nms.getPlayer(sender);
                            world = this.nms.getWorld(arg[0]);
                            X = Double.parseDouble(arg[1]);
                            Y = Double.parseDouble(arg[2]);
                            Z = Double.parseDouble(arg[3]);
                            yaw = Float.parseFloat(arg[4]);
                            pitch = Float.parseFloat(arg[5]);
                            Loc = this.nms.Location(world, X, Y, Z, yaw, pitch);
                            p.teleport(Loc);
                            sender.sendMessage(this.a.String(1, "TeleportWarp", "%target% Teleport the %warp%(%location%)").replace("%target%", p.getName()).replace("%player%", p.getName()).replace("%warp%", args[1]).replace("%location%", this.nms.toLocationString(p)));
                            return true;
                        }
                    }

                    List ls;
                    if (args[0].equalsIgnoreCase("add")) {
                        is = false;
                        var6 = this.a.getWarps().iterator();

                        while(var6.hasNext()) {
                            list = (String)var6.next();
                            if (list.equals(args[1])) {
                                is = true;
                            }
                        }

                        if (is) {
                            sender.sendMessage(this.a.String(1, "InWarp", "%warp% of in the warps!").replace("%warp%", args[1]).replace("%player%", sender.getName()).replace("%target%", sender.getName()));
                            return true;
                        }

                        ls = this.a.getWarps();
                        ls.add(args[1]);
                        list = "WarpList";
                        Warp = "Warps.";
                        this.a.getWarp().set(list, ls);
                        Location loc = this.nms.getPlayer(sender).getLocation();
                        this.a.getWarp().set(Warp + args[1] + ".Location", loc.getWorld().getName() + "," + loc.getX() + "," + loc.getY() + "," + loc.getZ() + "," + loc.getYaw() + "," + loc.getPitch());
                        this.a.SaveConfig();
                        sender.sendMessage(this.a.String(1, "AddWarp", "Successfully add %warp%").replace("%player%", sender.getName()).replace("%warp%", args[1]));
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("reset")) {
                        is = false;
                        var6 = this.a.getWarps().iterator();

                        while(var6.hasNext()) {
                            list = (String)var6.next();
                            if (list.equals(args[1])) {
                                is = true;
                            }
                        }

                        if (!is) {
                            sender.sendMessage(this.a.String(1, "noInWarp", "%warp% of don't in the warps!").replace("%warp%", args[1]).replace("%player%", sender.getName()).replace("%target%", sender.getName()));
                            return true;
                        }

                        Warp = "Warps.";
                        Location loc = this.nms.getPlayer(sender).getLocation();
                        this.a.getWarp().set(Warp + args[1] + ".Location", loc.getWorld().getName() + "," + loc.getX() + "," + loc.getY() + "," + loc.getZ() + "," + loc.getYaw() + "," + loc.getPitch());
                        this.a.SaveConfig();
                        sender.sendMessage(this.a.String(1, "resetWarp", "Successfully reset %warp% location your location").replace("%player%", sender.getName()).replace("%warp%", args[1]));
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("remove")) {
                        is = false;
                        var6 = this.a.getWarps().iterator();

                        while(var6.hasNext()) {
                            list = (String)var6.next();
                            if (list.equals(args[1])) {
                                is = true;
                            }
                        }

                        if (!is) {
                            sender.sendMessage(this.a.String(1, "noInWarp", "%warp% of don't in the warps!").replace("%warp%", args[1]).replace("%player%", sender.getName()).replace("%target%", sender.getName()));
                            return true;
                        }

                        ls = this.a.getWarps();
                        ls.remove(args[1]);
                        list = "WarpList";
                        Warp = "Warps.";
                        this.a.getWarp().set(list, ls);
                        this.a.getWarp().set(Warp + args[1], (Object)null);
                        this.a.SaveConfig();
                        sender.sendMessage(this.a.String(1, "RemoveWarp", "Successfully remove %warp%").replace("%player%", sender.getName()).replace("%warp%", args[1]));
                        return true;
                    }
                }
            } else {
                if (args.length == 0) {
                    warp = this.a.getSettings().getString("List.Warp");
                    Warp = "";
                    i = 0;

                    for(var28 = this.a.getWarps().iterator(); var28.hasNext(); Warp = Warp + warp.replace("%warp%", xs).replace("%location%", this.nms.toLocationString(arg)).replace("%count%", i + "")) {
                        xs = (String)var28.next();
                        arg = this.a.getWarp().getString("Warps." + xs + ".Location").split(",");
                        ++i;
                    }

                    sender.sendMessage(this.a.String(1, "ListWarp", "List Warps: %warps%").replace("%warps%", Warp));
                }

                if (args.length == 2) {
                    if (!this.a.getDisplayNameOnline(args[1])) {
                        sender.sendMessage(this.a.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[1]).replace("%player%", sender.getName()));
                        return true;
                    }

                    p = this.nms.getPlayer(args[1]);
                    is = false;
                    var20 = this.a.getWarps().iterator();

                    while(var20.hasNext()) {
                        Warp = (String)var20.next();
                        if (Warp.equals(args[0])) {
                            is = true;
                        }
                    }

                    if (is) {
                        arg = this.a.getWarp().getString("Warps." + args[0] + ".Location").split(",");
                        world = this.nms.getWorld(arg[0]);
                        X = Double.parseDouble(arg[1]);
                        Y = Double.parseDouble(arg[2]);
                        Z = Double.parseDouble(arg[3]);
                        yaw = Float.parseFloat(arg[4]);
                        pitch = Float.parseFloat(arg[5]);
                        Loc = this.nms.Location(world, X, Y, Z, yaw, pitch);
                        p.teleport(Loc);
                        sender.sendMessage(this.a.String(1, "TeleportWarp", "%target% Teleport the %warp%(%location%)").replace("%target%", p.getName()).replace("%player%", sender.getName()).replace("%warp%", args[0]).replace("%location%", this.nms.toLocationString(p)));
                        return true;
                    }
                }

                if (args.length == 3 && args[0].equalsIgnoreCase("teleport")) {
                    if (!this.a.getDisplayNameOnline(args[2])) {
                        sender.sendMessage(this.a.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[2]).replace("%player%", sender.getName()));
                        return true;
                    }

                    p = this.nms.getPlayer(args[2]);
                    is = false;
                    var20 = this.a.getWarps().iterator();

                    while(var20.hasNext()) {
                        Warp = (String)var20.next();
                        if (Warp.equals(args[1])) {
                            is = true;
                        }
                    }

                    if (!is) {
                        sender.sendMessage(this.a.String(1, "UnknownWarp", "§cUnknown warp!").replace("%warp%", args[1]));
                    }

                    if (is) {
                        arg = this.a.getWarp().getString("Warps." + args[1] + ".Location").split(",");
                        world = this.nms.getWorld(arg[0]);
                        X = Double.parseDouble(arg[1]);
                        Y = Double.parseDouble(arg[2]);
                        Z = Double.parseDouble(arg[3]);
                        yaw = Float.parseFloat(arg[4]);
                        pitch = Float.parseFloat(arg[5]);
                        Loc = this.nms.Location(world, X, Y, Z, yaw, pitch);
                        p.teleport(Loc);
                        sender.sendMessage(this.a.String(1, "TeleportWarp", "%target% Teleport the %warp%(%location%)").replace("%target%", p.getName()).replace("%player%", sender.getName()).replace("%warp%", args[1]).replace("%location%", this.nms.toLocationString(p)));
                        return true;
                    }
                }
            }
        }

        return true;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}

package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;
import org.functions.Main.Functions;

public class CommandPlayerInfo implements CommandExecutor {
    private PlayerNMS nms = new PlayerNMS();
    private Functions p;
    boolean is;

    public CommandPlayerInfo() {
        this.p = this.nms.nms;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("playerinfo")) {
            String AllowFlight;
            String isOp;
            String isFlying;
            String Group;
            if (sender instanceof Player) {
                if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.playerinfo.others")) {
                    sender.sendMessage(this.nms.nms.Permission());
                    return true;
                }

                Player p;
                if (args.length == 1) {
                    if (!this.nms.nms.getDisplayNameOnline(args[0])) {
                        sender.sendMessage(this.nms.nms.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[1]).replace("%player%", sender.getName()));
                        return true;
                    }

                    p = this.nms.getPlayer(false,args[0]);
                    this.is = false;
                    if (p.getAllowFlight()) {
                        this.is = true;
                    }

                    AllowFlight = this.nms.Boolean(this.is);
                    this.is = false;
                    if (p.isOp()) {
                        this.is = true;
                    }

                    AllowFlight = this.nms.Boolean(this.is);
                    this.is = false;
                    if (p.isFlying()) {
                        this.is = true;
                    }

                    isOp = this.nms.Boolean(this.is);
                    isFlying = this.nms.nms.getGroup(p.getName() + "");
                    Group = this.nms.nms.getGroup().getString(isFlying + ".ShowPlayerInfo");
                    Group = Group.replace("/n", "\n").replace("%uuid%", p.getUniqueId() + "").replace("%player%", p.getName()).replace("%prefix%", this.nms.ShowPrefix(sender)).replace("%suffix%", this.nms.ShowSuffix(sender)).replace("%flying%", isOp).replace("%flight%", AllowFlight).replace("%location%", this.nms.toLocationString(p)).replace("%world%", p.getWorld().getName()).replace("%ping%", this.nms.ping(p)).replace("%op%", AllowFlight);
                    sender.sendMessage(this.nms.nms.Prefix() + Group);
                    return true;
                }

                if (args.length == 0) {
                    p = this.nms.getPlayer(sender);
                    this.is = false;
                    if (p.getAllowFlight()) {
                        this.is = true;
                    }

                    AllowFlight = this.nms.Boolean(this.is);
                    this.is = false;
                    if (p.isOp()) {
                        this.is = true;
                    }

                    AllowFlight = this.nms.Boolean(this.is);
                    this.is = false;
                    if (p.isFlying()) {
                        this.is = true;
                    }

                    isOp = this.nms.Boolean(this.is);
                    isFlying = this.nms.nms.getGroup(p.getName() + "");
                    Group = this.nms.nms.getGroup().getString(isFlying + ".ShowPlayerInfo");
                    Group = Group.replace("/n", "\n").replace("%uuid%", p.getUniqueId() + "").replace("%player%", p.getName()).replace("%prefix%", this.nms.ShowPrefix(sender)).replace("%suffix%", this.nms.ShowSuffix(sender)).replace("%flying%", isOp).replace("%flight%", AllowFlight).replace("%location%", this.nms.toLocationString(p)).replace("%world%", p.getWorld().getName()).replace("%ping%", this.nms.ping(p)).replace("%op%", AllowFlight);
                    sender.sendMessage(this.nms.nms.Prefix() + Group);
                    return true;
                }
            }

            if (args.length == 0) {
                return true;
            }

            if (args.length == 1) {
                Object t = args[0];
                if (!this.nms.nms.getDisplayNameOnline(args[0])) {
                    sender.sendMessage(this.nms.nms.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[0]).replace("%player%", sender.getName()));
                    return true;
                }

                Player p = this.nms.getPlayer(false,args[0]);
                this.is = false;
                if (p.getAllowFlight()) {
                    this.is = true;
                }

                AllowFlight = this.nms.Boolean(this.is);
                this.is = false;
                if (p.isOp()) {
                    this.is = true;
                }

                isOp = this.nms.Boolean(this.is);
                this.is = false;
                if (p.isFlying()) {
                    this.is = true;
                }

                isFlying = this.nms.Boolean(this.is);
                Group = this.nms.nms.getGroup(p.getName() + "");
                String Info = this.nms.nms.getGroup().getString(Group + ".ShowPlayerInfo");
                Info = Info.replace("/n", "\n").replace("%uuid%", p.getUniqueId() + "").replace("%player%", p.getName()).replace("%prefix%", this.nms.ShowPrefix(args[0])).replace("%suffix%", this.nms.ShowSuffix(args[0])).replace("%flying%", isFlying).replace("%flight%", AllowFlight).replace("%location%", this.nms.toLocationString(p)).replace("%world%", p.getWorld().getName()).replace("%ping%", this.nms.ping(p)).replace("%op%", isOp).replace("%food%", p.getFoodLevel() + "").replace("%health%", p.getHealth() / 10.0D + "");
                sender.sendMessage(this.nms.nms.Prefix() + Info);
                return true;
            }
        }

        return true;
    }
}
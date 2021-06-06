package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;
import org.functions.Utlis.ServerInfo;

public class CommandTPS implements CommandExecutor {
    private Functions p = Functions.getMain();
    private Runtime r;

    public CommandTPS() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("tps")) {
            return true;
        } else {
            Runtime r;
            long Lused;
            String Info;
            long used;
            String osarch;
            String osversion;
            String java_version;
            ServerInfo info;
            String RAM;
            String osname;
            if (!(sender instanceof Player)) {
                if (args.length != 1 || !args[0].equalsIgnoreCase("clear") && !args[0].equalsIgnoreCase("gc")) {
                    info = new ServerInfo();
                    RAM = info.nms.nms.getSettings().getString("List.RAM");
                    Info = info.nms.nms.getSettings().getString("List.ListSystem");
                    osname = System.getProperty("os.name");
                    osarch = System.getProperty("os.arch");
                    osversion = System.getProperty("os.version");
                    java_version = System.getProperty("java.version");
                    Info = Info.replace("%name%", osname).replace("%arch%", osarch).replace("%version%", osversion).replace("%JavaVersion%", java_version);
                    RAM = RAM.replace("%usize%", info.getRAM().getSize() + "").replace("%size%", info.getRAM().size()).replace("%max%", info.getRAM().getMax() + "");
                    sender.sendMessage(this.p.String(1, "InfoTPS", "TPS from last 1m, 5m, 15m: %spigot_tps%, Server Name:%servername%,RAM: %ram% %system%").replace("%ram%", RAM).replace("%system%", Info));
                    return true;
                } else {
                    r = Runtime.getRuntime();
                    Lused = (r.totalMemory() - r.freeMemory()) / 1024L / 1024L;
                    System.gc();
                    used = Lused - (r.totalMemory() - r.freeMemory()) / 1024L / 1024L;
                    sender.sendMessage(this.p.String(1, "ClearTPS", "Clear ram: %ram%MB,TPS from last 1m, 5m, 15m: %spigot_tps%").replace("%ram%", used + "").replace("%tps%", this.p.API().getHandler().nms().getTPS()));
                    return true;
                }
            } else if (!this.p.hasPermission(sender.getName(), "functions.command.tps.others")) {
                sender.sendMessage(this.p.Permission());
                return true;
            } else if (args.length != 1 || !args[0].equalsIgnoreCase("clear") && !args[0].equalsIgnoreCase("gc")) {
                info = new ServerInfo();
                RAM = info.nms.nms.getSettings().getString("List.RAM");
                Info = info.nms.nms.getSettings().getString("List.ListSystem");
                osname = System.getProperty("os.name");
                osarch = System.getProperty("os.arch");
                osversion = System.getProperty("os.version");
                java_version = System.getProperty("java.version");
                Info = Info.replace("%name%", osname).replace("%arch%", osarch).replace("%version%", osversion).replace("%JavaVersion%", java_version);
                RAM = RAM.replace("%usize%", info.getRAM().getSize() + "").replace("%size%", info.getRAM().size()).replace("%max%", info.getRAM().getMax() + "");
                sender.sendMessage(this.p.String(1, "InfoTPS", "TPS from last 1m, 5m, 15m: %spigot_tps%, Server Name:%servername%,RAM: %ram% %system%").replace("%ram%", RAM).replace("%system%", Info));
                return true;
            } else {
                r = Runtime.getRuntime();
                Lused = (r.totalMemory() - r.freeMemory()) / 1024L / 1024L;
                System.gc();
                used = Lused - (r.totalMemory() - r.freeMemory()) / 1024L / 1024L;
                sender.sendMessage(this.p.String(1, "ClearTPS", "Clear ram: %ram%MB,TPS from last 1m, 5m, 15m: %spigot_tps%").replace("%ram%", used + "").replace("%tps%", this.p.API().getHandler().nms().getTPS()));
                return true;
            }
        }
    }
}

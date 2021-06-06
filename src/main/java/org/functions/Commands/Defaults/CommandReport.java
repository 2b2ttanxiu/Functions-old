package org.functions.Commands.Defaults;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandReport implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandReport() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("report")) {
            if (sender instanceof Player) {
                if (args.length <= 1) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.report.type")) {
                        sender.sendMessage(this.p.Permission());
                        return true;
                    }

                    sender.sendMessage(this.p.String(1, "Usage-Report", "§cUsage: /report <player> <type or message...>").replace("%player%", sender.getName()));
                }

                if (args[1].equalsIgnoreCase("type")) {
                    if (!this.p.hasPermission(sender.getName(), "functions.command.report.type")) {
                        sender.sendMessage(this.p.Permission());
                        return true;
                    }

                    String path = "WatchdogType.";
                    if (args[2].equalsIgnoreCase("fly")) {
                        path = path + args[2] + ".";
                        this.p.getReport().set(path + args[0], true);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "Report-Type", "Thank you report,%target% of report,type %type-report%.").replace("%player%", sender.getName()).replace("%target%", args[0]).replace("%type-report%", args[2]));
                        return true;
                    }

                    if (args[2].equalsIgnoreCase("kill_aura")) {
                        path = path + args[2] + ".";
                        this.p.getReport().set(path + args[0], true);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "Report-Type", "Thank you report,%target% of report,type %type-report%.").replace("%player%", sender.getName()).replace("%target%", args[0]).replace("%type=report%", args[2]));
                        return true;
                    }

                    if (args[2].equalsIgnoreCase("boat_fly")) {
                        path = path + args[2] + ".";
                        this.p.getReport().set(path + args[0], true);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "Report-Type", "Thank you report,%target% of report,type %type-report%.").replace("%player%", sender.getName()).replace("%target%", args[0]).replace("%type=report%", args[2]));
                        return true;
                    }

                    if (args[2].equalsIgnoreCase("no_fall")) {
                        path = path + args[2] + ".";
                        this.p.getReport().set(path + args[0], true);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "Report-Type", "Thank you report,%target% of report,type %type-report%.").replace("%player%", sender.getName()).replace("%target%", args[0]).replace("%type=report%", args[2]));
                        return true;
                    }

                    if (args[2].equalsIgnoreCase("Nuker")) {
                        path = path + args[2] + ".";
                        this.p.getReport().set(path + args[0], true);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "Report-Type", "Thank you report,%target% of report,type %type-report%.").replace("%player%", sender.getName()).replace("%target%", args[0]).replace("%type=report%", args[2]));
                        return true;
                    }

                    if (args[2].equalsIgnoreCase("scaffold")) {
                        path = path + args[2] + ".";
                        this.p.getReport().set(path + args[0], true);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "Report-Type", "Thank you report,%target% of report,type %type-report%.").replace("%player%", sender.getName()).replace("%target%", args[0]).replace("%type=report%", args[2]));
                        return true;
                    }

                    if (args[2].equalsIgnoreCase("surround")) {
                        path = path + args[2] + ".";
                        this.p.getReport().set(path + args[0], true);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "Report-Type", "Thank you report,%target% of report,type %type-report%.").replace("%player%", sender.getName()).replace("%target%", args[0]).replace("%type=report%", args[2]));
                        return true;
                    }
                }

                if (!this.p.hasPermission(sender.getName(), "functions.command.report")) {
                    sender.sendMessage(this.p.Permission());
                    return true;
                }
            }

            this.p.sendConsole(1, this.p.String(0, "OnlyPlayer", "§cOnly player execute command!").replace("%player%", sender.getName()));
        }

        return true;
    }
}
package org.functions.Commands.Permissions;import java.util.ArrayList;import java.util.List;import org.bukkit.command.Command;import org.bukkit.command.CommandSender;import org.bukkit.command.TabExecutor;import org.bukkit.entity.Player;import org.functions.Main.Functions;import org.functions.Tools.GameModeAPI;public class CommandGameMode implements TabExecutor {    private Functions p = Functions.getMain();    public CommandGameMode() {    }    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {        if (cmd.getName().equalsIgnoreCase("gamemode")) {            Player target;            if (!(sender instanceof Player)) {                if (args.length == 2) {                    if (!this.p.getDisplayNameOnline(args[1])) {                        sender.sendMessage(this.p.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    target = this.p.getServer().getPlayer(args[1]);                    if (args[0].equalsIgnoreCase("0")) {                        GameModeAPI.GameModeAPI(target, 0);                        sender.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("1")) {                        GameModeAPI.GameModeAPI(target, 1);                        sender.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("2")) {                        GameModeAPI.GameModeAPI(target, 2);                        sender.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("3")) {                        GameModeAPI.GameModeAPI(target, 3);                        sender.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("s")) {                        GameModeAPI.GameModeAPI(target, 0);                        sender.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("c")) {                        GameModeAPI.GameModeAPI(target, 1);                        sender.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("a")) {                        GameModeAPI.GameModeAPI(target, 2);                        sender.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("sp")) {                        GameModeAPI.GameModeAPI(target, 3);                        sender.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("survival")) {                        GameModeAPI.GameModeAPI(target, 0);                        sender.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("creative")) {                        GameModeAPI.GameModeAPI(target, 1);                        sender.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("adventure")) {                        GameModeAPI.GameModeAPI(target, 2);                        sender.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("spectator")) {                        GameModeAPI.GameModeAPI(target, 3);                        sender.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                }                if (args.length <= 1) {                    sender.sendMessage(this.p.String(1, "Usage-GameMode", "Usage: /GameMode <GameMode> [player]"));                    return true;                } else {                    sender.sendMessage(this.p.String(1, "Usage-GameMode", "Usage: /GameMode <GameMode> [player]"));                    return true;                }            } else {                if (args.length == 1) {                    if (!this.p.hasPermission(sender.getName(), "functions.command.gamemode.other")) {                        sender.sendMessage(this.p.Permission());                        return true;                    }                    if (args[0].equalsIgnoreCase("0")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 0);                        sender.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("1")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 1);                        sender.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("2")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 2);                        sender.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("3")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 3);                        sender.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("s")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 0);                        sender.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("c")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 1);                        sender.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("a")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 2);                        sender.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("sp")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 3);                        sender.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("survival")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 0);                        sender.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("creative")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 1);                        sender.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("adventure")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 2);                        sender.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("spectator")) {                        GameModeAPI.GameModeAPI(((Player)sender).getPlayer(), 3);                        sender.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", sender.getName()).replace("%player%", sender.getName()));                        return true;                    }                }                if (args.length == 2) {                    if (!this.p.hasPermission(sender.getName(), "functions.command.gamemode.target")) {                        sender.sendMessage(this.p.Permission());                        return true;                    }                    if (!this.p.getDisplayNameOnline(args[1])) {                        sender.sendMessage(this.p.String(1, "TargetOffline", "%target% if offline.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    target = this.p.getServer().getPlayer(args[1]);                    if (args[0].equalsIgnoreCase("0")) {                        GameModeAPI.GameModeAPI(target, 0);                        sender.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("1")) {                        GameModeAPI.GameModeAPI(target, 1);                        sender.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("2")) {                        GameModeAPI.GameModeAPI(target, 2);                        sender.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("3")) {                        GameModeAPI.GameModeAPI(target, 3);                        sender.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("s")) {                        GameModeAPI.GameModeAPI(target, 0);                        sender.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("c")) {                        GameModeAPI.GameModeAPI(target, 1);                        sender.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("a")) {                        GameModeAPI.GameModeAPI(target, 2);                        sender.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("sp")) {                        GameModeAPI.GameModeAPI(target, 3);                        sender.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("survival")) {                        GameModeAPI.GameModeAPI(target, 0);                        sender.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Survival", "%target%‘s game mode has been updated to survival mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("creative")) {                        GameModeAPI.GameModeAPI(target, 1);                        sender.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Creative", "%target%‘s game mode has been updated to creative mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("adventure")) {                        GameModeAPI.GameModeAPI(target, 2);                        sender.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Adventure", "%target%‘s game mode has been updated to adventure mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                    if (args[0].equalsIgnoreCase("spectator")) {                        GameModeAPI.GameModeAPI(target, 3);                        sender.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        target.sendMessage(this.p.String(1, "GameMode-Spectator", "%target%‘s game mode has been updated to spectator mode.").replace("%target%", args[1]).replace("%player%", sender.getName()));                        return true;                    }                }                if (args.length == 0) {                    if (this.p.hasPermission(sender.getName(), "functions.command.gamemode.other") && this.p.hasPermission(sender.getName(), "functions.command.gamemode.target")) {                        sender.sendMessage(this.p.String(1, "Usage-GameMode", "Usage: /GameMode <GameMode> [player]"));                        return true;                    } else {                        sender.sendMessage(this.p.Permission());                        return true;                    }                } else {                    sender.sendMessage(this.p.String(1, "Usage-GameMode", "Usage: /GameMode <GameMode> [player]"));                    return true;                }            }        } else {            return true;        }    }    public List<String> onTabComplete (CommandSender sender, Command command, String alias, String[] args) {        List<String> s = new ArrayList();        if (args.length == 0 || args.length == 1) {            s.add("survival");            s.add("creative");            s.add("adventure");            s.add("spectator");            s.add("0");            s.add("1");            s.add("2");            s.add("3");        }        if (args.length == 2) {            for (Player p : p.nms().getOnlinePlayers()) {                s.add(p.getName());            }        }        return s;    }}
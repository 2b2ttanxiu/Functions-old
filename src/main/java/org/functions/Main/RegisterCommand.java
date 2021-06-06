package org.functions.Main;

import org.functions.Commands.Defaults.CommandHelp;
import org.functions.Commands.Defaults.CommandMessage;
import org.functions.Commands.Defaults.CommandReport;
import org.functions.Commands.Permissions.*;

public class RegisterCommand {
    Functions p = null;

    public RegisterCommand(Functions main) {
        this.p = main;
    }

    public void run() {
        CommandPlugins.run(this.p);
        p.getCommand("plugins").setTabCompleter(new CommandPlugins());
        CommandHat.run(this.p);
        CommandHelpOp.run(this.p);
        CommandDestroyItem.run(this.p);
        CommandDifficulty.run(this.p);
        CommandMoney.run(p);
        CommandPay.run(p);
        p.getCommand("functions").setTabCompleter(new CommandMain());
        p.getCommand("chat").setTabCompleter(new CommandChat());
        p.getCommand("gamemode").setTabCompleter(new CommandGameMode());
        p.getCommand("deop").setTabCompleter(new CommandDeop());
        p.getCommand("op").setTabCompleter(new CommandOp());
        p.getCommand("weather").setTabCompleter(new CommandWeather());
        p.getCommand("setworldspawn").setExecutor(new CommandSetWorldSpawn());
        p.getCommand("kill").setExecutor(new CommandKill());
        p.getCommand("permission").setExecutor(new CommandPermission());
        p.getCommand("msg").setExecutor(new CommandMessage());
        p.getCommand("help").setExecutor(new CommandHelp());
        p.getCommand("functions").setExecutor(new CommandMain());
        p.getCommand("report").setExecutor(new CommandReport());
        p.getCommand("ban").setExecutor(new CommandBan());
        p.getCommand("gamemode").setExecutor(new CommandGameMode());
        p.getCommand("pardon").setExecutor(new CommandPardon());
        p.getCommand("fly").setExecutor(new CommandFly());
        p.getCommand("chat").setExecutor(new CommandChat());
        p.getCommand("prefix").setExecutor(new CommandPrefix());
        p.getCommand("suffix").setExecutor(new CommandSuffix());
        p.getCommand("tps").setExecutor(new CommandTPS());
        p.getCommand("ping").setExecutor(new CommandPing());
        p.getCommand("deop").setExecutor(new CommandDeop());
        p.getCommand("op").setExecutor(new CommandOp());
        p.getCommand("group").setExecutor(new CommandGroup());
        p.getCommand("say").setExecutor(new CommandSay());
        p.getCommand("list").setExecutor(new CommandList());
        p.getCommand("seed").setExecutor(new CommandSeed());
        p.getCommand("kick").setExecutor(new CommandKick());
        p.getCommand("spawn").setExecutor(new CommandSpawn());
        p.getCommand("warp").setExecutor(new CommandWarp());
        p.getCommand("back").setExecutor(new CommandBack());
        p.getCommand("playerinfo").setExecutor(new CommandPlayerInfo());
        p.getCommand("food").setExecutor(new CommandFood());
        p.getCommand("home").setExecutor(new CommandHome());
        p.getCommand("weather").setExecutor(new CommandWeather());
    }
}
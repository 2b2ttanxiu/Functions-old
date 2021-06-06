package org.functions.Commands.Permissions;

import java.util.Iterator;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;
import org.functions.net.minecraft.server.Handler;

public class CommandSeed implements CommandExecutor {
    private Functions p = Functions.getMain();

    public CommandSeed() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("seed")) {
            Handler server = new Handler();
            String World;
            Iterator var7;
            World world;
            if (!(sender instanceof Player)) {
                World = "";
                var7 = server.getWorlds().iterator();

                while(var7.hasNext()) {
                    world = (World)var7.next();
                    World = world.getName() + ": " + world.getSeed();
                    sender.sendMessage(World);
                }
            } else {
                if (!this.p.hasPermission(sender.getName(), "functions.command.seed.others")) {
                    sender.sendMessage(this.p.Permission());
                    return true;
                }

                World = "";
                var7 = server.getWorlds().iterator();

                while(var7.hasNext()) {
                    world = (World)var7.next();
                    World = world.getName() + ": " + world.getSeed();
                    sender.sendMessage(World);
                }
            }
        }

        return true;
    }
}
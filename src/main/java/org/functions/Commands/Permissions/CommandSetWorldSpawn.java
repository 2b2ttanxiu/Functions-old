package org.functions.Commands.Permissions;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;

public class CommandSetWorldSpawn implements CommandExecutor {
    private PlayerNMS nms = new PlayerNMS();

    public CommandSetWorldSpawn() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setworldspawn")) {
            Player p;
            int x;
            int y;
            World world;
            int z;
            if (!(sender instanceof Player)) {
                if (args.length == 3) {
                    world = (World)this.nms.getWorlds().get(0);
                    x = Integer.parseInt(args[0]);
                    y = Integer.parseInt(args[1]);
                    z = Integer.parseInt(args[2]);
                    this.nms.setWorldSpawn(world, x, y, z);
                    sender.sendMessage(this.nms.nms.String(1, "SetWorldSpawn", "Set the world spawn point (%world%,%x%,%y%,%z%)").replace("%world%", world.getName()).replace("%x%", x + "").replace("%y%", x + "").replace("%z%", y + ""));
                    return true;
                } else if (args.length == 4) {
                    world = this.nms.getWorld(args[0]);
                    x = Integer.parseInt(args[1]);
                    y = Integer.parseInt(args[2]);
                    z = Integer.parseInt(args[3]);
                    this.nms.setWorldSpawn(world, x, y, z);
                    sender.sendMessage(this.nms.nms.String(1, "SetWorldSpawn", "Set the world spawn point (%world%,%x%,%y%,%z%)").replace("%world%", world.getName()).replace("%x%", x + "").replace("%y%", x + "").replace("%z%", y + ""));
                    return true;
                } else {
                    world = (World)this.nms.getWorlds().get(0);
                    x = world.getSpawnLocation().getBlockX();
                    y = world.getSpawnLocation().getBlockY();
                    z = world.getSpawnLocation().getBlockZ();
                    this.nms.setWorldSpawn(world, x, y, z);
                    sender.sendMessage(this.nms.nms.String(1, "SetWorldSpawn", "Set the world spawn point (%world%,%x%,%y%,%z%)").replace("%world%", world.getName()).replace("%x%", x + "").replace("%y%", x + "").replace("%z%", y + ""));
                    return true;
                }
            } else if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.setworldspawn.others")) {
                sender.sendMessage(this.nms.nms.Permission());
                return true;
            } else {
                if (args.length == 3) {
                    p = this.nms.getPlayer(sender);
                    world = p.getWorld();
                    x = Integer.parseInt(args[0]);
                    y = Integer.parseInt(args[1]);
                    z = Integer.parseInt(args[2]);
                    this.nms.setWorldSpawn(world, x, y, z);
                    sender.sendMessage(this.nms.nms.String(1, "SetWorldSpawn", "Set the world spawn point (%world%,%x%,%y%,%z%)").replace("%world%", world.getName()).replace("%x%", x + "").replace("%y%", y + "").replace("%z%", z + ""));
                    return true;
                } else if (args.length == 4) {
                    world = this.nms.getWorld(args[0]);
                    x = Integer.parseInt(args[0]);
                    y = Integer.parseInt(args[1]);
                    z = Integer.parseInt(args[2]);
                    this.nms.setWorldSpawn(world, x, y, z);
                    sender.sendMessage(this.nms.nms.String(1, "SetWorldSpawn", "Set the world spawn point (%world%,%x%,%y%,%z%)").replace("%world%", world.getName()).replace("%x%", x + "").replace("%y%", x + "").replace("%z%", y + ""));
                    return true;
                } else {
                    p = this.nms.getPlayer(sender);
                    world = p.getWorld();
                    x = Integer.parseInt(args[0]);
                    y = Integer.parseInt(args[1]);
                    z = Integer.parseInt(args[2]);
                    this.nms.setWorldSpawn(world, x, y, z);
                    sender.sendMessage(this.nms.nms.String(1, "SetWorldSpawn", "Set the world spawn point (%world%,%x%,%y%,%z%)").replace("%world%", world.getName()).replace("%x%", x + "").replace("%y%", y + "").replace("%z%", z + ""));
                    return true;
                }
            }
        } else {
            return true;
        }
    }
}
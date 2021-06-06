package org.functions.Commands.Permissions;

import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;
import org.functions.Main.Functions;

public class CommandSpawn implements CommandExecutor {
    private Functions a = Functions.getMain();
    private PlayerNMS nms = new PlayerNMS();

    public CommandSpawn() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn") && sender instanceof Player) {
            if (args.length == 0) {
                String w = "";

                World world;
                for(Iterator var21 = this.nms.getWorlds().iterator(); var21.hasNext(); w = w + world.getName() + ",") {
                    world = (World)var21.next();
                }

                String arg = w.split(",")[0].toString();
                world = this.nms.getWorld(arg);
                Location loc = world.getSpawnLocation();
                double x = loc.getX();
                double y = loc.getY();
                double z = loc.getZ();
                float yaw = loc.getYaw();
                float pitch = loc.getPitch();
                Location Loc = this.nms.Location(world, x, y, z, yaw, yaw);
                Player p = this.nms.getPlayer(sender);
                p.teleport(Loc);
                sender.sendMessage(this.a.String(1, "Teleport-Spawn", "%player% Teleport to spawn(%location%)").replace("%player%", sender.getName()).replace("%location%", this.nms.toLocationString(p)));
                return true;
            }

            if (args.length == 1) {
                Iterator var5 = this.nms.getWorlds().iterator();

                while(var5.hasNext()) {
                    World worl = (World)var5.next();
                    if (args[0].equalsIgnoreCase(worl.getName())) {
                        if (!this.a.hasPermission(sender.getName(), "functions.command.spawn.world.*") && !this.a.hasPermission(sender.getName(), "functions.command.spawn.world." + worl.getName())) {
                            sender.sendMessage(this.a.Permission());
                            return true;
                        }

                        String w = worl.getName();
                        World world = this.nms.getWorld(w);
                        Location loc = world.getSpawnLocation();
                        double x = loc.getX();
                        double y = loc.getY();
                        double z = loc.getZ();
                        float yaw = loc.getYaw();
                        float pitch = loc.getPitch();
                        Location Loc = this.nms.Location(world, x, y, z, yaw, pitch);
                        Player p = this.nms.getPlayer(sender);
                        p.teleport(Loc);
                        sender.sendMessage(this.a.String(1, "Teleport-Spawn", "%player% Teleport to spawn(%location%)").replace("%player%", sender.getName()).replace("%location%", this.nms.toLocationString(p)));
                        return true;
                    }
                }
            }
        }

        return true;
    }
}
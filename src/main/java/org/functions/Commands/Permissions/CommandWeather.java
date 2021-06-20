package org.functions.Commands.Permissions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;

public class CommandWeather implements TabExecutor {
    private PlayerNMS nms = new PlayerNMS();

    public CommandWeather() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("weather")) {
            if (sender instanceof Player) {
                if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.weather.others")) {
                    sender.sendMessage(this.nms.nms.Permission());
                    return true;
                }
                if (args.length == 0) {
                    sender.sendMessage(this.nms.nms.String(1, "Usage-Weather", "Usage: /weather <clear|rain|thunder>"));
                    return true;
                }

                int Weather = (300 + (new Random()).nextInt(600)) * 20;
                World world = this.nms.getWorld(this.nms.getPlayer(sender));
                if (args[0].equalsIgnoreCase("clear")) {
                    world.setWeatherDuration(0);
                    world.setThunderDuration(0);
                    world.setStorm(false);
                    world.setThundering(false);
                    sender.sendMessage(this.nms.nms.String(1, "Weather-Clear", "The weather change clear"));
                    return true;
                }

                if (args[0].equalsIgnoreCase("rain")) {
                    world.setWeatherDuration(Weather);
                    world.setStorm(true);
                    world.setThundering(false);
                    sender.sendMessage(this.nms.nms.String(1, "Weather-Rain", "The weather change rain"));
                    return true;
                }

                if (args[0].equalsIgnoreCase("thunder")) {
                    world.setWeatherDuration(Weather);
                    world.setThunderDuration(Weather);
                    world.setStorm(true);
                    world.setThundering(true);
                    sender.sendMessage(this.nms.nms.String(1, "Weather-Thunder", "The weather change thunder"));
                    return true;
                }
            }
            if (args.length == 0) {
                sender.sendMessage(this.nms.nms.String(1, "Usage-Weather", "Usage: /weather <clear|rain|thunder>"));
                return true;
            }

            int Weather = (300 + (new Random()).nextInt(600)) * 20;
            World world = this.nms.getWorld(this.nms.getPlayer(sender));
            if (args[0].equalsIgnoreCase("clear")) {
                world.setWeatherDuration(0);
                world.setThunderDuration(0);
                world.setStorm(false);
                world.setThundering(false);
                sender.sendMessage(this.nms.nms.String(1, "Weather-Clear", "The weather change clear"));
                return true;
            }

            if (args[0].equalsIgnoreCase("rain")) {
                world.setWeatherDuration(Weather);
                world.setStorm(true);
                world.setThundering(false);
                sender.sendMessage(this.nms.nms.String(1, "Weather-Rain", "The weather change rain"));
                return true;
            }

            if (args[0].equalsIgnoreCase("thunder")) {
                world.setWeatherDuration(Weather);
                world.setThunderDuration(Weather);
                world.setStorm(true);
                world.setThundering(true);
                sender.sendMessage(this.nms.nms.String(1, "Weather-Thunder", "The weather change thunder"));
                return true;
            }
        }

        return true;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> s = new ArrayList();
        s.add("clear");
        s.add("rain");
        s.add("thunder");
        return s;
    }
}

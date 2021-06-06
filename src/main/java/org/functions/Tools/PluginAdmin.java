package org.functions.Tools;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

public class PluginAdmin {
    private static final String prefix = "§7§l[§6§lP§c§lR§7§l] §7";
    private static final Field plugins;
    private static final Field lookupNames;
    private static final Map<String, Command> knownCommands;
    private static final SimplePluginManager mgr = (SimplePluginManager) Bukkit.getPluginManager();
    private static final List<String> TC_MAIN = Arrays.asList("load", "unload", "reload", "query");
    private static final List<String> TC_EMPTY = Collections.emptyList();
    private static YamlConfiguration config;
    private static File plugins_folder;
    private void unload(CommandSender sender, String name, Plugin p) {
        try {
            mgr.disablePlugin(p);
            List<String> list = new ArrayList();
            Iterator var5 = knownCommands.entrySet().iterator();

            while(var5.hasNext()) {
                Map.Entry<String, Command> entry = (Map.Entry)var5.next();
                if (entry.getValue() instanceof PluginCommand && ((PluginCommand)entry.getValue()).getPlugin() == p) {
                    list.add(entry.getKey());
                }
            }

            Stream var10000 = list.stream();
            Map var10001 = knownCommands;
            var10000.forEach(var10001::remove);
            ((List)plugins.get(mgr)).remove(p);
            ((Map)lookupNames.get(mgr)).remove(p.getName().replace(' ', '_'));
            HandlerList.unregisterAll(p);
            System.gc();
            sender.sendMessage("§7§l[§6§lP§c§lR§7§l] §7" + config.getString("language.unload_success").replaceAll("%0%", name));
        } catch (Exception var7) {
            sender.sendMessage("§7§l[§6§lP§c§lR§7§l] §7" + config.getString("language.unload_failed") + p.getName());
            //this.getLogger().warning("Failed to unload " + p.getName() + ", stacktrace:");
            var7.printStackTrace();
        }

    }

    private void load(CommandSender sender, File f) {
        try {
            Plugin c = mgr.loadPlugin(f);
            c.onLoad();
            mgr.enablePlugin(c);
            sender.sendMessage("§7§l[§6§lP§c§lR§7§l] §7" + config.getString("language.load_success").replaceAll("%0%", c.getName()));
        } catch (InvalidPluginException var4) {
            sender.sendMessage("§7§l[§6§lP§c§lR§7§l] §7" + config.getString("language.invalid_plugin"));
            //this.getLogger().warning("Failed to load plugin " + f.getName() + ", stacktrace:");
            var4.printStackTrace();
        }

    }

    static {
        try {
            plugins = SimplePluginManager.class.getDeclaredField("plugins");
            plugins.setAccessible(true);
            lookupNames = SimplePluginManager.class.getDeclaredField("lookupNames");
            lookupNames.setAccessible(true);
            Class<?> craftServer = Bukkit.getServer().getClass();
            Field map = craftServer.getDeclaredField("commandMap");
            map.setAccessible(true);
            Field cmd = SimpleCommandMap.class.getDeclaredField("knownCommands");
            cmd.setAccessible(true);
            knownCommands = (Map)cmd.get(map.get(Bukkit.getServer()));
        } catch (IllegalAccessException | NoSuchFieldException var3) {
            throw new RuntimeException(var3);
        }
    }
}

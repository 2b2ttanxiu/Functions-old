package org.functions.Commands.Permissions;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerManger;
import org.functions.API.PlayerNMS;

public class CommandPlugins implements TabExecutor {
    PlayerNMS nms = new PlayerManger();
    Field plugins;
    Field lookupNames;
    Map<String, Command> knownCommands;
    public CommandPlugins() {
    }
    public static void run(JavaPlugin j) {
        j.getCommand("plugins").setExecutor(new CommandPlugins());
        j.getCommand("plugins").setTabCompleter(new CommandPlugins());
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("plugins")) {
            String Description;
            String IsEnabled;
            if (args.length == 0) {
                int i = 0;
                String list = "";
                String Plugin = this.nms.nms.getSettings().getString("List.Plugins");
                Plugin[] var18 = this.nms.getServer().getPluginManager().getPlugins();
                int var19 = var18.length;

                for(int var20 = 0; var20 < var19; ++var20) {
                    Plugin p = var18[var20];
                    ++i;
                    Description = p.getDescription().getName();
                    IsEnabled = this.nms.BooleanChange(Description, p.isEnabled());
                    list = list + Plugin.replace("%plugin%", IsEnabled).replace("%count%", i + "");
                }

                sender.sendMessage(this.nms.nms.String(1, "ListPlugins", "Plugins (%count%): %plugins%").replace("%plugins%", list).replace("%count%", i + ""));
                return true;
            }

            Plugin[] var5;
            int var6;
            int var7;
            Plugin p;
            String Name;
            String Version;
            List author;
            String main;
            if (args.length == 1) {
                var5 = this.nms.getServer().getPluginManager().getPlugins();
                var6 = var5.length;

                for(var7 = 0; var7 < var6; ++var7) {
                    p = var5[var7];
                    if (p.getDescription().getName().equalsIgnoreCase(args[0])) {
                        Name = p.getDescription().getName();
                        Version = p.getDescription().getVersion();
                        author = p.getDescription().getAuthors();
                        Description = "";
                        if (p.getDescription().getDescription() != null) {
                            Description = p.getDescription().getDescription();
                        }

                        IsEnabled = this.nms.Boolean(p.isEnabled());
                        main = p.getDescription().getMain();
                        sender.sendMessage(this.nms.nms.String(1, "InfoPlugin", "The plugin name: %name%\nThe plugin version: %version%\nThe plugin author: %author%\nThe plugin description: %description%\nThe plugin main: %main%\nThe plugin is enabled: %enabled%").replace("%name%", Name).replace("%version%", Version).replace("%author%", author.toString().replace("[", "").replace("]", "")).replace("%description%", Description).replace("%main%", main).replace("%enabled%", IsEnabled));
                    }
                }
            }

            if (args.length == 2) {
                var5 = this.nms.getServer().getPluginManager().getPlugins();
                var6 = var5.length;

                for(var7 = 0; var7 < var6; ++var7) {
                    p = var5[var7];
                    if (p.getDescription().getName().equalsIgnoreCase(args[0])) {
                        Name = p.getDescription().getName();
                        Version = p.getDescription().getVersion();
                        author = p.getDescription().getAuthors();
                        Description = "";
                        if (p.getDescription().getDescription() != null) {
                            Description = p.getDescription().getDescription();
                        }

                        IsEnabled = this.nms.Boolean(p.isEnabled());
                        main = p.getDescription().getMain();
                        if ("on".equalsIgnoreCase(args[1])) {
                            System.out.println(p.getDataFolder());
                            try {
                                nms.getServer().getPluginManager().loadPlugin(new File(p.getDataFolder()+".jar"));
                            } catch (InvalidPluginException e) {
                                e.printStackTrace();
                            } catch (InvalidDescriptionException e) {
                                e.printStackTrace();
                            }
                            //nms.getServer().getPluginManager().enablePlugin(p);
                            sender.sendMessage(nms.nms.String(1,"EnabledPlugin","The plugin is on(enabled): {0}").replace("{0}",Name));
                            return true;
                        }
                        if ("off".equalsIgnoreCase(args[1])) {

                            nms.getServer().getPluginManager().disablePlugin(p);
                            sender.sendMessage(nms.nms.String(1,"DisabledPlugin","The plugin is off(disabled): {0}").replace("{0}",Name));
                            return true;
                        }
                        if ("name".equalsIgnoreCase(args[1])) {
                            sender.sendMessage(this.nms.nms.String(1, "InfoPluginName", "The plugin name: {0}").replace("{0}", Name));
                            return true;
                        }

                        if ("version".equalsIgnoreCase(args[1])) {
                            sender.sendMessage(this.nms.nms.String(1, "InfoPluginVersion", "The plugin version: {0}").replace("{0}", Version));
                            return true;
                        }

                        if ("author".equalsIgnoreCase(args[1])) {
                            sender.sendMessage(this.nms.nms.String(1, "InfoPluginAuthor", "The plugin author: {0}").replace("{0}", author.toString().replace("[", "").replace("]", "")));
                            return true;
                        }

                        if ("description".equalsIgnoreCase(args[1])) {
                            sender.sendMessage(this.nms.nms.String(1, "InfoPluginDescription", "The plugin description: {0}").replace("{0}", Description));
                            return true;
                        }

                        if ("enabled".equalsIgnoreCase(args[1])) {
                            sender.sendMessage(this.nms.nms.String(1, "InfoPluginEnabled", "The plugin enabled: {0}").replace("{0}", IsEnabled));
                            return true;
                        }

                        if ("main".equalsIgnoreCase(args[1])) {
                            sender.sendMessage(this.nms.nms.String(1, "InfoPluginMain", "The plugin main: {0}").replace("{0}", main));
                            return true;
                        }

                        if ("all".equalsIgnoreCase(args[1])) {
                            sender.sendMessage(this.nms.nms.String(1, "InfoPlugin", "The plugin name: %name%\nThe plugin version: %version%\nThe plugin author: %author%\nThe plugin description: %description%\nThe plugin main: %main%\nThe plugin is enabled: %enabled%").replace("%name%", Name).replace("%version%", Version).replace("%author%", author.toString().replace("[", "").replace("]", "")).replace("%description%", Description).replace("%main%", main).replace("%enabled%", IsEnabled));
                            return true;
                        }

                        sender.sendMessage(this.nms.nms.String(1, "InfoPlugin", "The plugin name: %name%\nThe plugin version: %version%\nThe plugin author: %author%\nThe plugin description: %description%\nThe plugin main: %main%\nThe plugin is enabled: %enabled%").replace("%name%", Name).replace("%version%", Version).replace("%author%", author.toString().replace("[", "").replace("]", "")).replace("%description%", Description).replace("%main%", main).replace("%enabled%", IsEnabled));
                    }
                }
            }
        }

        return true;
    }
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> s = new ArrayList();
        if (args.length == 2) {
            s.add("name");
            s.add("version");
            s.add("author");
            s.add("description");
            s.add("enabled");
            s.add("main");
            s.add("all");
            return s;
        } else {
            Plugin[] var6 = this.nms.getServer().getPluginManager().getPlugins();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                Plugin p = var6[var8];
                s.add(p.getName());
            }

            return s;
        }
    }
}
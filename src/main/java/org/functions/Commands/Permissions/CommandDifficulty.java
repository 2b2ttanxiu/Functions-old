package org.functions.Commands.Permissions;

import java.util.Iterator;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.Difficulty;
import org.functions.API.PlayerNMS;
import org.functions.API.Difficulty.Type;

public class CommandDifficulty implements CommandExecutor {
    PlayerNMS nms = new PlayerNMS();

    public CommandDifficulty() {
    }

    public static void run(JavaPlugin javaPlugin) {
        javaPlugin.getCommand("difficulty").setExecutor(new CommandDifficulty());
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("difficulty")) {
            Difficulty di;
            World w;
            Iterator var9;
            if (!(sender instanceof Player)) {
                if (args.length == 1) {
                    di = new Difficulty((World)this.nms.getWorlds().get(0));
                    if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase(Type.PEACEFUL.name())) {
                        di.setDifficulty(Type.PEACEFUL);
                        sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Peaceful", "Set game difficulty to Peaceful"));
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase(Type.EASY.name())) {
                        di.setDifficulty(Type.EASY);
                        sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Easy", "Set game difficulty to Easy"));
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase(Type.NORMAL.name())) {
                        di.setDifficulty(Type.NORMAL);
                        sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Normal", "Set game difficulty to Normal"));
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase(Type.HARD.name())) {
                        di.setDifficulty(Type.HARD);
                        sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Hard", "Set game difficulty to Hard"));
                        return true;
                    }
                }

                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("all")) {
                        if (args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase(Type.PEACEFUL.name())) {
                            var9 = this.nms.getWorlds().iterator();

                            while(var9.hasNext()) {
                                w = (World)var9.next();
                                di = new Difficulty(w);
                                di.setDifficulty(Type.PEACEFUL);
                            }

                            sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Peaceful", "Set game difficulty to Peaceful"));
                            return true;
                        }

                        if (args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase(Type.EASY.name())) {
                            var9 = this.nms.getWorlds().iterator();

                            while(var9.hasNext()) {
                                w = (World)var9.next();
                                di = new Difficulty(w);
                                di.setDifficulty(Type.EASY);
                            }

                            sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Easy", "Set game difficulty to Easy"));
                            return true;
                        }

                        if (args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase(Type.NORMAL.name())) {
                            var9 = this.nms.getWorlds().iterator();

                            while(var9.hasNext()) {
                                w = (World)var9.next();
                                di = new Difficulty(w);
                                di.setDifficulty(Type.NORMAL);
                            }

                            sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Normal", "Set game difficulty to Normal"));
                            return true;
                        }

                        if (args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase(Type.HARD.name())) {
                            var9 = this.nms.getWorlds().iterator();

                            while(var9.hasNext()) {
                                w = (World)var9.next();
                                di = new Difficulty(w);
                                di.setDifficulty(Type.HARD);
                            }

                            sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Hard", "Set game difficulty to Hard"));
                            return true;
                        }
                    } else if (this.nms.getWorld(args[0]) != null) {
                        label378: {
                            this.nms.getWorld(args[0]);
                            di = new Difficulty(this.nms.getWorld(args[0]));
                            if (!args[1].equalsIgnoreCase("0") && !args[1].equalsIgnoreCase(Type.PEACEFUL.name())) {
                                if (!args[1].equalsIgnoreCase("1") && !args[1].equalsIgnoreCase(Type.EASY.name())) {
                                    if (!args[1].equalsIgnoreCase("2") && !args[1].equalsIgnoreCase(Type.NORMAL.name())) {
                                        if (!args[1].equalsIgnoreCase("3") && !args[1].equalsIgnoreCase(Type.HARD.name())) {
                                            break label378;
                                        }

                                        di.setDifficulty(Type.HARD);
                                        sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Hard", "Set game difficulty to Hard"));
                                        return true;
                                    }

                                    di.setDifficulty(Type.NORMAL);
                                    sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Normal", "Set game difficulty to Normal"));
                                    return true;
                                }

                                di.setDifficulty(Type.EASY);
                                sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Easy", "Set game difficulty to Easy"));
                                return true;
                            }

                            di.setDifficulty(Type.PEACEFUL);
                            sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Peaceful", "Set game difficulty to Peaceful"));
                            return true;
                        }
                    }
                }
            }

            if (args.length == 1) {
                label379: {
                    di = new Difficulty((World)this.nms.getWorlds().get(0));
                    if (!args[0].equalsIgnoreCase("0") && !args[0].equalsIgnoreCase(Type.PEACEFUL.name())) {
                        if (!args[0].equalsIgnoreCase("1") && !args[0].equalsIgnoreCase(Type.EASY.name())) {
                            if (!args[0].equalsIgnoreCase("2") && !args[0].equalsIgnoreCase(Type.NORMAL.name())) {
                                if (!args[0].equalsIgnoreCase("3") && !args[0].equalsIgnoreCase(Type.HARD.name())) {
                                    break label379;
                                }

                                if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.hard")) {
                                    sender.sendMessage(this.nms.nms.Permission());
                                    return true;
                                }

                                di.setDifficulty(Type.HARD);
                                sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Hard", "Set game difficulty to Hard"));
                                return true;
                            }

                            if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.normal")) {
                                sender.sendMessage(this.nms.nms.Permission());
                                return true;
                            }

                            di.setDifficulty(Type.NORMAL);
                            sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Normal", "Set game difficulty to Normal"));
                            return true;
                        }

                        if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.easy")) {
                            sender.sendMessage(this.nms.nms.Permission());
                            return true;
                        }

                        di.setDifficulty(Type.EASY);
                        sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Easy", "Set game difficulty to Easy"));
                        return true;
                    }

                    if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.peaceful")) {
                        sender.sendMessage(this.nms.nms.Permission());
                        return true;
                    }

                    di.setDifficulty(Type.PEACEFUL);
                    sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Peaceful", "Set game difficulty to Peaceful"));
                    return true;
                }
            }

            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("all")) {
                    if (args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase(Type.PEACEFUL.name())) {
                        if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.peaceful.all")) {
                            sender.sendMessage(this.nms.nms.Permission());
                            return true;
                        }

                        var9 = this.nms.getWorlds().iterator();

                        while(var9.hasNext()) {
                            w = (World)var9.next();
                            di = new Difficulty(w);
                            di.setDifficulty(Type.PEACEFUL);
                        }

                        sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Peaceful", "Set game difficulty to Peaceful"));
                        return true;
                    }

                    if (args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase(Type.EASY.name())) {
                        if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.easy.all")) {
                            sender.sendMessage(this.nms.nms.Permission());
                            return true;
                        }

                        var9 = this.nms.getWorlds().iterator();

                        while(var9.hasNext()) {
                            w = (World)var9.next();
                            di = new Difficulty(w);
                            di.setDifficulty(Type.EASY);
                        }

                        sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Easy", "Set game difficulty to Easy"));
                        return true;
                    }

                    if (!args[1].equalsIgnoreCase("2") && !args[1].equalsIgnoreCase(Type.NORMAL.name())) {
                        if (!args[1].equalsIgnoreCase("3") && !args[1].equalsIgnoreCase(Type.HARD.name())) {
                            return true;
                        }

                        if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.hard.all")) {
                            sender.sendMessage(this.nms.nms.Permission());
                            return true;
                        }

                        var9 = this.nms.getWorlds().iterator();

                        while(var9.hasNext()) {
                            w = (World)var9.next();
                            di = new Difficulty(w);
                            di.setDifficulty(Type.HARD);
                        }

                        sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Hard", "Set game difficulty to Hard"));
                        return true;
                    }

                    if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.normal.all")) {
                        sender.sendMessage(this.nms.nms.Permission());
                        return true;
                    }

                    var9 = this.nms.getWorlds().iterator();

                    while(var9.hasNext()) {
                        w = (World)var9.next();
                        di = new Difficulty(w);
                        di.setDifficulty(Type.NORMAL);
                    }

                    sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Normal", "Set game difficulty to Normal"));
                    return true;
                } else if (this.nms.getWorld(args[0]) != null) {
                    w = this.nms.getWorld(args[0]);
                    di = new Difficulty(this.nms.getWorld(args[0]));
                    if (!args[1].equalsIgnoreCase("0") && !args[1].equalsIgnoreCase(Type.PEACEFUL.name())) {
                        if (!args[1].equalsIgnoreCase("1") && !args[1].equalsIgnoreCase(Type.EASY.name())) {
                            if (!args[1].equalsIgnoreCase("2") && !args[1].equalsIgnoreCase(Type.NORMAL.name())) {
                                if (args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase(Type.HARD.name())) {
                                    if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.hard.world." + w.getName())) {
                                        sender.sendMessage(this.nms.nms.Permission());
                                        return true;
                                    }

                                    di.setDifficulty(Type.HARD);
                                    sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Hard", "Set game difficulty to Hard"));
                                    return true;
                                }

                                return true;
                            }

                            if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.normal.world." + w.getName())) {
                                sender.sendMessage(this.nms.nms.Permission());
                                return true;
                            }

                            di.setDifficulty(Type.NORMAL);
                            sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Normal", "Set game difficulty to Normal"));
                            return true;
                        }

                        if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.easy.world." + w.getName())) {
                            sender.sendMessage(this.nms.nms.Permission());
                            return true;
                        }

                        di.setDifficulty(Type.EASY);
                        sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Easy", "Set game difficulty to Easy"));
                        return true;
                    }

                    if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.difficulty.peaceful.world." + w.getName())) {
                        sender.sendMessage(this.nms.nms.Permission());
                        return true;
                    }

                    di.setDifficulty(Type.PEACEFUL);
                    sender.sendMessage(this.nms.nms.String(1, "SetDifficulty-Peaceful", "Set game difficulty to Peaceful"));
                    return true;
                }
            }
        }

        return true;
    }
}
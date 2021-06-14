package org.functions.Commands.Permissions;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class CommandChat implements TabExecutor {
    private Functions p = Functions.getMain();

    public CommandChat() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("chat")) {
            int i;
            if (!(sender instanceof Player)) {
                if (args.length == 0) {
                    sender.sendMessage(this.p.String(1, "Usage-Chat", "/chat <channel|clear>"));
                    return true;
                }

                if (args[0].equalsIgnoreCase("channel")) {
                    if (this.p.getData().getString(sender.getName() + ".Type.Chat").equals("Public")) {
                        sender.sendMessage(this.p.String(1, "TypeChannel", "Your channel change %type%!").replace("%type%", "World").replace("%player%", sender.getName()));
                        this.p.getData().set(sender.getName() + ".Type.Chat", "World");
                        this.p.SaveConfig();
                        return true;
                    }

                    if (this.p.getData().getString(sender.getName() + ".Type.Chat").equals("World")) {
                        sender.sendMessage(this.p.String(1, "TypeChannel", "Your channel change %type%!").replace("%type%", "Group").replace("%player%", sender.getName()));
                        this.p.getData().set(sender.getName() + ".Type.Chat", "Group");
                        this.p.SaveConfig();
                        return true;
                    }

                    if (this.p.getData().getString(sender.getName() + ".Type.Chat").equals("Group")) {
                        sender.sendMessage(this.p.String(1, "TypeChannel", "Your channel change %type%!").replace("%type%", "Private").replace("%player%", sender.getName()));
                        this.p.getData().set(sender.getName() + ".Type.Chat", "Private");
                        this.p.SaveConfig();
                        return true;
                    }

                    if (this.p.getData().getString(sender.getName() + ".Type.Chat").equals("Private")) {
                        sender.sendMessage(this.p.String(1, "TypeChannel", "Your channel change %type%!").replace("%type%", "Public").replace("%player%", sender.getName()));
                        this.p.getData().set(sender.getName() + ".Type.Chat", "Public");
                        this.p.SaveConfig();
                        return true;
                    }
                }

                if (args[0].equalsIgnoreCase("clear")) {
                    if (args.length == 1) {
                        for(i = 0; i < 2000; ++i) {
                            sender.sendMessage("");
                        }

                        sender.sendMessage(this.p.String(1, "Clean-Chat", "Clear the chat!").replace("%player%", sender.getName()));
                        return true;
                    }

                    if (args[1].equalsIgnoreCase("all")) {
                        for(i = 0; i < 2000; ++i) {
                            sender.sendMessage("");
                        }
                    }
                }
            } else {
                if (!this.p.hasPermission(sender.getName(), "functions.command.chat.others")) {
                    sender.sendMessage(this.p.Permission());
                    return true;
                }

                if (args.length == 0) {
                    sender.sendMessage(this.p.String(1, "Usage-Chat", "/chat <channel|clear>"));
                    return true;
                }

                if (args[0].equalsIgnoreCase("channel")) {
                    if (this.p.getData().getString(sender.getName() + ".Type.Chat").equals("Public")) {
                        sender.sendMessage(this.p.String(1, "TypeChannel", "Your channel change %type%!").replace("%type%", "World").replace("%player%", sender.getName()));
                        this.p.getData().set(sender.getName() + ".Type.Chat", "World");
                        this.p.SaveConfig();
                        return true;
                    }

                    if (this.p.getData().getString(sender.getName() + ".Type.Chat").equals("World")) {
                        sender.sendMessage(this.p.String(1, "TypeChannel", "Your channel change %type%!").replace("%type%", "Group").replace("%player%", sender.getName()));
                        this.p.getData().set(sender.getName() + ".Type.Chat", "Group");
                        this.p.SaveConfig();
                        return true;
                    }

                    if (this.p.getData().getString(sender.getName() + ".Type.Chat").equals("Group")) {
                        sender.sendMessage(this.p.String(1, "TypeChannel", "Your channel change %type%!").replace("%type%", "Private").replace("%player%", sender.getName()));
                        this.p.getData().set(sender.getName() + ".Type.Chat", "Private");
                        this.p.SaveConfig();
                        return true;
                    }

                    if (this.p.getData().getString(sender.getName() + ".Type.Chat").equals("Private")) {
                        sender.sendMessage(this.p.String(1, "TypeChannel", "Your channel change %type%!").replace("%type%", "Public").replace("%player%", sender.getName()));
                        this.p.getData().set(sender.getName() + ".Type.Chat", "Public");
                        this.p.SaveConfig();
                        return true;
                    }
                }

                if (args[0].equalsIgnoreCase("clear")) {
                    if (args.length == 1) {
                        for(i = 0; i < 2000; ++i) {
                            sender.sendMessage("");
                        }

                        sender.sendMessage(this.p.String(1, "Clean-Chat", "Clear the chat!").replace("%player%", sender.getName()));
                        return true;
                    }

                    if (args[1].equalsIgnoreCase("all")) {
                        for(i = 0; i < 2000; ++i) {
                            sender.sendMessage("");
                        }
                    }
                }
            }
        }

        return true;
    }
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> s = new ArrayList();
        if (args[0].equalsIgnoreCase("clear") && args.length == 2) {
            s.add("all");
            return s;
        } else {
            if (args.length == 1) {
                if (p.hasPermission(sender.getName(), "functions.command.chat.others")) {
                    s.add("channel");
                    s.add("clear");
                }
            }

            return s;
        }
    }
}
package org.functions.Commands.Permissions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.functions.API.PlayerManger;
import org.functions.Main.Functions;

public class CommandMain implements TabExecutor {
    private Functions p = Functions.getMain();

    public CommandMain() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("functions")) {
            if (!sender.isOp()) {
                sender.sendMessage(this.p.Permission());
                return true;
            }

            if (args.length == 0) {
                List<String> sf = new ArrayList<>();
                sf.add("&eAuthor: 2b2ttianxiu");
                sf.add("&aGitee: https://gitee.com/tianxiu2b2t/Functions");
                sf.add("&aGithub: https://github.com/2b2ttanxiu/Functions");
                sf.add("&eTeam: Functions");
                sf.add("&dMail: 794609509@qq.com");
                sf.add("&bYou version: %version%");
                sf.add("&bSo much thank you uses Functions!");
                for (String s1 : sf) {
                    sender.sendMessage(s1.replace("%version%", this.p.NowVersion()).replace("&", "§").replace("%color%", "§").replace("§", "§"));
                }
                return true;
            }

            if (args[0].equalsIgnoreCase("Update-Language")) {
                File file = new File(this.p.getDataFolder(), "Language-" + this.p.getConfig().getString("Language") + ".yml");
                File files = new File(this.p.getDataFolder(), "Language-" + this.p.getConfig().getString("Language") + ".old.yml");
                if (files.equals(file)) {
                    sender.sendMessage(this.p.String(1, "DonUpdate-Language", "The language don't update."));
                    return true;
                }

                if (files.exists()) {
                    files.deleteOnExit();
                }

                file.renameTo(files);
                file.deleteOnExit();
                this.p.initconfig();
                sender.sendMessage(this.p.String(1, "Update-Language", "Rename Languages to old.Updated your language."));
                return true;
            }

            if (args[0].equalsIgnoreCase("debug")) {
                new PlayerManger();
                sender.sendMessage(this.p.getDataFolder() + "");
                sender.sendMessage(this.p.getDataFolder().toString() + "");
                sender.sendMessage(this.p.getDataFolder().toPath() + "");
                sender.sendMessage(this.p.getDataFolder().getName() + "");
                sender.sendMessage(this.p.getDataFolder().toURI() + "");
                sender.sendMessage(this.p.getDataFolder().toURI().getRawPath() + "");
                return true;
            }

            long a;
            if (args[0].equalsIgnoreCase("reload")) {
                a = System.currentTimeMillis();
                this.p.initconfig();
                this.p.reloadConfig();
                sender.sendMessage(this.p.String(1, "Functions-Reload", "§aReloaded successfully in %time-ms%").replace("%time-ms%", ((double)System.currentTimeMillis() - (double)a) / 1000.0D + ""));
                return true;
            }

            if (args[0].equalsIgnoreCase("confirm")) {
                a = System.currentTimeMillis();
                this.p.getServer().reload();
                sender.sendMessage(this.p.String(1, "Functions-Reload", "§aReloaded successfully in %time-ms%").replace("%time-ms%", ((double)System.currentTimeMillis() - (double)a) / 1000.0D + ""));
                return true;
            }

            if (args[0].equalsIgnoreCase("reloadData")) {
                a = System.currentTimeMillis();
                this.p.getServer().reloadData();
                sender.sendMessage(this.p.String(1, "Functions-Reload", "§aReloaded successfully in %time-ms%").replace("%time-ms%", ((double)System.currentTimeMillis() - (double)a) / 1000.0D + ""));
                return true;
            }

            if (args[0].equalsIgnoreCase("group")) {
                Iterator var5 = this.p.ListGroup().iterator();

                while(var5.hasNext()) {
                    String x = (String)var5.next();
                    if (x.equals(args[1])) {
                        if (args[1].equals(this.p.getGroup(args[2]))) {
                            sender.sendMessage(this.p.String(1, "TargetInGroup", "%target% in the %group%").replace("%target%", args[2]).replace("%group%", args[1]));
                            return true;
                        }

                        this.p.getData().set(args[2] + ".Group", args[1]);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "setGroup", "%target% set %group%").replace("%target%", args[2]).replace("%group%", args[1]));
                        return true;
                    }
                }
            }

            List ls;
            if (args[0].equalsIgnoreCase("op")) {
                ls = this.p.getOP().getStringList("Administrators");
                Iterator var16 = this.p.getOP().getStringList("Administrators").iterator();

                String x;
                do {
                    if (!var16.hasNext()) {
                        ls.add(args[1]);
                        this.p.getOP().set("Administrators", ls);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "GiveAdministrator", "Give %target% server administrator").replace("%player%", sender.getName()).replace("%target%", args[1]));
                        return true;
                    }

                    x = (String)var16.next();
                } while(!x.equals(args[1]));

                sender.sendMessage(this.p.String(1, "Administrator-TargetIf", "§c%target% if server administrator!").replace("%player%", sender.getName()).replace("%target%", args[1]));
                return true;
            }

            if (args[0].equalsIgnoreCase("smode")) {
                if (this.p.getSettings().getBoolean("Maintenance")) {
                    this.p.getSettings().set("Maintenance", false);
                    this.p.SaveConfig();
                    sender.sendMessage(this.p.String(1, "Maintenance", "Maintenance of %boolean%").replace("%boolean%", "false"));
                    return true;
                }

                this.p.getSettings().set("Maintenance", true);
                this.p.SaveConfig();
                sender.sendMessage(this.p.String(1, "Maintenance", "Maintenance of %boolean%").replace("%boolean%", "true"));
                return true;
            }

            if (args[0].equalsIgnoreCase("start")) {
                sender.sendMessage(this.p.String(1, "StartServerTime", "Start Server Time: %starttime%").replace("%starttime%", this.p.getStartTime()));
            }

            if (args[0].equalsIgnoreCase("deop")) {
                ls = this.p.getOP().getStringList("Administrators");
                if (ls.size() == 0) {
                    sender.sendMessage(this.p.String(1, "Administrator-Null", "§cServer administrator of null!,Pleases use /functions op <player> add server administrator.").replace("%player%", sender.getName()));
                    return true;
                }

                boolean is = false;
                Iterator var7 = this.p.getOP().getStringList("Administrators").iterator();

                do {
                    if (!var7.hasNext()) {
                        ls.remove(args[0]);
                        this.p.getOP().set("Administrators", ls);
                        this.p.SaveConfig();
                        sender.sendMessage(this.p.String(1, "DeleteAdministrator", "Remove %target% server administrator").replace("%player%", sender.getName()).replace("%target%", args[0]));
                        return true;
                    }

                    String x = (String)var7.next();
                    if (x.equals(args[0])) {
                        is = true;
                    }
                } while(is);

                sender.sendMessage(this.p.String(1, "NoAdministrator-TargetIf", "§c%target% no if server administrator!").replace("%player%", sender.getName()).replace("%target%", args[0]));
                return true;
            }
        }

        return true;
    }
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> s = new ArrayList();
        if (args.length == 1) {
            s.add("reload");
            s.add("confirm");
            s.add("update-language");
            s.add("reloaddata");
            s.add("smode");
            return s;
        } else {
            return s;
        }
    }
}
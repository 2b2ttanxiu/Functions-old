package org.functions.Commands.Permissions;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.functions.API.PlayerManger;
import org.functions.Main.Functions;
import org.functions.shop.Menu;

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
            if (args[0].equalsIgnoreCase("menu")) {
                Menu menu = new Menu((Player) sender, "Test");
                menu.openMenu();
                return true;
            }
            if (args[0].equalsIgnoreCase("update-Configuration")) {
                File dir = p.getDataFolder();
                //if (dir_old.exists()) {
                 //   dir_old.
                //}
                //dir.renameTo(p.getDataFolder()+"-old")
                p.initconfig();
                sender.sendMessage(p.String(1,"Updater-Configuration","Delete and updater configuration"));
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
                p.reloadConfiguration();
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
        }

        return true;
    }
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> s = new ArrayList();
        if (!sender.isOp()) {
            return null;
        }
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
package org.functions.Main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.CachedServerIcon;
import org.functions.API.FunctionsAPI;
import org.functions.API.PlayerManger;
import org.functions.API.PlayerNMS;
import org.functions.Tools.*;
import org.functions.net.minecraft.server.ServerJar;

public class Functions extends JavaPlugin {
    private long Long = System.currentTimeMillis();
    private static Functions main;
    private CachedServerIcon image;
    private CachedServerIcon smode;
    private File language;
    private File user;
    private File data;
    private File datamoney;
    private File permission;
    private File warp;
    private File home;
    private File help;
    private File group;
    private File latest;
    private File banned;
    private File title;
    private File back;
    private File op;
    private File settings;
    private File s;
    private File report;
    private File temp;
    private File tab;
    private File automessage;
    private FileConfiguration AutoMessage;
    private FileConfiguration Tab;
    private FileConfiguration Temp;
    private FileConfiguration Report;
    private FileConfiguration Settings;
    private FileConfiguration OP;
    private FileConfiguration Language;
    private FileConfiguration User;
    private FileConfiguration Data;
    private FileConfiguration DataMoney;
    private FileConfiguration Permission;
    private FileConfiguration Warp;
    private FileConfiguration Home;
    private FileConfiguration Help;
    private FileConfiguration Group;
    private FileConfiguration Latest;
    private FileConfiguration Banned;
    private FileConfiguration Title;
    private FileConfiguration Back;
    private boolean ifPaper;
    private boolean isPaper;
    private boolean isSpigot;
    private boolean isBukkit;

    public Functions() {
    }

    public void initconfig() {
        Iterator var1;
        String x;
        for(var1 = this.getConfig().getStringList("ServerIcon").iterator(); var1.hasNext(); this.s = new File(this.getDataFolder(), x)) {
            x = (String)var1.next();
        }

        this.report = new File(this.getDataFolder(), "Report.yml");
        this.language = new File(this.getDataFolder(), "Language-" + this.getConfig().getString("Language") + ".yml");
        this.user = new File(this.getDataFolder(), "Users.yml");
        this.data = new File(this.getDataFolder(), "Data.yml");
        this.datamoney = new File(this.getDataFolder(), "DataMoneys.yml");
        this.permission = new File(this.getDataFolder(), "Permissions.yml");
        this.warp = new File(this.getDataFolder(), "Warps.yml");
        this.home = new File(this.getDataFolder(), "Homes.yml");
        this.help = new File(this.getDataFolder(), "Helps.yml");
        this.group = new File(this.getDataFolder(), "Groups.yml");
        this.latest = new File(this.getDataFolder(), "Latest.yml");
        this.banned = new File(this.getDataFolder(), "Banned.yml");
        this.title = new File(this.getDataFolder(), "ServerTitle.yml");
        this.back = new File(this.getDataFolder(), "Backs.yml");
        this.op = new File(this.getDataFolder(), "op.yml");
        this.settings = new File(this.getDataFolder(), "Settings.yml");
        this.temp = new File(this.getDataFolder(), "Temp.yml");
        this.tab = new File(this.getDataFolder(), "Tab.yml");
        this.automessage = new File(this.getDataFolder(), "PlayerStatus.yml");
        if (!this.s.exists()) {
            var1 = this.getConfig().getStringList("ServerIcon").iterator();

            while(var1.hasNext()) {
                x = (String)var1.next();
                this.saveResource(x, false);
            }
        }

        if (!this.tab.exists()) {
            this.saveResource("Tab.yml", false);
        }

        if (!this.report.exists()) {
            this.saveResource("Report.yml", false);
        }

        if (!this.language.exists()) {
            this.saveResource("Language-" + this.getConfig().getString("Language") + ".yml", false);
        }

        if (!this.user.exists()) {
            this.saveResource("Users.yml", false);
        }

        if (!this.data.exists()) {
            this.saveResource("Data.yml", false);
        }

        if (!this.datamoney.exists()) {
            this.saveResource("DataMoneys.yml", false);
        }

        if (!this.permission.exists()) {
            this.saveResource("Permissions.yml", false);
        }

        if (!this.warp.exists()) {
            this.saveResource("Warps.yml", false);
        }

        if (!this.home.exists()) {
            this.saveResource("Homes.yml", false);
        }

        if (!this.help.exists()) {
            this.saveResource("Helps.yml", false);
        }

        if (!this.group.exists()) {
            this.saveResource("Groups.yml", false);
        }

        if (!this.latest.exists()) {
            this.saveResource("Latest.yml", false);
        }

        if (!this.banned.exists()) {
            this.saveResource("Banned.yml", false);
        }

        if (!this.title.exists()) {
            this.saveResource("ServerTitle.yml", false);
        }

        if (!this.back.exists()) {
            this.saveResource("Backs.yml", false);
        }

        if (!this.op.exists()) {
            this.saveResource("op.yml", false);
        }

        if (!this.settings.exists()) {
            this.saveResource("Settings.yml", false);
        }

        if (!this.temp.exists()) {
            this.saveResource("Temp.yml", false);
        }

        if (!this.automessage.exists()) {
            this.saveResource("PlayerStatus.yml", false);
        }

        this.Tab = new YamlConfiguration();
        this.Report = new YamlConfiguration();
        this.Language = new YamlConfiguration();
        this.User = new YamlConfiguration();
        this.Data = new YamlConfiguration();
        this.DataMoney = new YamlConfiguration();
        this.Permission = new YamlConfiguration();
        this.Warp = new YamlConfiguration();
        this.Home = new YamlConfiguration();
        this.Help = new YamlConfiguration();
        this.Group = new YamlConfiguration();
        this.Latest = new YamlConfiguration();
        this.Banned = new YamlConfiguration();
        this.Title = new YamlConfiguration();
        this.Back = new YamlConfiguration();
        this.OP = new YamlConfiguration();
        this.Settings = new YamlConfiguration();
        this.Temp = new YamlConfiguration();
        this.AutoMessage = new YamlConfiguration();
        YamlConfiguration.loadConfiguration(this.tab);
        YamlConfiguration.loadConfiguration(this.report);
        YamlConfiguration.loadConfiguration(this.language);
        YamlConfiguration.loadConfiguration(this.user);
        YamlConfiguration.loadConfiguration(this.data);
        YamlConfiguration.loadConfiguration(this.datamoney);
        YamlConfiguration.loadConfiguration(this.permission);
        YamlConfiguration.loadConfiguration(this.warp);
        YamlConfiguration.loadConfiguration(this.home);
        YamlConfiguration.loadConfiguration(this.help);
        YamlConfiguration.loadConfiguration(this.group);
        YamlConfiguration.loadConfiguration(this.latest);
        YamlConfiguration.loadConfiguration(this.banned);
        YamlConfiguration.loadConfiguration(this.title);
        YamlConfiguration.loadConfiguration(this.back);
        YamlConfiguration.loadConfiguration(this.op);
        YamlConfiguration.loadConfiguration(this.settings);
        YamlConfiguration.loadConfiguration(this.temp);
        YamlConfiguration.loadConfiguration(this.automessage);

        try {
            var1 = this.getConfig().getStringList("ServerIcon").iterator();

            while(var1.hasNext()) {
                x = (String)var1.next();
                this.getServer().loadServerIcon(new File(this.getDataFolder(), x));
            }

            this.AutoMessage.load(this.automessage);
            this.Tab.load(this.tab);
            this.Temp.load(this.temp);
            this.Report.load(this.report);
            this.Language.load(this.language);
            this.User.load(this.user);
            this.Data.load(this.data);
            this.DataMoney.load(this.datamoney);
            this.Permission.load(this.permission);
            this.Warp.load(this.warp);
            this.Home.load(this.home);
            this.Help.load(this.help);
            this.Group.load(this.group);
            this.Latest.load(this.latest);
            this.Banned.load(this.banned);
            this.Title.load(this.title);
            this.Back.load(this.back);
            this.OP.load(this.op);
            this.Settings.load(this.settings);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void SaveConfig() {
        try {
            this.getTab().save(new File(this.getDataFolder(), "Tab.yml"));
            this.getTemp().save(new File(this.getDataFolder(), "Temp.yml"));
            this.getReport().save(new File(this.getDataFolder(), "Report.yml"));
            this.getLanguage().save(new File(this.getDataFolder(), "Language-" + this.getConfig().getString("Language") + ".yml"));
            this.getUser().save(new File(this.getDataFolder(), "Users.yml"));
            this.getData().save(new File(this.getDataFolder(), "Data.yml"));
            this.getDataMoney().save(new File(this.getDataFolder(), "DataMoneys.yml"));
            this.getPermission().save(new File(this.getDataFolder(), "Permissions.yml"));
            this.getWarp().save(new File(this.getDataFolder(), "Warps.yml"));
            this.getHome().save(new File(this.getDataFolder(), "Homes.yml"));
            this.getHelp().save(new File(this.getDataFolder(), "Helps.yml"));
            this.getLatest().save(new File(this.getDataFolder(), "Latest.yml"));
            this.getBanned().save(new File(this.getDataFolder(), "Banned.yml"));
            this.getBack().save(new File(this.getDataFolder(), "Backs.yml"));
        } catch (IOException var2) {
        }

    }
    public void SaveOP() {
        try {
            this.getOP().save(new File(this.getDataFolder(), "op.yml"));
        } catch(IOException var) {

        }
    }
    public void saveStatus() {
        try {
            this.getStatus().save(new File(this.getDataFolder(), "PlayerStatus.yml"));
        } catch (IOException var2) {
        }

    }

    public FileConfiguration getTab() {
        return this.Tab;
    }

    public FileConfiguration getTemp() {
        return this.Temp;
    }

    public FileConfiguration getReport() {
        return this.Report;
    }

    public FileConfiguration getLanguage() {
        return this.Language;
    }

    public FileConfiguration getUser() {
        return this.User;
    }

    public FileConfiguration getData() {
        return this.Data;
    }

    public FileConfiguration getDataMoney() {
        return this.DataMoney;
    }

    public FileConfiguration getPermission() {
        return this.Permission;
    }

    public FileConfiguration getWarp() {
        return this.Warp;
    }

    public FileConfiguration getHome() {
        return this.Home;
    }

    public FileConfiguration getHelp() {
        return this.Help;
    }

    public FileConfiguration getGroup() {
        return this.Group;
    }

    public FileConfiguration getLatest() {
        return this.Latest;
    }

    public FileConfiguration getBanned() {
        return this.Banned;
    }

    public FileConfiguration getTitle() {
        return this.Title;
    }

    public FileConfiguration getBack() {
        return this.Back;
    }

    public FileConfiguration getOP() {
        return this.OP;
    }

    public FileConfiguration getSettings() {
        return this.Settings;
    }

    public FileConfiguration getStatus() {
        return this.AutoMessage;
    }

    public void onLoad() {
        if (!(new File(this.getDataFolder(), "config.yml")).exists()) {
            this.saveResource("config.yml", false);
        }

        ServerJar jar = new ServerJar();
        this.sendConsole(1, "The server you're using is " + jar.toString() + "!");
        this.sendConsole(1, "init plugin success!");
    }
    public boolean IsBungeeCord() {
        try {
            return (boolean) Class.forName("org.spigotmc.SpigotConfig").getField("bungee").get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void onEnable() {
        main = this;
        RegisterListener listener = new RegisterListener(this);
        this.sendConsole(1, "Listener is register!");
        listener.run();
        this.sendConsole(1, "Listener is enabled!");
        RegisterCommand command = new RegisterCommand(this);
        this.sendConsole(1, "Command is register!");
        command.run();
        this.sendConsole(1, "Command is enabled!");
        this.initconfig();
        this.sendConsole(1, "Configuration if init!");
        Iterator var3 = this.getSettings().getStringList("AnimationsEnable").iterator();

        while(var3.hasNext()) {
            String x = (String)var3.next();
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Animations(x), 20L, (long)(this.getSettings().getInt("Animations." + x + ".ChangeLine") / 1000 * 20));
        }
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new OnScoreBoard(), 20L, 20L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new TabCheck(), 20L, 20L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new TPS(), 100L, 1L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new ServerTitleRandomText(), 20L, (long)(this.getTitle().getInt("ResetTitle") / 1000 * 20));
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new PlayerOnline(), 20L, 20L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new TabList(), 1L, 1L);
        this.sendConsole(1, "Thread if enabled!");
        String v = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        this.sendConsole(1, "Server NMS version: " + v + ".");
        if (IsBungeeCord()) {
            sendConsole(1, "The server has Bungee");
        }
        this.sendConsole(1, "MC Version: " + this.API().getHandler().getMCVersion().toString());
        this.sendConsole(1, "Done <" + ((double)System.currentTimeMillis() - (double)this.Long) / 1000.0D + "s>! For help, type \"help\" or \"?\".");
        this.sendConsole(1, "Time of service has benn recorded");
        this.sendConsole(1, "The languages of \"" + this.getConfig().getString("Language") + "\".");
        this.sendConsole(1, "The plugin is first use?");
        this.sendConsole(1, "The plugin is a using please command /functions.");
        CheckJvm.checkJvm();
        new PlayerManger();
        this.getConfig().set("StartServerTime", this.Long);
        this.saveConfig();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new StartServer(), 20L, 20L);
    }

    public String getStart() {
        StartServer start = new StartServer();
        return start.get();
    }

    public String getStartTime() {
        String[] args = this.getStart().split(":");
        String s = this.getSettings().getString("Date-Time.Start");
        return s.replace("%yyyy%", args[0]).replace("%mm%", args[1]).replace("%dd%", args[2]).replace("%h%", args[3]).replace("%m%", args[4]).replace("%s%", args[5]);
    }

    public String NowVersion() {
        return this.getDescription().getVersion();
    }

    public static Functions getMain() {
        return main;
    }
    public PlayerNMS nms() {
        return new PlayerNMS();
    }
    public FunctionsAPI API() {
        return new FunctionsAPI();
    }

    public void onDisable() {
        this.getConfig().set("StartServerTime", (Object)null);
    }

    public void run(boolean Enabled) {
        this.setEnabled(Enabled);
    }

    public String Prefix() {
        String Prefix = "§3[§bFunctions§3] ";
        if (this.getConfig().getString("PluginPrefix") != null) {
            Prefix = this.getConfig().getString("PluginPrefix");
        }

        return Prefix.replace("&", "§");
    }

    public List<String> getWarps() {
        return this.getWarp().getStringList("WarpList");
    }

    public void sendConsole(int Prefix, Object Message) {
        if (Prefix == 0) {
            this.getServer().getConsoleSender().sendMessage(Message + "");
        }

        if (Prefix == 1) {
            this.getServer().getConsoleSender().sendMessage(this.Prefix() + Message + "");
        }

    }
    public void sendTargetMessage(Player send,Player copy,String Message) {
        send.sendMessage(getGroup().getString(Group + ".Format.Message.To").replace("%player%", send.getName()).replace("%target%", copy.getName()).replace("%world%", send.getWorld().getName()).replace("%prefix%", this.getPrefix(this.getGroup(send.getName()), send.getName())).replace("%suffix%", this.getSuffix(this.getGroup(send.getName()), send.getName())).replace("%date%", this.getDate()).replace("%time%", this.getTime()).replace("%message%", Message).replace("&", "§"));
        copy.sendMessage(getGroup().getString(Group + ".Format.Message.From").replace("%player%", send.getName()).replace("%target%", copy.getName()).replace("%world%", send.getWorld().getName()).replace("%prefix%", this.getPrefix(this.getGroup(send.getName()), send.getName())).replace("%suffix%", this.getSuffix(this.getGroup(send.getName()), send.getName())).replace("%date%", this.getDate()).replace("%time%", this.getTime()).replace("%message%", Message).replace("&", "§"));
    }

    public String Say(String DisplayName, String Group, String Message) {
        String say = "";
        say = this.getGroup().getString(Group + ".Format.Say").replace("%player%", DisplayName).replace("%prefix%", this.getPrefix(this.getGroup(DisplayName), DisplayName)).replace("%suffix%", this.getSuffix(this.getGroup(DisplayName), DisplayName)).replace("%message%", Message).replace("&", "§");
        return say;
    }

    public String Permission() {
        return this.String(1, "NotPermission", "&cbut you do not have permissions.").replace("&", "§");
    }

    public boolean hasPermission(String DisplayName, String Permission) {
        boolean is = false;
        Iterator var4 = this.getPermission().getStringList(DisplayName).iterator();

        String x;
        while(var4.hasNext()) {
            x = (String)var4.next();
            if (x.equals(Permission)) {
                is = true;
            }
        }

        var4 = this.getGroup().getStringList(this.getGroup(DisplayName) + ".Permissions").iterator();

        while(var4.hasNext()) {
            x = (String)var4.next();
            if (x.equals(Permission)) {
                is = true;
            }
        }

        return is;
    }

    public String OnlinePlayers(String DisplayName) {
        String player = "";
        String list = this.getGroup().getString(this.getGroup(DisplayName) + ".Format.ListOnline");
        int i = 0;

        Player p;
        for(Iterator var5 = this.getServer().getOnlinePlayers().iterator(); var5.hasNext(); player = player + list.replace("%players%", p.getName()).replace("%count%", i + "")) {
            p = (Player)var5.next();
            ++i;
        }

        return player;
    }

    public String String(int Prefix, String String, String Default) {
        String str = "";
        if (this.getLanguage().getString(String) == null) {
            if (Prefix == 0) {
                str = Default;
            }

            if (Prefix == 1) {
                str = this.Prefix() + Default;
            }

            this.getLanguage().addDefault(String, Default);
            this.getLanguage().options().copyDefaults(true);
            this.getLanguage().options().copyHeader();
            this.SaveConfig();
        } else {
            if (Prefix == 0) {
                str = this.getLanguage().getString(String);
            }

            if (Prefix == 1) {
                str = this.Prefix() + this.getLanguage().getString(String);
            }
        }

        Iterator var5 = this.getSettings().getStringList("AnimationsEnable").iterator();

        while(var5.hasNext()) {
            String x = (String)var5.next();
            List<String> ls = this.getSettings().getStringList("Animations." + x + ".Texts");
            int i = this.getSettings().getInt("Animations." + x + ".Line");
            str.replace("%animation:" + x + "%", (CharSequence)ls.get(i));
        }

        return str.replace("&", "§").replace("%date%", this.getDate()).replace("%tps%", this.API().getHandler().nms().getTPS()).replace("%time%", this.getTime()).replace("/n", "\n").replace("%servername%", this.getServerName()).replace("%plugin_prefix%", this.Prefix()).replace("%spigot_tps%",nms().tps());
    }

    public boolean getDisplayNameOnline(String DisplayName) {
        boolean is = false;
        Iterator var3 = this.getServer().getOnlinePlayers().iterator();

        while(var3.hasNext()) {
            Player p = (Player)var3.next();
            if (DisplayName.equals(p.getName())) {
                is = true;
            }
        }

        return is;
    }

    public String getServerName() {
        return this.getConfig().getString("ServerName", "Unknown Server");
    }

    public String getDisplayName(String DisplayName) {
        String Name = "";
        Iterator var3 = this.getServer().getOnlinePlayers().iterator();

        while(var3.hasNext()) {
            Player p = (Player)var3.next();
            if (DisplayName.equals(p.getName())) {
                Name = p.getName();
            }
        }

        return Name;
    }

    public String ChatGroup(Player Player, String Group, String Message) {
        return this.getGroup().getString(Group + ".Format.Chat").replace("%player%", Player.getName()).replace("%world%", Player.getWorld().getName()).replace("%prefix%", this.getPrefix(this.getGroup(Player.getName()), Player.getName())).replace("%suffix%", this.getSuffix(this.getGroup(Player.getName()), Player.getName())).replace("%date%", this.getDate()).replace("%time%", this.getTime()).replace("%message%", Message).replace("&", "§");
    }

    public String getGroup(String DisplayName) {
        return this.getData().getString(DisplayName + ".Group");
    }

    public String getPrefix(String Group, String DisplayName) {
        String Prefix = "";
        if (this.getData().getString(DisplayName) == null) {
            Prefix = "none";
        } else if (this.getData().getString(DisplayName + ".Prefix") == null) {
            if (this.getGroup().getString(Group + ".Prefix").equals("none")) {
                Prefix = "";
            } else {
                Prefix = this.getGroup().getString(Group + ".Prefix");
            }
        } else {
            Prefix = this.getData().getString(DisplayName + ".Prefix");
        }

        return Prefix.replace("&", "§");
    }

    public void setPrefix(String DisplayName, String Prefix) {
        this.getData().set(DisplayName + ".Prefix", Prefix);
        this.SaveConfig();
    }
    public String OnlyPlayer() {
        return String(1,"OnlyPlayer","You don't player,This is command only player.");
    }
    public void setSuffix(String DisplayName, String Suffix) {
        this.getData().set(DisplayName + ".Suffix", Suffix);
        this.SaveConfig();
    }

    public void resetPrefix(String DisplayName) {
        this.getData().set(DisplayName + ".Prefix", (Object)null);
        this.SaveConfig();
    }

    public void resetSuffix(String DisplayName) {
        this.getData().set(DisplayName + ".Suffix", (Object)null);
        this.SaveConfig();
    }

    public String getSuffix(String Group, String DisplayName) {
        String Suffix = "";
        if (this.getData().getString(DisplayName) == null) {
            Suffix = "none";
        } else if (this.getData().getString(DisplayName + ".Suffix") == null) {
            if (this.getGroup().getString(Group + ".Suffix").equals("none")) {
                Suffix = "";
            } else {
                Suffix = this.getGroup().getString(Group + ".Suffix");
            }
        } else {
            Suffix = this.getData().getString(DisplayName + ".Suffix");
        }

        return Suffix.replace("&", "§");
    }

    public String getDate() {
        Date date = new Date();
        SimpleDateFormat Date = new SimpleDateFormat(this.getSettings().getString("Date-Time.Date"));
        return Date.format(date);
    }

    public String getTime(long Time) {
        Date date = new Date(Time);
        SimpleDateFormat Date = new SimpleDateFormat(this.getSettings().getString("Date-Time.DayTime"));
        return Date.format(date);
    }

    public String getTime() {
        Date date = new Date();
        SimpleDateFormat Date = new SimpleDateFormat(this.getSettings().getString("Date-Time.Time"));
        return Date.format(date);
    }

    public void setGroup(String DisplayName, String Group) {
        boolean is = false;
        Iterator var4 = this.ListGroup().iterator();

        while(var4.hasNext()) {
            String x = (String)var4.next();
            if (Group.equals(x)) {
                is = true;
            }
        }

        if (!is) {
            this.getGroup().set(Group + ".Chat", "");
        }

    }

    public List<String> ListGroup() {
        return this.getConfig().getStringList("List.Group");
    }
}

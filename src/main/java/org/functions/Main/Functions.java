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
import org.functions.Tools.*;
import org.functions.API.PlayerNMS;
import org.functions.net.minecraft.server.ServerJar;
import org.yaml.snakeyaml.Yaml;

public class Functions extends JavaPlugin {
    private File away;
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
    private File menu = new File(getDataFolder(),"Menu.yml");
    private FileConfiguration Menu;
    private FileConfiguration Away;
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
    public void saveData() {
        try {
            Data.save(new File(getDataFolder(),"Data.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void reloadConfiguration() {
        Iterator var1;
        String x;
        for(var1 = getConfig().getStringList("ServerIcon").iterator(); var1.hasNext(); s = new File(getDataFolder(), x)) {
            x = (String)var1.next();
        }

        report = new File(getDataFolder(), "Report.yml");
        language = new File(getDataFolder(), "Language-" + getConfig().getString("Language") + ".yml");
        user = new File(getDataFolder(), "Users.yml");
        data = new File(getDataFolder(), "Data.yml");
        datamoney = new File(getDataFolder(), "DataMoneys.yml");
        permission = new File(getDataFolder(), "Permissions.yml");
        warp = new File(getDataFolder(), "Warps.yml");
        home = new File(getDataFolder(), "Homes.yml");
        help = new File(getDataFolder(), "Helps.yml");
        group = new File(getDataFolder(), "Groups.yml");
        latest = new File(getDataFolder(), "Latest.yml");
        banned = new File(getDataFolder(), "Banned.yml");
        title = new File(getDataFolder(), "ServerTitle.yml");
        back = new File(getDataFolder(), "Backs.yml");
        op = new File(getDataFolder(), "op.yml");
        settings = new File(getDataFolder(), "Settings.yml");
        temp = new File(getDataFolder(), "Temp.yml");
        tab = new File(getDataFolder(), "Tab.yml");
        automessage = new File(getDataFolder(), "PlayerStatus.yml");
        away = new File(getDataFolder(), "AwayFromKeyBoard.yml");
        if (!s.exists()) {
            var1 = getConfig().getStringList("ServerIcon").iterator();

            while(var1.hasNext()) {
                x = (String)var1.next();
                saveResource(x, false);
            }
        }
        try {
            var1 = getConfig().getStringList("ServerIcon").iterator();

            while(var1.hasNext()) {
                x = (String)var1.next();
                getServer().loadServerIcon(new File(getDataFolder(), x));
            }

            getStatus().load(automessage);
            getTab().load(tab);
            getTemp().load(temp);
            getReport().load(report);
            getLanguage().load(language);
            getUser().load(user);
            getData().load(data);
            getDataMoney().load(datamoney);
            getPermission().load(permission);
            getWarp().load(warp);
            getHome().load(home);
            getHelp().load(help);
            getGroup().load(group);
            getLatest().load(latest);
            getBanned().load(banned);
            getTitle().load(title);
            getBack().load(back);
            getOP().load(op);
            getSettings().load(settings);
            getAway().load(away);
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }
    public void initconfig() {
        Iterator var1;
        String x;
        for(var1 = getConfig().getStringList("ServerIcon").iterator(); var1.hasNext(); s = new File(getDataFolder(), x)) {
            x = (String)var1.next();
        }

       report = new File(getDataFolder(), "Report.yml");
       language = new File(getDataFolder(), "Language-" + getConfig().getString("Language") + ".yml");
       user = new File(getDataFolder(), "Users.yml");
       data = new File(getDataFolder(), "Data.yml");
       datamoney = new File(getDataFolder(), "DataMoneys.yml");
       permission = new File(getDataFolder(), "Permissions.yml");
       warp = new File(getDataFolder(), "Warps.yml");
       home = new File(getDataFolder(), "Homes.yml");
       help = new File(getDataFolder(), "Helps.yml");
       group = new File(getDataFolder(), "Groups.yml");
       latest = new File(getDataFolder(), "Latest.yml");
       banned = new File(getDataFolder(), "Banned.yml");
       title = new File(getDataFolder(), "ServerTitle.yml");
       back = new File(getDataFolder(), "Backs.yml");
       op = new File(getDataFolder(), "op.yml");
       settings = new File(getDataFolder(), "Settings.yml");
       temp = new File(getDataFolder(), "Temp.yml");
       tab = new File(getDataFolder(), "Tab.yml");
       automessage = new File(getDataFolder(), "PlayerStatus.yml");
       away = new File(getDataFolder(), "AwayFromKeyBoard.yml");
        if (!menu.exists()) {
            saveResource("Menu.yml",false);
        }
        if (!s.exists()) {
            var1 = getConfig().getStringList("ServerIcon").iterator();

            while(var1.hasNext()) {
                x = (String)var1.next();
                saveResource(x, false);
            }
        }

        if (!tab.exists()) {
            saveResource("Tab.yml", false);
        }

        if (!report.exists()) {
            saveResource("Report.yml", false);
        }

        if (!language.exists()) {
            saveResource("Language-" + getConfig().getString("Language") + ".yml", false);
        }

        if (!user.exists()) {
            saveResource("Users.yml", false);
        }

        if (!data.exists()) {
            saveResource("Data.yml", false);
        }

        if (!datamoney.exists()) {
            saveResource("DataMoneys.yml", false);
        }

        if (!permission.exists()) {
            saveResource("Permissions.yml", false);
        }

        if (!warp.exists()) {
            saveResource("Warps.yml", false);
        }

        if (!home.exists()) {
            saveResource("Homes.yml", false);
        }

        if (!help.exists()) {
            saveResource("Helps.yml", false);
        }

        if (!group.exists()) {
            saveResource("Groups.yml", false);
        }

        if (!latest.exists()) {
            saveResource("Latest.yml", false);
        }

        if (!banned.exists()) {
            saveResource("Banned.yml", false);
        }

        if (!title.exists()) {
            saveResource("ServerTitle.yml", false);
        }

        if (!back.exists()) {
            saveResource("Backs.yml", false);
        }

        if (!op.exists()) {
            saveResource("op.yml", false);
        }

        if (!settings.exists()) {
            saveResource("Settings.yml", false);
        }

        if (!temp.exists()) {
            saveResource("Temp.yml", false);
        }

        if (!automessage.exists()) {
            saveResource("PlayerStatus.yml", false);
        }
        if (!away.exists()) {
            saveResource("AwayFromKeyBoard.yml",false);
        }
        Menu = new YamlConfiguration();
        Tab = new YamlConfiguration();
        Report = new YamlConfiguration();
        Language = new YamlConfiguration();
        User = new YamlConfiguration();
        Data = new YamlConfiguration();
        DataMoney = new YamlConfiguration();
        Permission = new YamlConfiguration();
        Warp = new YamlConfiguration();
        Home = new YamlConfiguration();
        Help = new YamlConfiguration();
        Group = new YamlConfiguration();
        Latest = new YamlConfiguration();
        Banned = new YamlConfiguration();
        Title = new YamlConfiguration();
        Back = new YamlConfiguration();
        OP = new YamlConfiguration();
        Settings = new YamlConfiguration();
        Temp = new YamlConfiguration();
        AutoMessage = new YamlConfiguration();
        Away = new YamlConfiguration();
        YamlConfiguration.loadConfiguration(menu);
        YamlConfiguration.loadConfiguration(tab);
        YamlConfiguration.loadConfiguration(report);
        YamlConfiguration.loadConfiguration(language);
        YamlConfiguration.loadConfiguration(user);
        YamlConfiguration.loadConfiguration(data);
        YamlConfiguration.loadConfiguration(datamoney);
        YamlConfiguration.loadConfiguration(permission);
        YamlConfiguration.loadConfiguration(warp);
        YamlConfiguration.loadConfiguration(home);
        YamlConfiguration.loadConfiguration(help);
        YamlConfiguration.loadConfiguration(group);
        YamlConfiguration.loadConfiguration(latest);
        YamlConfiguration.loadConfiguration(banned);
        YamlConfiguration.loadConfiguration(title);
        YamlConfiguration.loadConfiguration(back);
        YamlConfiguration.loadConfiguration(op);
        YamlConfiguration.loadConfiguration(settings);
        YamlConfiguration.loadConfiguration(temp);
        YamlConfiguration.loadConfiguration(automessage);
        YamlConfiguration.loadConfiguration(away);

        try {
            var1 = getConfig().getStringList("ServerIcon").iterator();

            while(var1.hasNext()) {
                x = (String)var1.next();
                getServer().loadServerIcon(new File(getDataFolder(), x));
            }
            Menu.load(menu);
            AutoMessage.load(automessage);
            Tab.load(tab);
            Temp.load(temp);
            Report.load(report);
            Language.load(language);
            User.load(user);
            Data.load(data);
            DataMoney.load(datamoney);
            Permission.load(permission);
            Warp.load(warp);
            Home.load(home);
            Help.load(help);
            Group.load(group);
            Latest.load(latest);
            Banned.load(banned);
            Title.load(title);
            Back.load(back);
            OP.load(op);
            Settings.load(settings);
            Away.load(away);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void saveTab() {
        try {
            getTab().save(new File(getDataFolder(), "Tab.yml"));
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
    public void SaveConfig() {
        try {
            getTemp().save(new File(getDataFolder(), "Temp.yml"));
            getReport().save(new File(getDataFolder(), "Report.yml"));
            getLanguage().save(new File(getDataFolder(), "Language-" + getConfig().getString("Language") + ".yml"));
            getUser().save(new File(getDataFolder(), "Users.yml"));
            getData().save(new File(getDataFolder(), "Data.yml"));
            getDataMoney().save(new File(getDataFolder(), "DataMoneys.yml"));
            getPermission().save(new File(getDataFolder(), "Permissions.yml"));
            getWarp().save(new File(getDataFolder(), "Warps.yml"));
            getHome().save(new File(getDataFolder(), "Homes.yml"));
            getHelp().save(new File(getDataFolder(), "Helps.yml"));
            getLatest().save(new File(getDataFolder(), "Latest.yml"));
            getBanned().save(new File(getDataFolder(), "Banned.yml"));
            getBack().save(new File(getDataFolder(), "Backs.yml"));
            getAway().save(new File(getDataFolder(), "AwayFromKeyBoard.yml"));
        } catch (IOException var2) {
        }

    }
    public void SaveOP() {
        try {
            getOP().save(new File(getDataFolder(), "op.yml"));
        } catch(IOException var) {

        }
    }
    public void saveStatus() {
        try {
            getStatus().save(new File(getDataFolder(), "PlayerStatus.yml"));
        } catch (IOException var2) {
        }

    }
    public FileConfiguration getMenu() {return Menu;}
    public FileConfiguration getAway() {
        return Away;
    }
    public FileConfiguration getTab() {
        return Tab;
    }

    public FileConfiguration getTemp() {
        return Temp;
    }

    public FileConfiguration getReport() {
        return Report;
    }

    public FileConfiguration getLanguage() {
        return Language;
    }

    public FileConfiguration getUser() {
        return User;
    }

    public FileConfiguration getData() {
        return Data;
    }

    public FileConfiguration getDataMoney() {
        return DataMoney;
    }

    public FileConfiguration getPermission() {
        return Permission;
    }

    public FileConfiguration getWarp() {
        return Warp;
    }

    public FileConfiguration getHome() {
        return Home;
    }

    public FileConfiguration getHelp() {
        return Help;
    }

    public FileConfiguration getGroup() {
        return Group;
    }

    public FileConfiguration getLatest() {
        return Latest;
    }

    public FileConfiguration getBanned() {
        return Banned;
    }

    public FileConfiguration getTitle() {
        return Title;
    }

    public FileConfiguration getBack() {
        return Back;
    }

    public FileConfiguration getOP() {
        return OP;
    }

    public FileConfiguration getSettings() {
        return Settings;
    }

    public FileConfiguration getStatus() {
        return AutoMessage;
    }

    public void onLoad() {
        if (!(new File(getDataFolder(), "config.yml")).exists()) {
            saveResource("config.yml", false);
        }

        ServerJar jar = new ServerJar();
        sendConsole(1, "The server you're using is " + jar.toString() + "!");
        sendConsole(1, "init plugin success!");
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
        sendConsole(1, "Listener is register!");
        listener.run();
        sendConsole(1, "Listener is enabled!");
        RegisterCommand command = new RegisterCommand(this);
        sendConsole(1, "Command is register!");
        command.run();
        sendConsole(1, "Command is enabled!");
        initconfig();
        sendConsole(1, "Configuration if init!");
        Metrics me = new Metrics(this,11673);
        me.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
        sendConsole(1,"BStats on enabled");
        Iterator var3 = getSettings().getStringList("AnimationsEnable").iterator();

        while(var3.hasNext()) {
            String x = (String)var3.next();
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Animations(x), 20L, (long)(getSettings().getInt("Animations." + x + ".ChangeLine") / 1000 * 20));
        }
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this,new AwayRunnable(),20,20);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new OnScoreBoard(), 20L, 20L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new TabCheck(), 20L, 20L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new TPS(), 100L, 1L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new ServerTitleRandomText(), 20L, (long)(getTitle().getInt("ResetTitle") / 1000 * 20));
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new PlayerOnline(), 20L, 20L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new TabList(), 1L, 1L);
        sendConsole(1, "Thread if enabled!");
        String v = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        sendConsole(1, "Server NMS version: " + v + ".");
        if (IsBungeeCord()) {
            sendConsole(1, "The server has Bungee");
        }
        sendConsole(1, "MC Version: " + API().getHandler().getMCVersion().toString());
        sendConsole(1, "Done <" + ((double)System.currentTimeMillis() - (double)Long) / 1000.0D + "s>! For help, type \"help\" or \"?\".");
        sendConsole(1, "Time of service has benn recorded");
        sendConsole(1, "The languages of \"" + getConfig().getString("Language") + "\".");
        sendConsole(1, "The plugin is first use?");
        sendConsole(1, "The plugin is a using please command /functions.");
        CheckJvm.checkJvm();
        new PlayerManger();
        getConfig().set("StartServerTime", Long);
        saveConfig();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new StartServer(), 20L, 20L);
    }

    public String getStart() {
        StartServer start = new StartServer();
        return start.get();
    }

    public String getStartTime() {
        String[] args = getStart().split(":");
        String s = getSettings().getString("Date-Time.Start");
        return s.replace("%yyyy%", args[0]).replace("%mm%", args[1]).replace("%dd%", args[2]).replace("%h%", args[3]).replace("%m%", args[4]).replace("%s%", args[5]);
    }

    public String NowVersion() {
        return getDescription().getVersion();
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
        getConfig().set("StartServerTime", (Object)null);
        saveConfig();
        Bukkit.getServer().getScheduler().cancelTasks(this);
    }

    public void run(boolean Enabled) {
        setEnabled(Enabled);
    }

    public String Prefix() {
        String Prefix = "§3[§bFunctions§3] ";
        if (getConfig().getString("PluginPrefix") != null) {
            Prefix = getConfig().getString("PluginPrefix");
        }

        return Prefix.replace("&", "§");
    }

    public List<String> getWarps() {
        return getWarp().getStringList("WarpList");
    }

    public void sendConsole(int Prefix, Object Message) {
        if (Prefix == 0) {
            getServer().getConsoleSender().sendMessage(Message + "");
        }

        if (Prefix == 1) {
            getServer().getConsoleSender().sendMessage(Prefix() + Message + "");
        }

    }
    public void sendTargetMessage(Player send,Player copy,String Message) {
        send.sendMessage(getGroup().getString(Group + ".Format.Message.To").replace("%player%", send.getName()).replace("%target%", copy.getName()).replace("%world%", send.getWorld().getName()).replace("%prefix%", getPrefix(getGroup(send.getName()), send.getName())).replace("%suffix%", getSuffix(getGroup(send.getName()), send.getName())).replace("%date%", getDate()).replace("%time%", getTime()).replace("%message%", Message).replace("&", "§"));
        copy.sendMessage(getGroup().getString(Group + ".Format.Message.From").replace("%player%", send.getName()).replace("%target%", copy.getName()).replace("%world%", send.getWorld().getName()).replace("%prefix%", getPrefix(getGroup(send.getName()), send.getName())).replace("%suffix%", getSuffix(getGroup(send.getName()), send.getName())).replace("%date%", getDate()).replace("%time%", getTime()).replace("%message%", Message).replace("&", "§"));
    }

    public String Say(String DisplayName, String Group, String Message) {
        String say = "";
        say = getGroup().getString(Group + ".Format.Say").replace("%player%", DisplayName).replace("%prefix%", getPrefix(getGroup(DisplayName), DisplayName)).replace("%suffix%", getSuffix(getGroup(DisplayName), DisplayName)).replace("%message%", Message).replace("&", "§");
        return say;
    }

    public String Permission() {
        return String(1, "NotPermission", "&cbut you do not have permissions.").replace("&", "§");
    }

    public boolean hasPermission(String DisplayName, String Permission) {
        boolean is = false;
        Iterator var4 = getPermission().getStringList(DisplayName).iterator();

        String x;
        while(var4.hasNext()) {
            x = (String)var4.next();
            if (x.equals(Permission)) {
                is = true;
            }
        }

        var4 = getGroup().getStringList(getGroup(DisplayName) + ".Permissions").iterator();

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
        String list = getGroup().getString(getGroup(DisplayName) + ".Format.ListOnline");
        int i = 0;

        Player p;
        for(Iterator var5 = getServer().getOnlinePlayers().iterator(); var5.hasNext(); player = player + list.replace("%players%", p.getName()).replace("%count%", i + "")) {
            p = (Player)var5.next();
            ++i;
        }

        return player;
    }

    public String String(int Prefix, String String, String Default) {
        String str = "";
        if (getLanguage().getString(String) == null) {
            if (Prefix == 0) {
                str = Default;
            }

            if (Prefix == 1) {
                str = Prefix() + Default;
            }

            getLanguage().addDefault(String, Default);
            getLanguage().options().copyDefaults(true);
            getLanguage().options().copyHeader();
            SaveConfig();
        } else {
            if (Prefix == 0) {
                str = getLanguage().getString(String);
            }

            if (Prefix == 1) {
                str = Prefix() + getLanguage().getString(String);
            }
        }

        Iterator var5 = getSettings().getStringList("AnimationsEnable").iterator();

        while(var5.hasNext()) {
            String x = (String)var5.next();
            List<String> ls = getSettings().getStringList("Animations." + x + ".Texts");
            int i = getSettings().getInt("Animations." + x + ".Line");
            str.replace("%animation:" + x + "%", (CharSequence)ls.get(i));
        }

        return str.replace("&", "§").replace("%date%", getDate()).replace("%tps%", API().getHandler().nms().getTPS()).replace("%time%", getTime()).replace("/n", "\n").replace("%servername%", getServerName()).replace("%plugin_prefix%", Prefix()).replace("%spigot_tps%",nms().tps());
    }

    public boolean getDisplayNameOnline(String DisplayName) {
        boolean is = false;
        Iterator var3 = getServer().getOnlinePlayers().iterator();

        while(var3.hasNext()) {
            Player p = (Player)var3.next();
            if (DisplayName.equals(p.getName())) {
                is = true;
            }
        }

        return is;
    }

    public String getServerName() {
        return getConfig().getString("ServerName", "Unknown Server");
    }

    public String getDisplayName(String DisplayName) {
        String Name = "";
        Iterator var3 = getServer().getOnlinePlayers().iterator();

        while(var3.hasNext()) {
            Player p = (Player)var3.next();
            if (DisplayName.equals(p.getName())) {
                Name = p.getName();
            }
        }

        return Name;
    }
    public String ChatGroup(Player Player, String Group, String Message) {
        return getGroup().getString(Group + ".Format.Chat").replace("%player%", Player.getName()).replace("%world%", Player.getWorld().getName()).replace("%prefix%", getPrefix(getGroup(Player.getName()), Player.getName())).replace("%suffix%", getSuffix(getGroup(Player.getName()), Player.getName())).replace("%date%", getDate()).replace("%time%", getTime()).replace("%message%", Message).replace("&", "§");
    }

    public String getGroup(String DisplayName) {
        return getData().getString(DisplayName + ".Group");
    }
    public String getPrefix(String DisplayName) {
        String Group = getGroup(DisplayName);
        String Prefix = "";
        if (getData().getString(DisplayName) == null) {
            Prefix = "none";
        } else if (getData().getString(DisplayName + ".Prefix") == null) {
            if (getGroup().getString(Group + ".Prefix").equals("none")) {
                Prefix = "";
            } else {
                Prefix = getGroup().getString(Group + ".Prefix");
            }
        } else {
            Prefix = getData().getString(DisplayName + ".Prefix");
        }

        return Prefix.replace("&", "§");
    }
    @Deprecated
    public String getPrefix(String Group, String DisplayName) {
        String Prefix = "";
        if (getData().getString(DisplayName) == null) {
            Prefix = "none";
        } else if (getData().getString(DisplayName + ".Prefix") == null) {
            if (getGroup().getString(Group + ".Prefix").equals("none")) {
                Prefix = "";
            } else {
                Prefix = getGroup().getString(Group + ".Prefix");
            }
        } else {
            Prefix = getData().getString(DisplayName + ".Prefix");
        }

        return Prefix.replace("&", "§");
    }

    public void setPrefix(String DisplayName, String Prefix) {
        getData().set(DisplayName + ".Prefix", Prefix);
        SaveConfig();
    }
    public String OnlyPlayer() {
        return String(1,"OnlyPlayer","You don't player,This is command only player.");
    }
    public void setSuffix(String DisplayName, String Suffix) {
        getData().set(DisplayName + ".Suffix", Suffix);
        SaveConfig();
    }

    public void resetPrefix(String DisplayName) {
        getData().set(DisplayName + ".Prefix", (Object)null);
        SaveConfig();
    }

    public void resetSuffix(String DisplayName) {
        getData().set(DisplayName + ".Suffix", (Object)null);
        SaveConfig();
    }
    public String getSuffix(String DisplayName) {
        String Group = getGroup(DisplayName);
        String Suffix = "";
        if (getData().getString(DisplayName) == null) {
            Suffix = "none";
        } else if (getData().getString(DisplayName + ".Suffix") == null) {
            if (getGroup().getString(Group + ".Suffix").equals("none")) {
                Suffix = "";
            } else {
                Suffix = getGroup().getString(Group + ".Suffix");
            }
        } else {
            Suffix = getData().getString(DisplayName + ".Suffix");
        }

        return Suffix.replace("&", "§");
    }
    @Deprecated
    public String getSuffix(String Group, String DisplayName) {
        String Suffix = "";
        if (getData().getString(DisplayName) == null) {
            Suffix = "none";
        } else if (getData().getString(DisplayName + ".Suffix") == null) {
            if (getGroup().getString(Group + ".Suffix").equals("none")) {
                Suffix = "";
            } else {
                Suffix = getGroup().getString(Group + ".Suffix");
            }
        } else {
            Suffix = getData().getString(DisplayName + ".Suffix");
        }

        return Suffix.replace("&", "§");
    }

    public String getDate() {
        Date date = new Date();
        SimpleDateFormat Date = new SimpleDateFormat(getSettings().getString("Date-Time.Date"));
        return Date.format(date);
    }

    public String getTime(long Time) {
        Date date = new Date(Time);
        SimpleDateFormat Date = new SimpleDateFormat(getSettings().getString("Date-Time.DayTime"));
        return Date.format(date);
    }

    public String getTime() {
        Date date = new Date();
        SimpleDateFormat Date = new SimpleDateFormat(getSettings().getString("Date-Time.Time"));
        return Date.format(date);
    }

    public void setGroup(String DisplayName, String Group) {
        boolean is = false;
        Iterator var4 = ListGroup().iterator();

        while(var4.hasNext()) {
            String x = (String)var4.next();
            if (Group.equals(x)) {
                is = true;
            }
        }

        if (!is) {
            getGroup().set(Group + ".Chat", "");
        }

    }

    public List<String> ListGroup() {
        return getConfig().getStringList("List.Group");
    }
}

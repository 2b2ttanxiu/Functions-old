package org.functions.API;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.functions.API.AFK.Away;
import org.functions.Main.Functions;
import org.functions.Tools.ActionBar;
import org.functions.Tools.Status;
import org.functions.Tools.getPing;
import org.functions.net.minecraft.server.Handler;
import org.functions.net.minecraft.server.NetMinecraftServer;
import org.functions.money.Money;

public class PlayerNMS {
    private long Long = System.currentTimeMillis();
    public Functions nms = Functions.getMain();

    public PlayerNMS() {
    }
    public Away getaway(UUID uuid) {
        return new Away(uuid);
    }
    public String ping(Player Player) {
        return getPing.getPing(Player) + "";
    }
    public String TabListFooter(Player p) {
        Functions a = Functions.getMain();
        String Footer = "";
        if (!a.getTab().getString("Footer").equals("none") && !a.getTab().getString("Footer").equals("")) {
            for(int i = 0; i < a.getTab().getStringList("Footer").size(); ++i) {
                if (i == a.getTab().getStringList("Footer").size() - 1) {
                    Footer = Footer + (String)a.getTab().getStringList("Footer").get(i);
                } else {
                    Footer = Footer + (String)a.getTab().getStringList("Footer").get(i) + "\n";
                }
            }
        } else {
            Footer = "";
        }

        return this.replace(p, Footer);
    }
    public String TabListHeader(Player p) {
        Functions a = Functions.getMain();
        String Header = "";
        if (!a.getTab().getString("Header").equals("none") && !a.getTab().getString("Header").equals("")) {
            for(int i = 0; i < a.getTab().getStringList("Header").size(); ++i) {
                if (i == a.getTab().getStringList("Header").size() - 1) {
                    Header = Header + (String)a.getTab().getStringList("Header").get(i);
                } else {
                    Header = Header + (String)a.getTab().getStringList("Header").get(i) + "\n";
                }
            }
        } else {
            Header = "";
        }

        return this.replace(p, Header);
    }

    public void onChangePlayerHat(PlayerInventory inventory, ItemStack Hand, ItemStack Head) {
        inventory.setHelmet(Hand);
        inventory.setItemInMainHand(Head);
    }

    public String BooleanChange(String Name, boolean Boolean) {
        return Boolean ? "§a" + Name : "§c" + Name;
    }

    public String ActionBar(Player p) {
        Functions a = this.nms;
        String str = a.getSettings().getString("ActionBar");

        String x;
        List ls;
        int i;
        for(Iterator var4 = a.getSettings().getStringList("AnimationsEnable").iterator(); var4.hasNext(); str = str.replace("%animation:" + x + "%", (CharSequence)ls.get(i))) {
            x = (String)var4.next();
            ls = a.getSettings().getStringList("Animations." + x + ".Texts");
            i = a.getSettings().getInt("Animations." + x + ".Line");
        }

        String DisplayName = p.getName();
        a.getPrefix(a.getGroup(DisplayName), DisplayName);
        a.getSuffix(a.getGroup(DisplayName), DisplayName);
        String PlayerPing = getPing.getPing(p) + "";
        String PlayerHealth = (int)p.getHealth() + "";
        String PlayerLevel = p.getLevel() + "";
        PlayerNMS nmss = new PlayerNMS();
        Status status = new Status(p.getUniqueId(), nmss);
        return this.replace(p, str).replace("%status%", status.getStatus());
    }
    public String tps() {
        double[] tps = this.recentTPS();
        String[] tpsAvg = new String[tps.length];

        for(int i = 0; i < tps.length; ++i) {
            tpsAvg[i] = this.format(tps[i]);
        }
        return StringUtils.join(tpsAvg, ", ");
    }
    public String getTPS() {
        return tps().split(", ")[0];
    }

    public String format(double tps) {
        return (tps > 18.0D ? ChatColor.GREEN : (tps > 16.0D ? ChatColor.YELLOW : ChatColor.RED)).toString() + (tps > 21.0D ? "*" : "") + Math.min((double)Math.round(tps * 100.0D) / 100.0D, 20.0D);
    }

    public String[] runTime() {
        String s = new String();
        s = s + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576L + "|" + Runtime.getRuntime().totalMemory() / 1048576L + "|" + Runtime.getRuntime().maxMemory() / 1048576L;
        return s.split("|");
    }

    /**
     * find block;
     * if find block is air
     * run find block
     * if block no item and air and air block wait...
     * @return location;
     *
     *
     *
     *
     *
     *
     *
     * */
    public Location BlockPosition(World world,int x,int z) {
        return new Location(world,x,1,z);
    }
    public PlayerInventory getItem(Player Player) {
        return Player.getInventory();
    }

    public void sendActionBar(Player Player, String Message) {
        if ((new NetMinecraftServer()).toString().contains("1_16")) {
            V1_16ActionBar a = new V1_16ActionBar(UUID.randomUUID(), Message, Player);
            a.send();
        } else {
            ActionBar.ActionBar(Player, Message);
        }

    }

    public void sendTabList(Player Player, String Header, String Footer) {
        Handler handler = new Handler();
        handler.sendTabTitle(Player, Header, Footer);
    }

    public double[] recentTPS() {
        double[] d = new double[3];
        NetMinecraftServer nets = new NetMinecraftServer();

        try {
            Class MinecraftServerClass = Class.forName(nets.toAll() + ".MinecraftServer");
            Object obj = MinecraftServerClass.getMethod("getServer").invoke((Object)null);
            Field f = MinecraftServerClass.getDeclaredField("recentTps");
            return (double[])obj.getClass().getField("recentTps").get(obj);
        } catch (ClassNotFoundException var6) {
            var6.printStackTrace();
        } catch (NoSuchFieldException var7) {
            var7.printStackTrace();
        } catch (IllegalAccessException var8) {
            var8.printStackTrace();
        } catch (NoSuchMethodException var9) {
            var9.printStackTrace();
        } catch (InvocationTargetException var10) {
            var10.printStackTrace();
        }

        return new double[]{-1.0D, -2.0D, -3.0D};
    }

    public void setWorldSpawn(World World, int x, int y, int z) {
        World.setSpawnLocation(x, y, z);
    }

    public Death getDeath(UUID UUID) {
        return new Death(UUID);
    }

    public void sendTitle(Player Player, String Title) {
        Player.sendTitle(Title, "");
    }

    public void sendTitle(Player Player, String Title, int fadeIn, int stay, int fadeOut) {
        Player.sendTitle(Title, "", fadeIn, stay, fadeOut);
    }

    public void sendTitle(Player Player, String Title, String SubTitle) {
        Player.sendTitle(Title, SubTitle);
    }

    public void sendTitle(Player Player, String Title, String SubTitle, int fadeIn, int stay, int fadeOut) {
        Player.sendTitle(Title, SubTitle, fadeIn, stay, fadeOut);
    }

    public Location Location(World World, double X, double Y, double Z, float Yaw, float Pitch) {
        return new Location(World, X, Y, Z, Yaw, Pitch);
    }

    public Difficulty getDifficulty(World World) {
        return new Difficulty(World);
    }

    public Server getServer() {
        return Bukkit.getServer();
    }

    public List<World> getWorlds() {
        return this.getServer().getWorlds();
    }

    public World getWorld(String World) {
        return this.getServer().getWorld(World);
    }

    public Player Player(String Player) {
        return this.getServer().getPlayer(Player);
    }

    public Player getPlayer(boolean enabled, String Player) {
        return this.getServer().getPlayer(Player);
    }

    public Player getPlayer(Object Player) {
        return this.getServer().getPlayer(((Player)Player).getUniqueId());
    }

    public double getX(Player Player) {
        return Player.getLocation().getX();
    }

    public double getY(Player Player) {
        return Player.getLocation().getY();
    }

    public double getZ(Player Player) {
        return Player.getLocation().getZ();
    }

    public float getYaw(Player Player) {
        return Player.getLocation().getYaw();
    }

    public float getPitch(Player Player) {
        return Player.getLocation().getPitch();
    }

    public World getWorld(Player Player) {
        return Player.getLocation().getWorld();
    }

    public int getOnline() {
        try {
            return (new Handler()).getServer().getOnlinePlayers().size();
        } catch (Exception var2) {
            return 0;
        }
    }
    public String String(String String,String Default) {
        return nms.String(1,String,Default).replace("%space%","\n");
    }
    public void sendPermission(Object p) {
        ((Player)p).sendMessage(NotPermission());
    }
    public String NotPermission() {
        return nms.Permission();
    }
    public boolean hasPermission(String name,String Permission) {
        return nms.hasPermission(name,Permission);
    }
    public boolean permission(String name,String permission) {
        List <String> p = nms.getPermission().getStringList(name);
        if (!p.isEmpty()) {
            p = nms.getGroup().getStringList(nms.getGroup(name)+".Permissions");
            for (String x : p) {
                if (x.contains(permission)) {
                    return true;
                }
            }
        }
        for (String x : p) {
            if (x.contains(permission)) {
                return true;
            }
        }
        return false;
    }
    public Player getPlayer(UUID uuid) {
        return getServer().getPlayer(uuid);
    }
    public String Boolean(boolean Boolean) {
        return !Boolean ? "§c" + Boolean + "§r" : "§a" + Boolean + "§r";
    }

    public AutoMessage AutoMessage() {
        return new AutoMessage();
    }
    public String StringBoolean(boolean Boolean) {
        return !Boolean ? "§c" : "§a";
    }
    @SuppressWarnings("all")
    public String changeLocation(Location loc) {
        String x = Functions.getMain().getSettings().getString("List.Location");
        x = x.replace("%world%",loc.getWorld().getName());
        DecimalFormat df = new DecimalFormat(nms.getSettings().getString("List.FormatLocation"));
        x = x.replace("%x%",Double.parseDouble(df.format(loc.getX()))+"");
        x = x.replace("%y%",Double.parseDouble(df.format(loc.getY()))+"");
        x = x.replace("%z%",Double.parseDouble(df.format(loc.getZ()))+"");
        x = x.replace("%yaw%",Float.parseFloat(df.format(loc.getYaw()))+"");
        x = x.replace("%pitch%",Float.parseFloat(df.format(loc.getPitch()))+"");
        return x;
    }
    public String Location(Player Player) {
        String x = Functions.getMain().getSettings().getString("List.Location");
        x = x.replace("%world%", this.getWorld(Player).getName());
        x = x.replace("%x%", this.getX(Player) / 1000.0D + "");
        x = x.replace("%y%", this.getY(Player) / 1000.0D + "");
        x = x.replace("%z%", this.getZ(Player) / 1000.0D + "");
        x = x.replace("%yaw%", this.getYaw(Player) / 1000.0F + "");
        x = x.replace("%pitch%", this.getPitch(Player) / 1000.0F + "");
        return x;
    }
    public String ShowPrefix(Object Player) {
        return this.nms.getPrefix(this.nms.getGroup(Player.toString()), Player.toString()).equals("") ? "none" : this.nms.getPrefix(this.nms.getGroup(Player.toString()), Player.toString());
    }

    public String ShowSuffix(Object Player) {
        return this.nms.getSuffix(this.nms.getGroup(Player.toString()), Player.toString()).equals("") ? "none" : this.nms.getSuffix(this.nms.getGroup(Player.toString()), Player.toString());
    }

    public String toLocationString(String[] Location) {
        String x = Functions.getMain().getSettings().getString("List.Location");
        x = x.replace("%world%", this.getServer().getWorld(Location[0]).getName());
        x = x.replace("%x%", Location[1] + "");
        x = x.replace("%y%", Location[2] + "");
        x = x.replace("%z%", Location[3] + "");
        x = x.replace("%yaw%", Location[4] + "");
        x = x.replace("%pitch%", Location[5] + "");
        return x;
    }

    public int getOnlineOP() {
        int i = 0;
        Iterator var2 = this.getOnlinePlayers().iterator();

        while(var2.hasNext()) {
            Player p = (Player)var2.next();
            if (p.isOp()) {
                ++i;
            }
        }

        return i;
    }

    public Home house(UUID UUID) {
        return new Home(UUID);
    }

    public String toLocationString(Player Player) {
        String x = Functions.getMain().getSettings().getString("List.Location");
        x = x.replace("%world%", this.getWorld(Player).getName());
        x = x.replace("%x%", this.getX(Player) + "");
        x = x.replace("%y%", this.getY(Player) + "");
        x = x.replace("%z%", this.getZ(Player) + "");
        x = x.replace("%yaw%", this.getYaw(Player) + "");
        x = x.replace("%pitch%", this.getPitch(Player) + "");
        return x;
    }

    public OfflinePlayer[] getOffline() {
        return this.getServer().getOfflinePlayers();
    }

    public Collection<? extends Player> getOnlinePlayers() {
        return this.getServer().getOnlinePlayers();
    }
	public Money money(UUID uuid) {
        return new Money(uuid);
	}
	public DisplayName setDisplayName(UUID uuid) {
        return new DisplayName(uuid);
    }
	public PlayerDisplay getPlayerDisplay(UUID uuid) {
        return new PlayerDisplay(uuid);
    }
    public String replace(Player Player, String Message) {
        Functions a = Functions.getMain();
        String PlayerPrefix = a.getPrefix(a.getGroup(Player.getName()), Player.getName());
        String PlayerSuffix = a.getSuffix(a.getGroup(Player.getName()), Player.getName());
        String PlayerPing = getPing.getPing(Player) + "";
        String PlayerHealth = (int)Player.getHealth() + "";
        String PlayerLevel = Player.getLevel() + "";
        String CPS = a.getSettings().getString("List.CPS");
        CPS cps = new CPS();
        CPS = CPS.replace("%max%", cps.getMaxCPS(Player.getUniqueId()) + "").replace("%count%", cps.getCountCPS(Player.getUniqueId()) + "");

        String x;
        List ls;
        int i;
        for(Iterator var11 = a.getSettings().getStringList("AnimationsEnable").iterator(); var11.hasNext(); Message = Message.replace("%animation:" + x + "%", (CharSequence)ls.get(i))) {
            x = (String)var11.next();
            ls = a.getSettings().getStringList("Animations." + x + ".Texts");
            i = a.getSettings().getInt("Animations." + x + ".Line");
            Message = Message.replace("%animation:" + x + "%", (CharSequence)ls.get(i));
        }
        Status status = new Status(Player.getUniqueId(), this);
        return Message.replace("%money%",money(Player.getUniqueId()).getMoney()+"").replace("&", "§").replace("%player%", Player.getName()).replace("%suffix%", PlayerSuffix).replace("%prefix%", PlayerPrefix).replace("%level%", PlayerLevel).replace("%health%", PlayerHealth).replace("%ping%", PlayerPing).replace("%tps%", getTPS()).replace("%ip%", Player.getAddress().getAddress().getHostAddress()).replace("%servername%", a.getConfig().getString("ServerName", "Unknown Server")).replace("%date%", a.getDate()).replace("%time%", a.getTime()).replace("%online%", this.getOnline() + "").replace("%cps%", CPS).replace("%starttime%", this.nms.getStartTime()).replace("%status%", status.getStatus());
    }

    public void sendOPs(String Message) {
        Iterator var2 = this.getOnlinePlayers().iterator();

        while(var2.hasNext()) {
            Player p = (Player)var2.next();
            if (p.isOp()) {
                p.sendMessage(Message);
            }
        }

    }

    public Player getOP() {
        Iterator var1 = this.getOnlinePlayers().iterator();

        Player p;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            p = (Player)var1.next();
        } while(!p.isOp());

        return p;
    }
}
package org.functions.net.minecraft.server;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;
import org.functions.Main.Functions;
import org.functions.Tools.TPS;
import org.functions.net.minecraft.server.ServerVersion.Version;

public class Handler {
    private Object Location;

    public Handler() {
    }

    public PlayerNMS nms() {
        return new PlayerNMS();
    }

    public void setGameMode(Player Player, GameMode GameMode) {
        this.getServer().getPlayer(Player.getUniqueId()).setGameMode(GameMode);
    }

    public GameMode getGameMode(Player Player, GameMode GameMode) {
        return this.getServer().getPlayer(Player.getUniqueId()).getGameMode();
    }

    public void sendActionBar(Player Player, String Message) {
        this.nms().sendActionBar(Player, Message);
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

    public int getPing(Player Player) {
        return this.getPing(Player);
    }

    public String getTPS() {
        return TPS.TPS();
    }

    public UUID getPlayerUUID(Player Player) {
        return Player.getUniqueId();
    }

    public Server getServer() {
        return Bukkit.getServer();
    }

    public World getWorld(String World) {
        return this.getServer().getWorld(World);
    }

    public World getWorld(UUID World) {
        return this.getServer().getWorld(World);
    }

    public long getSeed(String World) {
        return this.getServer().getWorld(World).getSeed();
    }

    public long getSeed(UUID World) {
        return this.getServer().getWorld(World).getSeed();
    }

    public UUID getWorldUUID(String World) {
        return this.getServer().getWorld(World).getUID();
    }

    public Player getPlayer(String Player) {
        return this.getServer().getPlayer(Player);
    }

    public Player getPlayer(UUID Player) {
        return this.getServer().getPlayer(Player);
    }

    public Entity getEntity(UUID Entity) {
        return this.getServer().getEntity(Entity);
    }

    public boolean getOnlineMode() {
        return this.getServer().getOnlineMode();
    }

    public String getMotd() {
        return this.getServer().getMotd();
    }

    public void setPlayerListName(String Player, String Name) {
        this.getServer().getPlayer(Player).setPlayerListName(Name);
    }

    public void setPlayerCustomName(UUID Player, String Name) {
        this.getServer().getPlayer(Player).setCustomName(Name);
    }

    public void setPlayerListName(UUID Player, String Name) {
        this.getServer().getPlayer(Player).setDisplayName(Name);
    }

    public List<World> getWorlds() {
        return this.getServer().getWorlds();
    }

    public MCVersion getMCVersion() {
        return new MCVersion();
    }

    public static String colorMsg(String msg) {
        return colorMsg(msg, false);
    }

    public static String colorMsg(String msg, boolean usingNMSHex) {
        if (msg == null) {
            return "";
        } else {
            if (!usingNMSHex && Version.isCurrentEqualOrHigher(Version.v1_16_R1) && msg.contains("#")) {
                msg = matchColorRegex(msg);
            }

            return ChatColor.translateAlternateColorCodes('&', msg);
        }
    }

    public static String matchColorRegex(String s) {
        String regex = "#[a-fA-F0-9]{6}";
        Matcher matcher = Pattern.compile(regex).matcher(s);

        while(matcher.find()) {
            String group = matcher.group(0);

            try {
                s = s.replace(group, ChatColor.valueOf(group) + "");
            } catch (Exception var5) {
                System.out.println("[TabList] Bad hex color: " + group);
            }
        }

        return s;
    }

    public static String setSymbols(String s) {
        s = s.replace("<0>", "•");
        s = s.replace("<1>", "➤");
        s = s.replace("<2>", "™");
        s = s.replace("<3>", "↑");
        s = s.replace("<4>", "→");
        s = s.replace("<5>", "↓");
        s = s.replace("<6>", "∞");
        s = s.replace("<7>", "░");
        s = s.replace("<8>", "▲");
        s = s.replace("<9>", "▶");
        s = s.replace("<10>", "◀");
        s = s.replace("<11>", "●");
        s = s.replace("<12>", "★");
        s = s.replace("<13>", "☆");
        s = s.replace("<14>", "☐");
        s = s.replace("<15>", "☑");
        s = s.replace("<16>", "☠");
        s = s.replace("<17>", "☢");
        s = s.replace("<18>", "☣");
        s = s.replace("<19>", "☹");
        s = s.replace("<20>", "☺");
        s = s.replace("<21>", "✓");
        s = s.replace("<22>", "✔");
        s = s.replace("<23>", "✘");
        s = s.replace("<24>", "✚");
        s = s.replace("<25>", "℻");
        s = s.replace("<26>", "✠");
        s = s.replace("<27>", "✡");
        s = s.replace("<28>", "✦");
        s = s.replace("<29>", "✧");
        s = s.replace("<30>", "✩");
        s = s.replace("<31>", "✪");
        s = s.replace("<32>", "✮");
        s = s.replace("<33>", "✯");
        s = s.replace("<34>", "㋡");
        s = s.replace("<35>", "❝");
        s = s.replace("<36>", "❞");
        s = s.replace("<37>", "ツ");
        s = s.replace("<38>", "♩");
        s = s.replace("<39>", "♪");
        s = s.replace("<40>", "♫");
        s = s.replace("<41>", "♬");
        s = s.replace("<42>", "♭");
        s = s.replace("<43>", "♮");
        s = s.replace("<44>", "♯");
        s = s.replace("<45>", "¶");
        s = s.replace("<46>", "©");
        s = s.replace("<47>", "®");
        s = s.replace("<48>", "⏎");
        s = s.replace("<49>", "⇧");
        s = s.replace("<50>", "⇪");
        s = s.replace("<51>", "ᴴᴰ");
        s = s.replace("<52>", "☒");
        s = s.replace("<53>", "♠");
        s = s.replace("<54>", "♣");
        s = s.replace("<55>", "☻");
        s = s.replace("<56>", "▓");
        s = s.replace("<57>", "➾");
        s = s.replace("<58>", "➔");
        s = s.replace("<59>", "➳");
        s = s.replace("<60>", "➧");
        s = s.replace("<61>", "《");
        s = s.replace("<62>", "》");
        s = s.replace("<63>", "︾");
        s = s.replace("<64>", "︽");
        s = s.replace("<65>", "☃");
        s = s.replace("<66>", "¹");
        s = s.replace("<67>", "²");
        s = s.replace("<68>", "³");
        s = s.replace("<69>", "≈");
        s = s.replace("<70>", "℠");
        s = s.replace("<71>", "♥");
        s = s.replace("<72>", "✬");
        s = s.replace("<73>", "↔");
        s = s.replace("<74>", "«");
        s = s.replace("<75>", "»");
        s = s.replace("<76>", "☀");
        s = s.replace("<77>", "♦");
        s = s.replace("<78>", "₽");
        s = s.replace("<79>", "☎");
        s = s.replace("<80>", "☂");
        s = s.replace("<81>", "←");
        s = s.replace("<82>", "↖");
        s = s.replace("<83>", "↗");
        s = s.replace("<84>", "↘");
        s = s.replace("<85>", "↙");
        s = s.replace("<86>", "➲");
        s = s.replace("<87>", "✐");
        s = s.replace("<88>", "✎");
        s = s.replace("<89>", "✏");
        s = s.replace("<90>", "✆");
        s = s.replace("<91>", "◄");
        s = s.replace("<92>", "☼");
        s = s.replace("<93>", "►");
        s = s.replace("<94>", "↕");
        s = s.replace("<95>", "▼");
        s = s.replace("<96>", "①");
        s = s.replace("<97>", "②");
        s = s.replace("<98>", "③");
        s = s.replace("<99>", "④");
        s = s.replace("<100>", "⑤");
        s = s.replace("<101>", "⑥");
        s = s.replace("<102>", "⑦");
        s = s.replace("<103>", "⑧");
        s = s.replace("<104>", "⑨");
        s = s.replace("<105>", "⑩");
        s = s.replace("<106>", "⑪");
        s = s.replace("<107>", "⑫");
        s = s.replace("<108>", "⑬");
        s = s.replace("<109>", "⑭");
        s = s.replace("<110>", "⑮");
        s = s.replace("<111>", "⑯");
        s = s.replace("<112>", "⑰");
        s = s.replace("<113>", "⑱");
        s = s.replace("<114>", "⑲");
        s = s.replace("<115>", "⑳");
        s = s.replace("<116>", "♨");
        s = s.replace("<117>", "✑");
        s = s.replace("<118>", "✖");
        s = s.replace("<119>", "✰");
        s = s.replace("<120>", "✶");
        s = s.replace("<121>", "╗");
        s = s.replace("<122>", "╣");
        s = s.replace("<123>", "◙");
        s = s.replace("<124>", "○");
        s = s.replace("<125>", "╠");
        s = s.replace("<126>", "┤");
        s = s.replace("<127>", "║");
        s = s.replace("<128>", "╝");
        s = s.replace("<129>", "⌂");
        s = s.replace("<130>", "┐");
        s = s.replace("<131>", "❉");
        s = s.replace("<132>", "⌲");
        s = s.replace("<133>", "½");
        s = s.replace("<134>", "¼");
        s = s.replace("<135>", "¾");
        s = s.replace("<136>", "⅓");
        s = s.replace("<137>", "⅔");
        s = s.replace("<138>", "№");
        s = s.replace("<139>", "†");
        s = s.replace("<140>", "‡");
        s = s.replace("<141>", "µ");
        s = s.replace("<142>", "¢");
        s = s.replace("<143>", "£");
        s = s.replace("<144>", "∅");
        s = s.replace("<145>", "≤");
        s = s.replace("<146>", "≥");
        s = s.replace("<147>", "≠");
        s = s.replace("<148>", "∧");
        s = s.replace("<149>", "∨");
        s = s.replace("<150>", "∩");
        s = s.replace("<151>", "∪");
        s = s.replace("<152>", "∈");
        s = s.replace("<153>", "∀");
        s = s.replace("<154>", "∃");
        s = s.replace("<155>", "∄");
        s = s.replace("<156>", "∑");
        s = s.replace("<157>", "∏");
        s = s.replace("<158>", "↺");
        s = s.replace("<159>", "↻");
        s = s.replace("<160>", "Ω");
        return s;
    }

    public void sendTabTitle(Player player, String header, String footer) {
        try {
            Functions.getMain().getTab().load(new File(Functions.getMain().getDataFolder(), "Tab.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        if (player != null) {
            if (header == null) {
                header = "";
            }

            if (footer == null) {
                footer = "";
            }

            if (Version.isCurrentEqualOrLower(Version.v1_15_R2)) {
                header = colorMsg(header);
                footer = colorMsg(footer);
            }

            try {
                Class packetPlayOutPlayerListHeaderFooter = Utitls.getNMSClass("PacketPlayOutPlayerListHeaderFooter");

                try {
                    Object packet = packetPlayOutPlayerListHeaderFooter.getConstructor().newInstance();
                    Object tabHeader = Utitls.getAsIChatBaseComponent(header);
                    Object tabFooter = Utitls.getAsIChatBaseComponent(footer);
                    if (Version.isCurrentEqualOrHigher(Version.v1_13_R2)) {
                        Utitls.setField(packet, "header", tabHeader);
                        Utitls.setField(packet, "footer", tabFooter);
                    } else {
                        Utitls.setField(packet, "a", tabHeader);
                        Utitls.setField(packet, "b", tabFooter);
                    }

                    Utitls.sendPacket(player, packet);
                } catch (Exception var8) {
                    Constructor<?> titleConstructor = null;
                    if (Version.isCurrentEqualOrHigher(Version.v1_12_R1)) {
                        titleConstructor = packetPlayOutPlayerListHeaderFooter.getConstructor();
                    } else if (Version.isCurrentLower(Version.v1_12_R1)) {
                        titleConstructor = packetPlayOutPlayerListHeaderFooter.getConstructor(Utitls.getAsIChatBaseComponent(header).getClass());
                    }

                    if (titleConstructor != null) {
                        Utitls.setField(titleConstructor, "b", Utitls.getAsIChatBaseComponent(footer));
                        Utitls.sendPacket(player, titleConstructor);
                    }
                }
            } catch (Throwable var9) {
                var9.printStackTrace();
            }

        }
    }
}

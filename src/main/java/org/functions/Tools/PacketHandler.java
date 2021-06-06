package org.functions.Tools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.functions.Main.Functions;

public class PacketHandler {
    Functions plugin;
    private Class<?> packetPlayOutPlayerInfo;
    private Method getPlayerHandle;
    private Field getPlayerConnection;
    private Method sendPacket;

    public PacketHandler(Functions plugin) {
        try {
            this.plugin = plugin;
            this.packetPlayOutPlayerInfo = this.getMCClass("PacketPlayOutPlayerInfo");
            this.getPlayerHandle = this.getCraftClass("entity.CraftPlayer").getMethod("getHandle");
            this.getPlayerConnection = this.getMCClass("EntityPlayer").getDeclaredField("playerConnection");
            this.sendPacket = this.getMCClass("PlayerConnection").getMethod("sendPacket", this.getMCClass("Packet"));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public Object createTablistPacket(String text, boolean cancel, int ping) {
        try {
            Object packet = this.packetPlayOutPlayerInfo.newInstance();
            Field a = this.packetPlayOutPlayerInfo.getDeclaredField("a");
            a.setAccessible(true);
            a.set(packet, text);
            Field b = this.packetPlayOutPlayerInfo.getDeclaredField("b");
            b.setAccessible(true);
            b.set(packet, cancel);
            Field c = this.packetPlayOutPlayerInfo.getDeclaredField("c");
            c.setAccessible(true);
            c.set(packet, ping);
            return packet;
        } catch (Exception var8) {
            return null;
        }
    }

    public Object createTablistPacket(String text, boolean cancel) {
        return this.createTablistPacket(text, cancel, 0);
    }

    public void sendPackets(Player player, List<Object> packets) {
        try {
            Iterator var4 = packets.iterator();

            while(var4.hasNext()) {
                Object packet = var4.next();
                this.sendPacket.invoke(this.getPlayerConnection.get(this.getPlayerHandle.invoke(player)), packet);
            }
        } catch (Exception var5) {
        }

    }

    public void sendPackets(List<Object> packets) {
        try {
            Collection var5;
            int var4 = (var5 = Bukkit.getOnlinePlayers()).size();
            int var3 = 0;

            while(var3 < var4) {
                Iterator var7 = packets.iterator();

                label28:
                while(true) {
                    if (var7.hasNext()) {
                        Object packet = var7.next();
                        Iterator var8 = var5.iterator();

                        while(true) {
                            if (!var7.hasNext()) {
                                continue label28;
                            }

                            Player player = (Player)var7.next();
                            this.sendPacket.invoke(this.getPlayerConnection.get(this.getPlayerHandle.invoke(player)), packet);
                        }
                    }

                    ++var3;
                    break;
                }
            }
        } catch (Exception var9) {
        }

    }

    public void send() {
    }

    private Class<?> getMCClass(String name) throws ClassNotFoundException {
        String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + ".";
        String className = "net.minecraft.server." + version + name;
        return Class.forName(className);
    }

    private Class<?> getCraftClass(String name) throws ClassNotFoundException {
        String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + ".";
        String className = "org.bukkit.craftbukkit." + version + name;
        return Class.forName(className);
    }
}
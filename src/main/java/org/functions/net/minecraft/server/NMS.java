package org.functions.net.minecraft.server;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.functions.Tools.NMSv;

public class NMS {
    private static Class<?> craftPlayer;
    private static Class<?> entityPlayer;
    private static Method craftPlayer$getHandle;

    public static boolean toBoolean() {
        return !NMSv.v().contains("v1_8") || !NMSv.v().contains("v1_9") || !NMSv.v().contains("v1_10") || !NMSv.v().contains("v1_11") || !NMSv.v().contains("v1_12");
    }

    public NMS(Class<?> craftPlayer, Class<?> entityPlayer) {
        NMS.craftPlayer = craftPlayer;
        NMS.entityPlayer = entityPlayer;
    }

    public static String getVersion() {
        String name = Bukkit.getServer().getClass().getPackage().getName();
        return name.substring(name.lastIndexOf(46) + 1) + ".";
    }

    private static Class<?> getNMSClass(String className) {
        String fullName = "net.minecraft.server." + getVersion() + className;
        Class clazz = null;

        try {
            clazz = Class.forName(fullName);
        } catch (ClassNotFoundException var4) {
            System.err.println("[sTablistAPI] Can't find the Class '" + fullName + "'!");
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return clazz;
    }

    private static Class<?> getOBCClass(String className) {
        String fullName = "org.bukkit.craftbukkit." + getVersion() + className;
        Class clazz = null;

        try {
            clazz = Class.forName(fullName);
        } catch (ClassNotFoundException var4) {
            System.err.println("[sTablistAPI] Can't find the Class '" + fullName + "'!");
        }

        return clazz;
    }

    private static Object getNMSPlayer(Player p) {
        try {
            return craftPlayer$getHandle.invoke(p);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    private static Field getField(Field f) {
        f.setAccessible(true);
        return f;
    }

    public static int getPing(Player player) {
        int pingInt = 0;
        Object nmsPlayer = getNMSPlayer(player);

        try {
            Field ping = getField(entityPlayer.getField("ping"));
            pingInt = ping.getInt(nmsPlayer);
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var4) {
            var4.printStackTrace();
        }

        return pingInt;
    }
}

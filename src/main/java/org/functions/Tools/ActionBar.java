package org.functions.Tools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ActionBar {
    public ActionBar() {
    }

    public static void ActionBar(Player Player, String Message) {
        String nmsver = Bukkit.getServer().getClass().getPackage().getName();
        nmsver = nmsver.substring(nmsver.lastIndexOf(".") + 1);
        boolean useOldMethods = false;
        if (nmsver.equalsIgnoreCase("v1_8_R1") || nmsver.startsWith("v1_7_")) {
            useOldMethods = true;
        }

        try {
            Class<?> craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + nmsver + ".entity.CraftPlayer");
            Object craftPlayer = craftPlayerClass.cast(Player);
            Class<?> packetPlayOutChatClass = Class.forName("net.minecraft.server." + nmsver + ".PacketPlayOutChat");
            Class<?> packetClass = Class.forName("net.minecraft.server." + nmsver + ".Packet");
            Object packet;
            Class chatComponentTextClass;
            Class iChatBaseComponentClass;
            Object chatCompontentText;
            Method craftPlayerHandleMethod;
            if (useOldMethods) {
                chatComponentTextClass = Class.forName("net.minecraft.server." + nmsver + ".ChatSerializer");
                iChatBaseComponentClass = Class.forName("net.minecraft.server." + nmsver + ".IChatBaseComponent");
                craftPlayerHandleMethod = chatComponentTextClass.getDeclaredMethod("a", String.class);
                chatCompontentText = iChatBaseComponentClass.cast(craftPlayerHandleMethod.invoke(chatComponentTextClass, "{\"text\": \"" + Message + "\"}"));
                packet = packetPlayOutChatClass.getConstructor(iChatBaseComponentClass, Byte.TYPE).newInstance(chatCompontentText, 2);
            } else {
                chatComponentTextClass = Class.forName("net.minecraft.server." + nmsver + ".ChatComponentText");
                iChatBaseComponentClass = Class.forName("net.minecraft.server." + nmsver + ".IChatBaseComponent");

                try {
                    Class<?> chatMessageTypeClass = Class.forName("net.minecraft.server." + nmsver + ".ChatMessageType");
                    Object[] chatMessageTypes = chatMessageTypeClass.getEnumConstants();
                    Object chatMessageType = null;
                    Object[] var13 = chatMessageTypes;
                    int var14 = chatMessageTypes.length;

                    for(int var15 = 0; var15 < var14; ++var15) {
                        Object obj = var13[var15];
                        if (obj.toString().equals("GAME_INFO")) {
                            chatMessageType = obj;
                        }
                    }

                    chatCompontentText = chatComponentTextClass.getConstructor(String.class).newInstance(Message);
                    packet = packetPlayOutChatClass.getConstructor(iChatBaseComponentClass, chatMessageTypeClass).newInstance(chatCompontentText, chatMessageType);
                } catch (ClassNotFoundException var19) {
                    chatCompontentText = chatComponentTextClass.getConstructor(String.class).newInstance(Message);
                    packet = packetPlayOutChatClass.getConstructor(iChatBaseComponentClass, Byte.TYPE).newInstance(chatCompontentText, 2);
                }
            }

            craftPlayerHandleMethod = craftPlayerClass.getDeclaredMethod("getHandle");
            Object craftPlayerHandle = craftPlayerHandleMethod.invoke(craftPlayer);
            Field playerConnectionField = craftPlayerHandle.getClass().getDeclaredField("playerConnection");
            chatCompontentText = playerConnectionField.get(craftPlayerHandle);
            Method sendPacketMethod = chatCompontentText.getClass().getDeclaredMethod("sendPacket", packetClass);
            sendPacketMethod.invoke(chatCompontentText, packet);
        } catch (Exception var20) {
            var20.printStackTrace();
        }

    }

    public static void sendActionBar(Player Player, String Message) {
        ActionBar(Player, Message);
    }
}
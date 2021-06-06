package org.functions.API;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ActionBar {
    public Object packet;
    public boolean useOldMethods = false;

    public ActionBar(String Message) {
        String nms = Bukkit.getServer().getClass().getPackage().getName();
        nms = nms.substring(nms.lastIndexOf(".") + 1);
        if (nms.equalsIgnoreCase("v1_8_R1") || nms.startsWith("v1_7_")) {
            this.useOldMethods = true;
        }

        try {
            Class<?> packetPlayOutChatClass = Class.forName("net.minecraft.server." + nms + ".PacketPlayOutChat");
            Class chatComponentTextClass;
            Class iChatBaseComponentClass;
            Object chatCompontentText;
            if (this.useOldMethods) {
                chatComponentTextClass = Class.forName("net.minecraft.server." + nms + ".ChatSerializer");
                iChatBaseComponentClass = Class.forName("net.minecraft.server." + nms + ".IChatBaseComponent");
                Method m3 = chatComponentTextClass.getDeclaredMethod("a", String.class);
                chatCompontentText = iChatBaseComponentClass.cast(m3.invoke(chatComponentTextClass, "{\"text\": \"" + Message + "\"}"));
                this.packet = packetPlayOutChatClass.getConstructor(iChatBaseComponentClass, Byte.TYPE).newInstance(chatCompontentText, 2);
            } else {
                chatComponentTextClass = Class.forName("net.minecraft.server." + nms + ".ChatComponentText");
                iChatBaseComponentClass = Class.forName("net.minecraft.server." + nms + ".IChatBaseComponent");

                try {
                    Class<?> chatMessageTypeClass = Class.forName("net.minecraft.server." + nms + ".ChatMessageType");
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
                    this.packet = packetPlayOutChatClass.getConstructor(iChatBaseComponentClass, chatMessageTypeClass).newInstance(chatCompontentText, chatMessageType);
                } catch (ClassNotFoundException var14) {
                    chatCompontentText = chatComponentTextClass.getConstructor(String.class).newInstance(Message);
                    this.packet = packetPlayOutChatClass.getConstructor(iChatBaseComponentClass, Byte.TYPE).newInstance(chatCompontentText, 2);
                }
            }
        } catch (NoSuchMethodException | ClassNotFoundException var15) {
            var15.printStackTrace();
        } catch (IllegalAccessException var16) {
            var16.printStackTrace();
        } catch (InstantiationException var17) {
            var17.printStackTrace();
        } catch (InvocationTargetException var18) {
            var18.printStackTrace();
        }

    }

    public void sendActionBar(Player Player, String ActionBar) {
        String nms = Bukkit.getServer().getClass().getPackage().getName();
        nms = nms.substring(nms.lastIndexOf(".") + 1);
        if (nms.equalsIgnoreCase("v1_8_R1") || nms.startsWith("v1_7_")) {
            this.useOldMethods = true;
        }

        try {
            Class<?> craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + nms + ".entity.CraftPlayer");
            Object craftPlayer = craftPlayerClass.cast(Player);
            Class<?> packetClass = Class.forName("net.minecraft.server." + nms + ".Packet");
            Method craftPlayerHandleMethod = craftPlayerClass.getDeclaredMethod("getHandle");
            Object craftPlayerHandle = craftPlayerHandleMethod.invoke(craftPlayer);
            Field playerConnectionField = craftPlayerHandle.getClass().getDeclaredField("playerConnection");
            Object chatCompontentText = playerConnectionField.get(craftPlayerHandle);
            Method sendPacketMethod = chatCompontentText.getClass().getDeclaredMethod("sendPacket", packetClass);
            sendPacketMethod.invoke(chatCompontentText, this.packet);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException | ClassNotFoundException var12) {
            var12.printStackTrace();
        }

    }
}
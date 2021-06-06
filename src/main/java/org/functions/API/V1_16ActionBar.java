package org.functions.API;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class V1_16ActionBar {
    UUID uuid;
    public Object packet;
    String Message;
    Player p;

    public V1_16ActionBar(UUID uuid, String Text, Player player) {
        this.uuid = uuid;
        this.Message = Text;
        this.p = player;
    }

    public void send() {
        String nms = Bukkit.getServer().getClass().getPackage().getName();
        nms = nms.substring(nms.lastIndexOf(".") + 1);

        try {
            Class<?> craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + nms + ".entity.CraftPlayer");
            Object craftPlayer = craftPlayerClass.cast(this.p);
            Class<?> packetClass = Class.forName("net.minecraft.server." + nms + ".Packet");
            Class<?> packetPlayOutChatClass = Class.forName("net.minecraft.server." + nms + ".PacketPlayOutChat");
            Class chatComponentTextClass = Class.forName("net.minecraft.server." + nms + ".ChatComponentText");
            Class iChatBaseComponentClass = Class.forName("net.minecraft.server." + nms + ".IChatBaseComponent");

            Object chatCompontentText;
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

                chatCompontentText = chatComponentTextClass.getConstructor(String.class).newInstance(this.Message);
                this.packet = packetPlayOutChatClass.getConstructor(iChatBaseComponentClass, chatMessageTypeClass, this.uuid.getClass()).newInstance(chatCompontentText, chatMessageType, this.uuid);
            } catch (ClassNotFoundException var16) {
                chatCompontentText = chatComponentTextClass.getConstructor(String.class).newInstance(this.Message);
                this.packet = packetPlayOutChatClass.getConstructor(iChatBaseComponentClass, Byte.TYPE, this.uuid.getClass()).newInstance(chatCompontentText, 2, this.uuid);
            }

            Method craftPlayerHandleMethod = craftPlayerClass.getDeclaredMethod("getHandle");
            Object craftPlayerHandle = craftPlayerHandleMethod.invoke(craftPlayer);
            Field playerConnectionField = craftPlayerHandle.getClass().getDeclaredField("playerConnection");
            chatCompontentText = playerConnectionField.get(craftPlayerHandle);
            Method sendPacketMethod = chatCompontentText.getClass().getDeclaredMethod("sendPacket", packetClass);
            sendPacketMethod.invoke(chatCompontentText, this.packet);
        } catch (NoSuchMethodException | ClassNotFoundException var17) {
            var17.printStackTrace();
        } catch (IllegalAccessException var18) {
            var18.printStackTrace();
        } catch (InstantiationException var19) {
            var19.printStackTrace();
        } catch (InvocationTargetException var20) {
            var20.printStackTrace();
        } catch (NoSuchFieldException var21) {
            var21.printStackTrace();
        }

    }
}
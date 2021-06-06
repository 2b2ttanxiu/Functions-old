package org.functions.net.minecraft.server;

import org.bukkit.Bukkit;

public class NetMinecraftServer {
    public NetMinecraftServer() {
    }

    public String toString() {
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    }

    public String[] toClass() {
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.");
    }

    public String toAll() {
        return "net.minecraft.server." + this.toString();
    }
}

package org.functions.net.minecraft.server;

public class ServerJar {
    public ServerJar() {
    }

    public String toString() {
        String toString = "None";
        MCVersion mcVersion = new MCVersion();
        String v = mcVersion.getVersion();
        if (v.contains("Paper")) {
            toString = "Paper";
        }

        if (v.contains("Spigot")) {
            toString = "Spigot";
        }

        if (v.contains("PaperSpigot")) {
            toString = "PaperSpigot";
        }

        if (v.contains("Bukkit")) {
            toString = "Bukkit";
        }

        if (v.contains("PaperBukkit")) {
            toString = "PaperBukkit";
        }

        return toString;
    }
}

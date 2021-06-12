//package org.functions.bungee.Main;
//
//import net.md_5.bungee.api.chat.BaseComponent;
//import net.md_5.bungee.api.chat.ComponentBuilder;
//import net.md_5.bungee.api.chat.TextComponent;
//import net.md_5.bungee.api.plugin.Plugin;
//import net.md_5.bungee.config.Configuration;
//import net.md_5.bungee.config.ConfigurationProvider;
//import net.md_5.bungee.config.YamlConfiguration;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//
//public class Functions extends Plugin {
//    Configuration t;
//    static Functions s;
//    File dir = getDataFolder();
//    File title = new File(dir,"ServerTitle.yml");
//    File c = new File(dir,"Configuration.yml");
//    Configuration config;
//    @Override
//    public void onLoad() {
//        saveDefaultConfig();
//        saveDefaultTitle();
//    }
//    public void onEnable() {
//        sendConsole(true,"Welcome to uses " + ifServer() + " plugin.");
//    }
//    public Configuration getConfig() {
//        return config;
//    }
//    public Configuration getTitle() {
//        return t;
//    }
//    @Override
//    public void onDisable() {
//    }
//    public String ifServer() {
//        if (getProxy().getVersion().contains("BungeeCord")) {
//            return "BungeeCord";
//        } else {
//            return "Waterfall";
//        }
//    }
//    public void saveTitle() {
//        try {
//            ConfigurationProvider.getProvider(YamlConfiguration.class).save(t, title);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void reloadTitle() {
//        try {
//            t = ConfigurationProvider.getProvider(YamlConfiguration.class).load(title);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void saveDefaultTitle() {
//        if (!dir.exists()) dir.mkdir();
//        if (!title.exists()) {
//            try (InputStream in = getResourceAsStream("Configuration.yml")){
//                Files.copy(in,title.toPath());
//                t = ConfigurationProvider.getProvider(YamlConfiguration.class).load(title);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public void saveConfig() {
//        try {
//            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, c);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void reloadConfig() {
//        try {
//            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(c);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void saveDefaultConfig() {
//        if (!dir.exists()) dir.mkdir();
//        if (!c.exists()) {
//            try (InputStream in = getResourceAsStream("Configuration.yml")){
//                Files.copy(in,c.toPath());
//                config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(c);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public String parseString(String parse) {
//        return parse.replace("&","§");
//    }
//    public String Prefix() {
//        return parseString(config.getString("PluginPrefix"));
//    }
//    public void sendConsole(boolean Prefix,String message) {
//        message = parseString(message);
//        if (Prefix) {
//            message = Prefix() + message;
//        }
//        TextComponent text = new TextComponent(new ComponentBuilder(message).create());
//        getProxy().getConsole().sendMessage(text);
//    }
//    public static Functions getMain() {
//        return s;
//    }
//}
//
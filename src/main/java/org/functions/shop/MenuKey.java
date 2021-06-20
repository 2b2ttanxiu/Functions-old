package org.functions.shop;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.functions.Main.Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MenuKey {
    FileConfiguration config;
    public MenuKey(FileConfiguration fileConfiguration) {
        config = fileConfiguration;
    }
    public List<String> toStringList() {
        List<String> ls = new ArrayList<>();
        Set<String> key = config.getConfigurationSection("Menus").getKeys(false);
        if (!key.isEmpty()) {
            for (String s : key){
                ls.add(s);
            }
        }
        return ls;
    }
    public boolean toString(String a) {
        Set<String> key = config.getConfigurationSection("Menus").getKeys(false);
        if (!key.isEmpty()) {
            // a = Menu;
            for (String s : key) {
                if (s.equalsIgnoreCase(a)) {
                    return true;
                }
            }
        }
        return false;
    }
}

package org.functions.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.functions.API.PlayerNMS;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Menu {
    String menu;
    Player p;
    PlayerNMS nms = new PlayerNMS();
    MenuKey key;
    String path = "Menus.";
    FileConfiguration config;
    public Menu(Player player, String menu) {
        this.menu = menu;
        p = player;
        config = nms.nms.getMenu();
        key = new MenuKey(config);
    }
    public String getMenuPath() {
        return path + menu;
    }
    public List<String> getPath() {
        List<String> ls = new ArrayList<>();
        Set<String> key;
        key = config.getConfigurationSection("Menus."+menu+".Items").getKeys(false);
        if (!key.isEmpty()) {
            for (String s : key) {
                ls.add(s);
            }
        }
        return ls;
    }
    public void openMenu() {
        // Menus.emp.M
        path = path + menu + ".";
        if (key.toString(menu)) {
            int size = config.getInt(path + "size");
            if (size==0) {
                size = 9;
            }
            String title = config.getString(path+"title");
            if (title==null) {
                title = "Menu";
            }
            Inventory inventory = Bukkit.createInventory(null, size, title);
            for (String s : getPath()) {
                path = path + "Items." + s + ".";
                ItemStack item = new ItemStack(Material.getMaterial(config.getString(path + "Material","STONE"))/**, config.getInt(path + ".Amount", 1)*/);
                ItemMeta itemMeta = item.getItemMeta();
                List<String> lore = config.getStringList(path + "Lore");
                String DisplayName = config.getString(path + "DisplayName");
                int slot = config.getInt(path + "slot");
                if (lore.size()!=0) {
                    itemMeta.setLore(lore);
                }

                if (DisplayName != null) {
                    itemMeta.setDisplayName(DisplayName);
                }
                item.setItemMeta(itemMeta);
                inventory.setItem(slot,item);
            }
            p.openInventory(inventory);
        }
    }
    public List<String> getOpenMenu() {
        return config.getStringList(path + menu + ".openCommand");
    }
    public void closeMenu() {
        p.closeInventory();
    }
}

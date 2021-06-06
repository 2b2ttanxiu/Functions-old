package org.functions.API;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Gui {
    Configuration g;
    int size;
    String title;
    Pattern match = Pattern.compile("&(#[a-f0-9]{6})");
    Inventory inv;
    public Gui(Configuration configuration) {
        g = configuration;
        size = configuration.getInt("Size");
        title = configuration.getString("Name");
    }
    public void createInventory() {
        inv = Bukkit.createInventory(null,size);
    }
    public void addItem(String name) {
        String path = new String("Item." + match + "");
        @SuppressWarnings("all")
        ItemStack is = new ItemStack(Material.getMaterial(g.getString(path + ".Material")));
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(g.getString(path + ".DisplayName"));
        is.setAmount(g.getInt(path + ".Amount"));
        List<String> ls = new ArrayList<>();
        ls = g.getStringList(path + ".Lore");
        im.setLore(ls);
    }
}

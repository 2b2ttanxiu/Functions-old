package org.functions.Commands.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerManger;
import org.functions.API.PlayerNMS;

public class CommandInventory implements CommandExecutor {
    PlayerNMS nms = new PlayerManger();

    public CommandInventory() {
    }

    public static void run(JavaPlugin javaPlugin) {
        javaPlugin.getCommand("inventory").setExecutor(new CommandInventory());
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Inventory inv;
        Player p;
        if (args[0].equalsIgnoreCase("anvil")) {
            if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.inventory.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.inventory.anvil")) {
                sender.sendMessage(this.nms.nms.Permission());
                return true;
            } else {
                inv = Bukkit.createInventory((InventoryHolder)null, InventoryType.ANVIL, this.nms.nms.String(0, "AnvilGui", "Anvil Gui"));
                p = this.nms.getPlayer(sender);
                p.sendMessage(this.nms.nms.String(1, "OpenAnvil", "Open the \"" + this.nms.nms.String(0, "AnvilGui", "Anvil Gui") + "\""));
                p.openInventory(inv);
                return true;
            }
        } else if (args[0].equalsIgnoreCase("Enchanting")) {
            if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.inventory.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.inventory.Enchanting")) {
                sender.sendMessage(this.nms.nms.Permission());
                return true;
            } else {
                inv = Bukkit.createInventory((InventoryHolder)null, InventoryType.ENCHANTING, this.nms.nms.String(0, "EnchantingGui", "Enchanting Gui"));
                p = this.nms.getPlayer(sender);
                p.sendMessage(this.nms.nms.String(1, "OpenEnchanting", "Open the \"" + this.nms.nms.String(0, "EnchantingGui", "Enchanting Gui") + "\""));
                p.openInventory(inv);
                return true;
            }
        } else if (args[0].equalsIgnoreCase("Creative")) {
            if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.inventory.*") && !this.nms.nms.hasPermission(sender.getName(), "functions.command.inventory.Creative")) {
                sender.sendMessage(this.nms.nms.Permission());
                return true;
            } else {
                inv = Bukkit.createInventory((InventoryHolder)null, InventoryType.CREATIVE, this.nms.nms.String(0, "CreativeGui", "Creative Gui"));
                p = this.nms.getPlayer(sender);
                p.sendMessage(this.nms.nms.String(1, "OpenCreative", "Open the \"" + this.nms.nms.String(0, "CreativeGui", "Creative Gui") + "\""));
                p.openInventory(inv);
                return true;
            }
        } else {
            return true;
        }
    }
}
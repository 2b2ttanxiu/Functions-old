package org.functions.Commands.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerNMS;

public class CommandDestroyItem implements CommandExecutor {
    PlayerNMS nms = new PlayerNMS();

    public CommandDestroyItem() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("destroyItem")) {
            if (!this.nms.nms.hasPermission(sender.getName(), "functions.command.destroyitem.others")) {
                sender.sendMessage(this.nms.nms.Permission());
                return true;
            }

            Inventory inv = Bukkit.createInventory((InventoryHolder)null, 36, this.nms.nms.String(0, "DestroyItemGUI", "Closed clear gui in the item."));
            Player p = this.nms.getPlayer(sender);
            p.openInventory(inv);
            p.sendMessage(this.nms.nms.String(1, "DestroyItem", "Put up %gui%,Cleared you item.").replace("%gui%", this.nms.nms.String(0, "DestroyItemGUIName", "\"Destroy Item GUI\"")));
        }

        return true;
    }

    public static void run(JavaPlugin JavaPlugin) {
        JavaPlugin.getCommand("destroyItem").setExecutor(new CommandDestroyItem());
    }
}
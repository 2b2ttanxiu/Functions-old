package org.functions.Commands.Permissions;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.functions.API.PlayerNMS;
import org.functions.Commands.Permissions.CommandKit;
import org.functions.Main.Functions;

public class CommandKit implements CommandExecutor {
    private Functions a = Functions.getMain();
    private PlayerNMS nms = new PlayerNMS();

    public CommandKit() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("kit") && sender instanceof Player) {
            Player p = this.nms.getPlayer(sender);
            Inventory inv = this.nms.getServer().createInventory((InventoryHolder)null, 54);
            ItemStack is = new ItemStack(Material.ANVIL, 1);
            ItemMeta meta = is.getItemMeta();
            meta.setDisplayName("FUCK YOUR MOTHER AND FATHER!");
            is.setItemMeta(meta);
            p.openInventory(inv);
            sender.sendMessage("FUCK YOU!");
        }

        return true;
    }
}
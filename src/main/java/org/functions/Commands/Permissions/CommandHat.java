package org.functions.Commands.Permissions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.API.PlayerNMS;

public class CommandHat implements CommandExecutor {
    private PlayerNMS nms = new PlayerNMS();

    public CommandHat() {
    }

    public static void run(JavaPlugin j) {
        j.getCommand("hat").setExecutor(new CommandHat());
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("hat") && sender instanceof Player) {
            Player p = this.nms.getPlayer(sender);
            ItemStack hand = p.getInventory().getItemInMainHand();
            ItemStack head = p.getInventory().getHelmet();
            this.nms.onChangePlayerHat(p.getInventory(), hand, head);
            p.updateInventory();
            sender.sendMessage(this.nms.nms.String(1, "ChangeHat", "The helmet set to hand,hand set to helmet."));
            return true;
        } else {
            return true;
        }
    }
}
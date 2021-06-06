package org.functions.Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.functions.Listeners.BlackIfWhiteListener;
import org.functions.Listeners.ChatListener;
import org.functions.Listeners.CheckPlayerBanned_and_modeListener;
import org.functions.Listeners.ClickListener;
import org.functions.Listeners.CommandListener;
import org.functions.Listeners.DeathListener;
import org.functions.Listeners.DispenseOn;
import org.functions.Listeners.GameRuleListener;
import org.functions.Listeners.InventoryClose;
import org.functions.Listeners.JoinListener;
import org.functions.Listeners.QuitListener;
import org.functions.Listeners.StatusListener;
import org.functions.Listeners.TitleListener;

public class RegisterListener {
    JavaPlugin p = null;

    public RegisterListener(JavaPlugin main) {
        this.p = main;
    }

    public void run() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new InventoryClose(), this.p);
        pm.registerEvents(new ChatListener(), this.p);
        pm.registerEvents(new JoinListener(), this.p);
        pm.registerEvents(new QuitListener(), this.p);
        pm.registerEvents(new TitleListener(), this.p);
        pm.registerEvents(new CheckPlayerBanned_and_modeListener(), this.p);
        pm.registerEvents(new CommandListener(), this.p);
        pm.registerEvents(new BlackIfWhiteListener(), this.p);
        pm.registerEvents(new DeathListener(), this.p);
        pm.registerEvents(new DispenseOn(), this.p);
        pm.registerEvents(new StatusListener(), this.p);
        pm.registerEvents(new ClickListener(), this.p);
        pm.registerEvents(new GameRuleListener(), this.p);
    }
}

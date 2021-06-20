package org.functions.Listeners;

import org.bukkit.plugin.PluginManager;
import org.functions.API.AFK.Away;
import org.functions.Listeners.Away.AwayListener;
import org.functions.Listeners.Shop.MenuListener;
import org.functions.Main.Functions;

public class RegisterListener {
    public RegisterListener() {
    }

    public void register() {
        PluginManager pm = Functions.getMain().getServer().getPluginManager();
        pm.registerEvents(new GameRuleListener(), Functions.getMain());
        pm.registerEvents(new AwayListener(),Functions.getMain());
        pm.registerEvents(new MenuListener(),Functions.getMain());
    }
}

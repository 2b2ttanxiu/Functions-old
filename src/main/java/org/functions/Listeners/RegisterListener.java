package org.functions.Listeners;

import org.bukkit.plugin.PluginManager;
import org.functions.Main.Functions;

public class RegisterListener {
    public RegisterListener() {
    }

    public void register() {
        PluginManager pm = Functions.getMain().getServer().getPluginManager();
        pm.registerEvents(new GameRuleListener(), Functions.getMain());
    }
}

package com.hodakazy.staffcounter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffCounter extends JavaPlugin {

    @Override
    public void onEnable() {
        
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            
            new StaffExpansion(this).register();
            getLogger().info("StaffCounter enabled! Hooked into PlaceholderAPI.");
        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin requires it to function.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffCounter disabled.");
    }
}

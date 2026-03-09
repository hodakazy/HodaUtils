package com.hodakazy.staffcounter;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StaffExpansion extends PlaceholderExpansion {

    private final StaffCounter plugin;

    public StaffExpansion(StaffCounter plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getAuthor() {
        return "Hodakazy"; 
    }

    @Override
    public @NotNull String getIdentifier() {
        return "total";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true; 
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        if (params.equalsIgnoreCase("staff_online")) {
            int staffCount = 0;

            for (Player p : Bukkit.getOnlinePlayers()) {
                
                if (p.hasPermission("hodakazy.staff")) {
                    
                    
                    boolean isVanished = p.hasMetadata("vanished") 
                            && !p.getMetadata("vanished").isEmpty() 
                            && p.getMetadata("vanished").get(0).asBoolean();

                    
                    if (!isVanished) {
                        staffCount++;
                    }
                }
            }
            
            return String.valueOf(staffCount);
        }

        return null; 
    }
}

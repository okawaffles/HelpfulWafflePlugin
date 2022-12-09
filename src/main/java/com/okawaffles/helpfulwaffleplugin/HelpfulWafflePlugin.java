package com.okawaffles.helpfulwaffleplugin;

import com.okawaffles.helpfulwaffleplugin.commands.coordinates;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelpfulWafflePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("HelpfulWafflePlugin Loaded!");
        this.getCommand("coords").setExecutor(new coordinates());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("HelpfulWafflePlugin Unloaded!");
    }
}

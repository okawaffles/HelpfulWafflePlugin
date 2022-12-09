package com.okawaffles.helpfulwaffleplugin;

// commands
import com.okawaffles.helpfulwaffleplugin.commands.coordinates;
import com.okawaffles.helpfulwaffleplugin.commands.whereis;
// bukkit, etc...
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelpfulWafflePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // prepare commands
        this.getCommand("coords").setExecutor(new coordinates());
        this.getCommand("whereis").setExecutor(new whereis());

        Bukkit.getLogger().info("HelpfulWafflePlugin Loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("HelpfulWafflePlugin Unloaded!");
    }
}

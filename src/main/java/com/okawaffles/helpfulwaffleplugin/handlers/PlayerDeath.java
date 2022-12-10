package com.okawaffles.helpfulwaffleplugin.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;

import com.okawaffles.helpfulwaffleplugin.dataStorage.deathCoordinates;

public class PlayerDeath implements Listener {
    deathCoordinates dp = new deathCoordinates();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Bukkit.getLogger().info("HWP Debug: player death event triggered.");
        // store player location to hashmap
        Location deathLoc = e.getEntity().getLocation();
        dp.updatePlayerDeathPoint(e.getEntity(), deathLoc);

        Bukkit.getLogger().info("the hashmap now looks like: " + dp.getDeathPointsMap());
    }
}

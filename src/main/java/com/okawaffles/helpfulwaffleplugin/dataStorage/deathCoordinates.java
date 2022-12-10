package com.okawaffles.helpfulwaffleplugin.dataStorage;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class deathCoordinates {
    // this holds the coordinates where the player last died:
    private static HashMap<Player, Location> deathPoints = new HashMap<Player, Location>();

    public HashMap<Player, Location> getDeathPointsMap() {
        return deathPoints;
    }
    public void updatePlayerDeathPoint(Player p, Location l) {
        deathPoints.put(p, l);
    }
    public boolean checkForPlayerKey(Player p) {
        return deathPoints.containsKey(p);
    }
    public Location getPlayerDeathPoint(Player p) {
        return deathPoints.get(p);
    }
}

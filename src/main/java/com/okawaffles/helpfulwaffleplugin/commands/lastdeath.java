package com.okawaffles.helpfulwaffleplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

import com.okawaffles.helpfulwaffleplugin.dataStorage.deathCoordinates;

public class lastdeath implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        deathCoordinates dp = new deathCoordinates();

        if (dp.checkForPlayerKey((Player) sender)) {
            Location plrLoc = dp.getPlayerDeathPoint((Player) sender);
            String coords = Math.round(plrLoc.getX()) + " / " + Math.round(plrLoc.getY()) + " / " + Math.round(plrLoc.getZ());
            sender.sendMessage(ChatColor.GOLD + "[~] Your last death point was: " + coords);
        } else {
            sender.sendMessage(ChatColor.RED + "[~] Sorry, either the server restarted/reloaded or we don't have your last death coordinates!");
        }
        return true;
    }
}

package com.okawaffles.helpfulwaffleplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class whereis implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player me = (Player) sender;
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "[!] Please supply a player name");
            return false;
        }

        Player toGet = (Player) Bukkit.getPlayerExact(args[0]);
        String plrXYZ = Math.round(toGet.getLocation().getX()) + " / " + Math.round(toGet.getLocation().getY()) + " / " + Math.round(toGet.getLocation().getZ());
        me.sendMessage(ChatColor.GOLD +""+ ChatColor.ITALIC + "[~] " + toGet.getDisplayName() + "'s coordinates are: " + plrXYZ);
        
        return true;
    }
}
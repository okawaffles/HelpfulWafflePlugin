package com.okawaffles.helpfulwaffleplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class coordinates implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player plr0 = (Player) sender;

        if (args.length == 0) {
            plr0.sendMessage(ChatColor.DARK_RED + "[!] Please specify one of the following options: broadcast, tell");
            return false;
        }

        double plrX = plr0.getLocation().getX();
        double plrY = plr0.getLocation().getY();
        double plrZ = plr0.getLocation().getZ();
        String myCoordinates = Math.round(plrX) +" / "+ Math.round(plrY) +" / "+ Math.round(plrZ);

        switch(args[0]) {
            case "broadcast":
                Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "[~] " + plr0.getDisplayName() + "'s coordinates are: " + myCoordinates);
                break;
            case "tell":
                if (args.length < 2) {
                    plr0.sendMessage(ChatColor.DARK_RED + "[!] Please provide a player!");
                    return false;
                }
                
                Player sendTo = Bukkit.getPlayer(args[1]);

                plr0.sendMessage(ChatColor.DARK_GREEN + "[~ To " + sendTo.getDisplayName() + "] My coordinates are " + myCoordinates + "! ");
                sendTo.sendMessage(ChatColor.DARK_AQUA + "[~ From " + sendTo.getDisplayName() + "] My coordinates are " + myCoordinates + "! ");
                sendTo.playSound(sendTo.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 20F, 1F);

                break;
            default:
                plr0.sendMessage(ChatColor.DARK_RED + "[!] Please specify one of the following options: broadcast, tell");
                break;
        }

        return true;
    }
}

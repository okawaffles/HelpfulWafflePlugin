package com.okawaffles.helpfulwaffleplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
* todo:
*  - refactor code (i.e. get rid of if/else statements where possible)
* */

public class coordinates implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player plr0 = (Player) sender;
            String myCoordinates = plr0.getLocation().toString();

            if (args.length > 0) {
                switch(args[0]) {
                    case "broadcast":
                        Bukkit.broadcastMessage(ChatColor.DARK_AQUA.toString() + "[~] " + plr0.getDisplayName() + "'s coordinates are: ");
                        break;
                    case "tell":
                        Player sendTo;
                        if (args.length > 1) {
                            sendTo = (Player) Bukkit.getPlayer(args[1]);
                            plr0.sendMessage(ChatColor.DARK_GREEN.toString() + "[~ To" + sendTo.getDisplayName() + "] Couldn't find that player!");
                        } else plr0.sendMessage(ChatColor.DARK_RED.toString() + "[!] Please provide a player!");
                        break;
                    default:
                        plr0.sendMessage(ChatColor.DARK_RED.toString() + "[!] Please specify one of the following options: broadcast, tell");
                        break;
                }
            } else {
                plr0.sendMessage(ChatColor.DARK_RED.toString() + "[!] Please specify one of the following options: broadcast, tell");
            }

            return true;
        } else return false;
    }
}

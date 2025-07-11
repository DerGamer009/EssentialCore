package net.devvoxel.essentialcore.commands;

import net.devvoxel.essentialcore.EssentialCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMoneyCommand implements CommandExecutor {
    private final EssentialCore plugin;

    public SetMoneyCommand(EssentialCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("essentialcore.setmoney")) {
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /setmoney <player> <amount>");
            return true;
        }
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }
        double amount;
        try {
            amount = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Invalid amount.");
            return true;
        }
        if (amount < 0) amount = 0;
        plugin.getMoneyManager().setBalance(target.getUniqueId(), amount);
        sender.sendMessage(ChatColor.GREEN + "Set " + target.getName() + "'s balance to " + amount + ".");
        target.sendMessage(ChatColor.GOLD + "Your balance was set to " + amount + ".");
        return true;
    }
}

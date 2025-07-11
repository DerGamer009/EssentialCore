package net.devvoxel.essentialcore.commands;

import net.devvoxel.essentialcore.EssentialCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PayCommand implements CommandExecutor {
    private final EssentialCore plugin;

    public PayCommand(EssentialCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /pay <player> <amount>");
            return true;
        }
        Player payer = (Player) sender;
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            payer.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }
        double amount;
        try {
            amount = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            payer.sendMessage(ChatColor.RED + "Invalid amount.");
            return true;
        }
        if (amount <= 0) {
            payer.sendMessage(ChatColor.RED + "Amount must be positive.");
            return true;
        }
        if (!plugin.getMoneyManager().withdraw(payer.getUniqueId(), amount)) {
            payer.sendMessage(ChatColor.RED + "You don't have enough money.");
            return true;
        }
        plugin.getMoneyManager().deposit(target.getUniqueId(), amount);
        payer.sendMessage(ChatColor.GREEN + "Paid " + amount + " to " + target.getName() + ".");
        target.sendMessage(ChatColor.GOLD + payer.getName() + " paid you " + amount + ".");
        return true;
    }
}

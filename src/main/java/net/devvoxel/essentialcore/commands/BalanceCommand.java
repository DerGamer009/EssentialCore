package net.devvoxel.essentialcore.commands;

import net.devvoxel.essentialcore.EssentialCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {
    private final EssentialCore plugin;

    public BalanceCommand(EssentialCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (!sender.hasPermission("essentialcore.balance.other")) {
                sender.sendMessage(ChatColor.RED + "No permission.");
                return true;
            }
            OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
            double bal = plugin.getMoneyManager().getBalance(target.getUniqueId());
            sender.sendMessage(ChatColor.GOLD + target.getName() + " Balance: " + ChatColor.YELLOW + bal);
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        double balance = plugin.getMoneyManager().getBalance(player.getUniqueId());
        player.sendMessage(ChatColor.GOLD + "Balance: " + ChatColor.YELLOW + balance);
        return true;
    }
}

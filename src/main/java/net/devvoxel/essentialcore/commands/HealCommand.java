package net.devvoxel.essentialcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
        player.sendMessage(ChatColor.GREEN + "You have been healed.");
        return true;
    }
}

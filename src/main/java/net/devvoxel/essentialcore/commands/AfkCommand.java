package net.devvoxel.essentialcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AfkCommand implements CommandExecutor {
    private static final Set<UUID> afkPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        UUID id = player.getUniqueId();
        if (afkPlayers.contains(id)) {
            afkPlayers.remove(id);
            Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + " is no longer AFK.");
        } else {
            afkPlayers.add(id);
            Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + " is now AFK.");
        }
        return true;
    }
}

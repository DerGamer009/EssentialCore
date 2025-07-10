package net.devvoxel.essentialcore.commands;

import net.devvoxel.essentialcore.EssentialCore;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    private final EssentialCore plugin;

    public HomeCommand(EssentialCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        Location loc = plugin.getHomes().get(player.getUniqueId());
        if (loc != null) {
            player.teleport(loc);
            player.sendMessage(ChatColor.YELLOW + "Teleported to home.");
        } else {
            player.sendMessage(ChatColor.RED + "No home set.");
        }
        return true;
    }
}

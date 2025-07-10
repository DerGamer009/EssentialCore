package net.devvoxel.essentialcore.commands;

import net.devvoxel.essentialcore.EssentialCore;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final EssentialCore plugin;

    public SetSpawnCommand(EssentialCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        Location loc = player.getLocation();
        plugin.setSpawn(loc);
        player.sendMessage(ChatColor.YELLOW + "Spawn location set.");
        return true;
    }
}

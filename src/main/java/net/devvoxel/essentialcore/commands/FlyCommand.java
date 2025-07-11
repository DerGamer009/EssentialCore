package net.devvoxel.essentialcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        boolean enable = !player.getAllowFlight();
        player.setAllowFlight(enable);
        player.setFlying(enable);
        player.sendMessage(ChatColor.GREEN + "Fly " + (enable ? "enabled" : "disabled") + ".");
        return true;
    }
}

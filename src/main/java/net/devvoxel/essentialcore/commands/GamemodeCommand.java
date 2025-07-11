package net.devvoxel.essentialcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        GameMode targetMode = player.getGameMode() == GameMode.SURVIVAL ? GameMode.CREATIVE : GameMode.SURVIVAL;
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("survival")) {
                targetMode = GameMode.SURVIVAL;
            } else if (args[0].equalsIgnoreCase("creative")) {
                targetMode = GameMode.CREATIVE;
            }
        }
        player.setGameMode(targetMode);
        player.sendMessage(ChatColor.GREEN + "Gamemode set to " + targetMode.name().toLowerCase() + ".");
        return true;
    }
}

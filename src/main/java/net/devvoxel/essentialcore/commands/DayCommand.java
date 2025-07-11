package net.devvoxel.essentialcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        World world;
        if (sender instanceof Player) {
            world = ((Player) sender).getWorld();
        } else {
            world = Bukkit.getWorlds().get(0);
        }
        world.setTime(1000);
        sender.sendMessage(ChatColor.YELLOW + "Time set to day.");
        return true;
    }
}

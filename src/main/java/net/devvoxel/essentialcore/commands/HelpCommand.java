package net.devvoxel.essentialcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class HelpCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public HelpCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.GOLD + "Available commands:");
        for (String cmd : plugin.getDescription().getCommands().keySet()) {
            sender.sendMessage(ChatColor.YELLOW + "/" + cmd);
        }
        return true;
    }
}

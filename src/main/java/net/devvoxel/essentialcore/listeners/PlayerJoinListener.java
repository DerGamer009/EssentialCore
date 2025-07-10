package net.devvoxel.essentialcore.listeners;

import net.devvoxel.essentialcore.EssentialCore;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final EssentialCore plugin;

    public PlayerJoinListener(EssentialCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(ChatColor.GREEN + "Willkommen auf dem Server, " + event.getPlayer().getName() + "!");
        if (plugin.getSpawn() != null && !event.getPlayer().hasPlayedBefore()) {
            event.getPlayer().teleport(plugin.getSpawn());
        }
    }
}

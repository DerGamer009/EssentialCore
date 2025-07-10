package net.devvoxel.essentialcore;

import net.devvoxel.essentialcore.commands.*;
import net.devvoxel.essentialcore.listeners.PlayerJoinListener;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EssentialCore extends JavaPlugin {

    private final Map<UUID, Location> homes = new HashMap<>();
    private Location spawn;

    public Map<UUID, Location> getHomes() {
        return homes;
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    @Override
    public void onEnable() {
        getLogger().info("EssentialCore enabled!");

        // register commands
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("sethome").setExecutor(new SetHomeCommand(this));
        getCommand("home").setExecutor(new HomeCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        // register listeners
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("EssentialCore disabled!");
    }
}

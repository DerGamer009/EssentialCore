package net.devvoxel.essentialcore;

import net.devvoxel.essentialcore.commands.*;
import net.devvoxel.essentialcore.economy.MoneyManager;
import net.devvoxel.essentialcore.listeners.PlayerJoinListener;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EssentialCore extends JavaPlugin {

    private final Map<UUID, Location> homes = new HashMap<>();
    private Location spawn;
    private MoneyManager moneyManager;

    public Map<UUID, Location> getHomes() {
        return homes;
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public MoneyManager getMoneyManager() {
        return moneyManager;
    }

    @Override
    public void onEnable() {
        getLogger().info("EssentialCore enabled!");

        moneyManager = new MoneyManager(getDataFolder());

        // register commands
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("sethome").setExecutor(new SetHomeCommand(this));
        getCommand("home").setExecutor(new HomeCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("afk").setExecutor(new AfkCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("help").setExecutor(new HelpCommand(this));
        getCommand("balance").setExecutor(new BalanceCommand(this));
        getCommand("pay").setExecutor(new PayCommand(this));
        getCommand("setmoney").setExecutor(new SetMoneyCommand(this));

        // register listeners
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
    }

    @Override
    public void onDisable() {
        if (moneyManager != null) {
            moneyManager.saveBalances();
        }
        getLogger().info("EssentialCore disabled!");
    }
}

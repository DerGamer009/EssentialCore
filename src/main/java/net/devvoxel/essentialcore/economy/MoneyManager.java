package net.devvoxel.essentialcore.economy;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MoneyManager {
    public static final double DEFAULT_BALANCE = 100.0;

    private final File file;
    private final Map<UUID, Double> balances = new HashMap<>();
    private final YamlConfiguration data;

    public MoneyManager(File dataFolder) {
        this.file = new File(dataFolder, "balances.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.data = YamlConfiguration.loadConfiguration(file);
        for (String key : data.getKeys(false)) {
            try {
                UUID id = UUID.fromString(key);
                balances.put(id, data.getDouble(key));
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public double getBalance(UUID id) {
        return balances.getOrDefault(id, 0.0);
    }

    public void setBalance(UUID id, double amount) {
        balances.put(id, Math.max(0.0, amount));
    }

    public boolean withdraw(UUID id, double amount) {
        if (amount < 0) return false;
        double current = getBalance(id);
        if (current < amount) {
            return false;
        }
        setBalance(id, current - amount);
        return true;
    }

    public void deposit(UUID id, double amount) {
        if (amount < 0) return;
        setBalance(id, getBalance(id) + amount);
    }

    public void saveBalances() {
        for (Map.Entry<UUID, Double> entry : balances.entrySet()) {
            data.set(entry.getKey().toString(), entry.getValue());
        }
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

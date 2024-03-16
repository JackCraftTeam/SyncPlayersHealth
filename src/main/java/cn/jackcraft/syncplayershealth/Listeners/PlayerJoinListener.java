package cn.jackcraft.syncplayershealth.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;

public class PlayerJoinListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Map<Double, Double> healthCounts = new HashMap<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            double health = p.getHealth();
            healthCounts.put(health, healthCounts.getOrDefault(health, (double) 0) + 1);
        }
        double mostHealth = -1;
        double maxCount = 0;
        for (Map.Entry<Double, Double> entry : healthCounts.entrySet()) {
            double health = entry.getKey();
            double count = entry.getValue();
            if (count > maxCount) {
                mostHealth = health;
                maxCount = count;
            }
        }
        if (mostHealth != -1) {
            player.setHealth(mostHealth);
        }
    }
}

package cn.jackcraft.syncplayershealth;

import cn.jackcraft.syncplayershealth.Listeners.PlayerDamageListener;
import cn.jackcraft.syncplayershealth.Listeners.PlayerJoinListener;
import cn.jackcraft.syncplayershealth.Listeners.PlayerRegainHealthListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class SyncPlayersHealth extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerDamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerRegainHealthListener(), this);
    }
    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public static void syncHealth(Player player, double health) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.equals(player) && onlinePlayer.isValid()) {
                if (health < 0) {
                    onlinePlayer.setHealth(0);
                } else {
                    onlinePlayer.setHealth(health);
                }
            }
        }
    }
}

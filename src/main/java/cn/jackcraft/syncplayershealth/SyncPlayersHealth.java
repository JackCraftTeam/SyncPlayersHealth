package cn.jackcraft.syncplayershealth;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SyncPlayersHealth extends JavaPlugin {
    @Override
    public void onEnable() {
    }
    @Override
    public void onDisable() {
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

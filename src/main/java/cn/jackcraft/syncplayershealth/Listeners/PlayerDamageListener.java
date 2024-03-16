package cn.jackcraft.syncplayershealth.Listeners;

import cn.jackcraft.syncplayershealth.SyncPlayersHealth;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            SyncPlayersHealth.syncHealth(player, player.getHealth() - event.getFinalDamage());
        }
    }
}

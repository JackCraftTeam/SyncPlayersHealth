package cn.jackcraft.syncplayershealth.Listeners;

import cn.jackcraft.syncplayershealth.SyncPlayersHealth;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class PlayerRegainHealthListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerRegainHealth(EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            double targetHealth = player.getHealth() + event.getAmount();
            double playerMaxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            if (targetHealth > playerMaxHealth) {
                targetHealth = playerMaxHealth;
            }
            SyncPlayersHealth.syncHealth(player, targetHealth);
        }
    }
}

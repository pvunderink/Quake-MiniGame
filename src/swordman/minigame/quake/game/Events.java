package swordman.minigame.quake.game;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import swordman.minigame.quake.Main;
import swordman.minigame.quake.gun.GunHandler;
import swordman.minigame.quake.gun.QuakeGun;

public class Events implements Listener {

	public Events(final Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

	@EventHandler
	public void onMove(final PlayerMoveEvent ev) {
		final Player p = ev.getPlayer();

		if (GunHandler.gunInHand(p) != null) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 1), false);
		}
	}
	
	@EventHandler
	public void onInteract(final PlayerInteractEvent ev) {
		if (ev.getAction() == Action.RIGHT_CLICK_AIR || ev.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player p = ev.getPlayer();
			if (GunHandler.gunInHand(p) != null) {
				QuakeGun gun = GunHandler.gunInHand(p);
				GunHandler.shoot(p, gun);
				ev.setCancelled(true);
			}
		}
	}

}

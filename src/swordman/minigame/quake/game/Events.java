package swordman.minigame.quake.game;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import swordman.minigame.quake.Main;
import swordman.minigame.quake.gun.GunHandler;

public class Events implements Listener {

	public Events(final Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

	@EventHandler
	public void onMove(final PlayerMoveEvent ev) {
		final Player p = ev.getPlayer();
		
		p.setWalkSpeed(GunHandler.gunInHand(p).getWalkSpeed());
	}

}

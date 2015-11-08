package swordman.minigame.quake.map;

import org.bukkit.entity.Player;

import swordman.minigame.api.arena.Arena;
import swordman.minigame.api.player.PlayerHandler;

public class QuakeMap {
	
	final Arena arena;
	
	public QuakeMap(final Arena arena) {
		this.arena = arena;
	}
	
	public void join(final Player p) {
		PlayerHandler.joinArena(p, arena);
	}
	
	@Deprecated
	public void leave(final Player p) {
		PlayerHandler.leaveArena(p);
	}

}

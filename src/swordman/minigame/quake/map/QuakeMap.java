package swordman.minigame.quake.map;

import org.bukkit.entity.Player;

import swordman.minigame.api.arena.Arena;
import swordman.minigame.api.player.PlayerHandler;

public class QuakeMap {
	
	Arena arena;
	
	public QuakeMap(Arena arena) {
		this.arena = arena;
	}
	
	public void join(Player p) {
		PlayerHandler.joinArena(p, arena);
	}
	
	@Deprecated
	public void leave(Player p) {
		PlayerHandler.leaveArena(p);
	}

}

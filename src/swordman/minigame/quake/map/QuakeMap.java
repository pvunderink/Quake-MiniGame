package swordman.minigame.quake.map;

import org.bukkit.entity.Player;

import swordman.minigame.api.arena.Arena;
import swordman.minigame.api.player.PlayerHandler;
import swordman.minigame.api.timer.CountdownTimer;

public class QuakeMap {

	final Arena arena;

	public QuakeMap(final Arena arena) {
		this.arena = arena;
		arena.setName("quake_arena");
	}

	public void join(final Player p) {
		PlayerHandler.joinArena(p, this.arena);
	}

	@Deprecated
	public void leave(final Player p) {
		PlayerHandler.leaveArena(p);
	}

	public void fullArena() {

		if (arena.getName() == "quake_arena") {
			if (arena.isFull()) {
				CountdownTimer quaketimer = new CountdownTimer(arena, 30,
						"The arena will start in:");
				quaketimer.run();
			}
		}
	}
}

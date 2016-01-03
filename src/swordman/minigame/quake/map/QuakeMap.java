package swordman.minigame.quake.map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import swordman.minigame.api.arena.Arena;
import swordman.minigame.api.player.PlayerHandler;
import swordman.minigame.api.timer.CountdownTimer;

public class QuakeMap {

	final Arena arena;
	String message;

	public QuakeMap(final Arena arena) {
		this.arena = arena;
		arena.setName("quake_arena");
	}

	public void join(final Player p) {
		PlayerHandler.joinArena(p, this.arena);
		this.arena.broadcastMessage(p.getName() + " joined the arena! ("
				+ arena.getPlayers() + "/16)");
	}

	@Deprecated
	public void leave(final Player p) {
		PlayerHandler.leaveArena(p);
	}

	public void fullArena() {

		if (arena.getName() == "quake_arena") {
			if (arena.getPlayers().size() >= arena.getMax() * 0.80) {
				int minimumplayers = arena.getMin();
				this.message = ChatColor.BLACK + "[" + ChatColor.DARK_RED
						+ "%arena%" + "]" + ChatColor.GOLD
						+ " Game starting in %time% seconds";
				if (arena.getPlayers().size() >= minimumplayers) {

				CountdownTimer quaketimer = new CountdownTimer(arena, 30,
						this.message);
				quaketimer.run();
				}
			}
		}
	}
}

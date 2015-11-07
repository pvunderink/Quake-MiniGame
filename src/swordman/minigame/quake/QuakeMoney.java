package swordman.minigame.quake;

import org.bukkit.event.Listener;

public class QuakeMoney implements Listener {
	public QuakeMoney(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

}

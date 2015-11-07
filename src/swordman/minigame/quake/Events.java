package swordman.minigame.quake;

import org.bukkit.event.Listener;

public class Events implements Listener {
	public Events(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

}

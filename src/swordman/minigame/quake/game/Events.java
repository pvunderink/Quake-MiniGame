package swordman.minigame.quake.game;

import org.bukkit.event.Listener;

import swordman.minigame.quake.Main;

public class Events implements Listener {
	
	public Events(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

}

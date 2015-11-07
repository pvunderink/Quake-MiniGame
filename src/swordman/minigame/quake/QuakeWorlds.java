package swordman.minigame.quake;

import org.bukkit.event.Listener;

public class QuakeWorlds implements Listener {
	public QuakeWorlds(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

}

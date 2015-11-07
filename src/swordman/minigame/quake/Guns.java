package swordman.minigame.quake;

import org.bukkit.event.Listener;
import swordman.minigame.quake.GunInventory;

public class Guns implements Listener {
	public Guns(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

}

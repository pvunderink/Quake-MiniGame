package swordman.minigame.quake;

import org.bukkit.event.Listener;

public class GunInventory implements Listener {
	public GunInventory(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

}

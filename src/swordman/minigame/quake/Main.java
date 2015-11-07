package swordman.minigame.quake;

import org.bukkit.plugin.java.JavaPlugin;

import swordman.minigame.quake.game.Events;

public class Main extends JavaPlugin {

	public void onEnable() {
		getLogger().info("The plugin has been enabled!");
		new Events(this);
	}
	
	public void onDisable() {
		getLogger().info("The plugin has been disabled!");
	}
	
}

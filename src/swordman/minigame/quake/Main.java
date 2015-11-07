package swordman.minigame.quake;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		getLogger().info("The plugin has been enabled!");
		new Events(this);
		new Guns(this);
		new GunInventory(this);
		new QuakeMoney(this);
		new QuakeWorlds(this);
		
	}
	public void onDisable() {
		getLogger().info("The plugin has been disabled!");
	}
	
}

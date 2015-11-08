package swordman.minigame.quake;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import swordman.minigame.quake.game.Events;

public class Main extends JavaPlugin {

	public static Plugin plugin;

	public void onEnable() {
		if (!checkDependencies()) {
			return;
		}
		
		plugin = this;

		getLogger().info(String.format("%s has been enabled!", getDescription().getName()));
		new Events(this);
	}

	public void onDisable() {
		getLogger().info(String.format("%s has been disabled!", getDescription().getName()));
	}

	public boolean checkDependencies() {
		for (String s : this.getDescription().getDepend()) {
			final Plugin p = Bukkit.getPluginManager().getPlugin(s);
		
			if (p != null) {
				if (!p.isEnabled()) {
					Bukkit.getPluginManager().enablePlugin(p);
					getLogger().info(String.format("Dependency (%s) was not enabled. Enabling %s...", s, s));
				}				
			} else {
				getLogger().severe(String.format("Dependency (%s) was not found. Disabling %s...", s, getDescription().getName()));
				
				Bukkit.getPluginManager().disablePlugin(this);
			}
		}
		
		getLogger().info("All dependencies were found and enabled");
		
		return true;
	}
}

package swordman.minigame.quake;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import swordman.minigame.quake.game.Events;

public class Main extends JavaPlugin {

	public static Plugin plugin;

	public boolean checkDependencies() {
		for (final String s : this.getDescription().getDepend()) {
			final Plugin p = Bukkit.getPluginManager().getPlugin(s);

			if (p != null) {
				if (!p.isEnabled()) {
					Bukkit.getPluginManager().enablePlugin(p);
					this.getLogger().info(String.format("Dependency (%s) was not enabled. Enabling %s...", s, s));
				}
			} else {
				this.getLogger().severe(String.format("Dependency (%s) was not found. Disabling %s...", s, this.getDescription().getName()));

				Bukkit.getPluginManager().disablePlugin(this);
			}
		}

		this.getLogger().info("All dependencies were found and enabled");

		return true;
	}

	@Override
	public void onDisable() {
		this.getLogger().info(String.format("%s has been disabled!", this.getDescription().getName()));
	}

	@Override
	public void onEnable() {
		if (!this.checkDependencies())
			return;

		plugin = this;

		this.getLogger().info(String.format("%s has been enabled!", this.getDescription().getName()));
		new Events(this);
	}
}

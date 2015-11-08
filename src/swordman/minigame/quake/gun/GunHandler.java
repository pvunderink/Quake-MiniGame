package swordman.minigame.quake.gun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import swordman.minigame.quake.Main;

public class GunHandler {

	private static List<String> reloaded = new ArrayList<String>();

	public static void giveGun(final Player p) {
		// TODO create an item to put in the players inventory with a fancy name, description and metadata key

		// set metadata:
		// item.setMetadata("Data Name", new FixedMetadataValue(Main.plugin, "Data Value"));
	}

	public static QuakeGun gunInHand(final Player p) {
		// TODO check if the item in the player's hand is a gun (using metadata) and return the type of the gun or null

		for (final QuakeGun gun : QuakeGun.values()) {
			// compare item in hand to gun
			// use: item.isSimilar(otherItem)
		}

		return null;
	}

	public static void reload(final Player p, final double time) {
		final ReloadTimer timer = new ReloadTimer(p, time);
		final BukkitTask task = Bukkit.getScheduler().runTaskTimer(Main.plugin, timer, 0L, 1L);
		timer.setTask(task);
	}

	public static void shoot(final Player p, final QuakeGun gun) {
		if (reloaded.contains(p.getName()) && gun != null) {
			final Set<Material> transparent = new HashSet<Material>();
			transparent.add(Material.AIR); // Materials that are considered transparent and you can shoot through
			transparent.add(Material.WATER);

			final List<Block> blocks = p.getLineOfSight(transparent, 100);

			for (final Block b : blocks) {
				// TODO check for players at the location of the block and kill them. Particle effect/ firework is also created here.
			}

			reloaded.remove(p.getName());
			reload(p, gun.reloadTime);
		}
	}

	private static class ReloadTimer implements Runnable {

		final Player p;
		BukkitTask task;

		final double time;

		private ReloadTimer(final Player p, final double time) {
			this.p = p;
			this.time = time;
			p.setExp(0);
		}

		@Override
		public void run() {
			if (this.p.getExp() < 1)
				this.p.setExp((float) (this.p.getExp() + 1f / (this.time * 20)));
			else {
				reloaded.add(this.p.getName());
				this.task.cancel();
			}
		}

		public void setTask(final BukkitTask task) {
			this.task = task;
		}
	}

}

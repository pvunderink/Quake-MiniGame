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

	public static QuakeGun gunInHand(Player p) {
		// TODO check if the item in the player's hand is a gun (using metadata) and return the type of the gun or null
		
		
		for (QuakeGun gun : QuakeGun.values()) {
			// compare item in hand to gun
			// use: item.isSimilar(otherItem)
		}
		
		return null;
	}
	
	public static void giveGun(Player p) {
		// TODO create an item to put in the players inventory with a fancy name, description and metadata key
		
		// set metadata:
		// item.setMetadata("Data Name", new FixedMetadataValue(Main.plugin, "Data Value"));
	}

	public static void shoot(Player p, QuakeGun gun) {
		if (reloaded.contains(p.getName()) && gun != null) {			
			Set<Material> transparent = new HashSet<Material>();
			transparent.add(Material.AIR); // Materials that are considered transparent and you can shoot through
			transparent.add(Material.WATER);
			
			List<Block> blocks = p.getLineOfSight(transparent, 100);
			
			for (Block b : blocks) {
				// TODO check for players at the location of the block and kill them. Particle effect/ firework is also created here. 
			}

			reloaded.remove(p.getName());
			reload(p, gun.reloadTime);
		}
	}

	public static void reload(Player p, double time) {
		ReloadTimer timer = new ReloadTimer(p, time);
		BukkitTask task = Bukkit.getScheduler().runTaskTimer(Main.plugin, timer, 0L, 1L);
		timer.setTask(task);
	}

	private static class ReloadTimer implements Runnable {

		BukkitTask task;
		double time;
		Player p;

		private ReloadTimer(final Player p, final double time) {
			this.p = p;
			this.time = time;
			p.setExp(0);
		}

		public void run() {
			if (p.getExp() < 1) {
				p.setExp((float) (p.getExp() + 1f / (time * 20)));
			} else {
				reloaded.add(p.getName());
				task.cancel();
			}
		}

		public void setTask(BukkitTask task) {
			this.task = task;
		}
	}

}

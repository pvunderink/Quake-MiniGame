package swordman.minigame.quake.gun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitTask;

import swordman.minigame.quake.Main;
import swordman.minigame.quake.gun.QuakeGun;

public class GunHandler {

	private static List<String> reloaded = new ArrayList<String>();

	public static void giveGun(final Player p, final QuakeGun gun) {
		p.getInventory().addItem(gun.getItemStack());
	}

	public static QuakeGun gunInHand(final Player p) {
		for (final QuakeGun gun : QuakeGun.values())
			if (p.getItemInHand().isSimilar(gun.getItemStack())) {
				return gun;
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

			final int distance = 100;

			final List<Block> blocks = p.getLineOfSight(transparent, distance);

			final List<Entity> entities = p.getNearbyEntities(distance, distance, distance);

			for (final Entity en : entities)
				if (!(en instanceof Player))
					entities.remove(en);

			for (final Block b : blocks)
				for (final Entity en : entities)
					if (en.getLocation().distance(b.getLocation()) < 0.3) {
						((Player) en).setHealth(0);

						final Firework fw = (Firework) b.getWorld().spawnEntity(b.getLocation(), EntityType.FIREWORK);
						final FireworkMeta fwm = fw.getFireworkMeta();
						final Random r = new Random();
						Type type = Type.BALL;
						type = Type.BURST;
						final FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).with(type).trail(r.nextBoolean()).build();
						fwm.addEffect(effect);
						fwm.setPower(1);
						fw.setFireworkMeta(fwm);
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

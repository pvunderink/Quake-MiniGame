package swordman.minigame.quake.effects;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class QuakeEffects {
	
	public static void gunShot(Location loc) {
		final Firework fw1 = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		final FireworkMeta fwm1 = fw1.getFireworkMeta();
		final Type type1 = Type.BURST;
		final Color color1 = Color.MAROON;
		final FireworkEffect effect1 = FireworkEffect.builder().withColor(color1).flicker(true).with(type1).trail(true).build();
		fwm1.addEffect(effect1);
		fwm1.setPower(1);
		fw1.setFireworkMeta(fwm1);

		fw1.remove();
	}
	
	public static void gunDeath(Location loc) {
		final Firework fw1 = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		final FireworkMeta fwm1 = fw1.getFireworkMeta();
		final Type type1 = Type.BURST;
		final Color color1 = Color.MAROON;
		final FireworkEffect effect1 = FireworkEffect.builder().withColor(color1).flicker(true).with(type1).trail(true).build();
		fwm1.addEffect(effect1);
		fwm1.setPower(1);
		fw1.setFireworkMeta(fwm1);
	}

}

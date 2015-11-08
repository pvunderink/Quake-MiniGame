package swordman.minigame.quake.gun;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum QuakeGun {

	GOLD(0.9, 3.0, ChatColor.GOLD + "Golden Gun", Material.GOLD_HOE), IRON(1.1, 2.5, ChatColor.DARK_PURPLE + "Super Gun", Material.IRON_HOE), WOOD(1.3, 2.0, ChatColor.GREEN + "Basic Gun", Material.WOOD_HOE);

	private final Material material;
	private final String name;

	final double reloadTime;
	final double walkSpeed;

	QuakeGun(final double reloadTime, final double walkSpeed, final String name, final Material material) {
		this.reloadTime = reloadTime;
		this.walkSpeed = walkSpeed;
		this.name = name;
		this.material = material;
	}

	public ItemStack getItemStack() {
		final ItemStack result = new ItemStack(this.material);

		final List<String> desc = new ArrayList<String>();
		desc.add(ChatColor.GRAY + "Reload time: " + ChatColor.GREEN + this.reloadTime);
		desc.add(ChatColor.GRAY + "Walk speed: " + ChatColor.GREEN + this.walkSpeed);

		final ItemMeta meta = result.getItemMeta();

		meta.setDisplayName(this.name);
		meta.setLore(desc);

		result.setItemMeta(meta);

		return result;
	}

	public double getReloadTime() {
		return this.reloadTime;
	}

	public double getWalkSpeed() {
		return this.walkSpeed;
	}

}

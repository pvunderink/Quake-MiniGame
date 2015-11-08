package swordman.minigame.quake.gun;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum QuakeGun {

	GOLD("golden_gun", 0.9f, 3.0f, ChatColor.GOLD + "Golden Gun", Material.GOLD_HOE), IRON("super_gun", 1.1f, 2.5f, ChatColor.DARK_PURPLE + "Super Gun", Material.IRON_HOE), WOOD("basic_gun", 1.3f, 2.0f, ChatColor.GREEN + "Basic Gun", Material.WOOD_HOE);

	private final Material material;
	private final String name;
	
	final String id;
	final float reloadTime;
	final float walkSpeed;

	QuakeGun(final String id, final float reloadTime, final float walkSpeed, final String name, final Material material) {
		this.reloadTime = reloadTime;
		this.walkSpeed = walkSpeed;
		this.id = id;
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
	
	public static QuakeGun getById(String id) {
		for (QuakeGun gun : values()) {
			if (gun.id.equalsIgnoreCase(id)) {
				return gun;
			}
		}
		return null;
	}

	public float getReloadTime() {
		return this.reloadTime;
	}

	public float getWalkSpeed() {
		return this.walkSpeed;
	}

}

package swordman.minigame.quake.gun;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum QuakeGun {

	WOOD(1.3, 2.0, ChatColor.GREEN + "Basic Gun", Material.WOOD_HOE), IRON(1.1, 2.5, ChatColor.DARK_PURPLE + "Super Gun", Material.IRON_HOE), GOLD(0.9, 3.0, ChatColor.GOLD + "Golden Gun", Material.GOLD_HOE);

	double reloadTime;
	double walkSpeed;
	
	String name;
	Material material;

	QuakeGun(double reloadTime, double walkSpeed, String name, Material material) {
		this.reloadTime = reloadTime;
		this.walkSpeed = walkSpeed;
		this.name = name;
		this.material = material;
	}
	
	public double getReloadTime() {
		return reloadTime;
	}
	
	public double getWalkSpeed() {
		return walkSpeed;
	}

	public ItemStack getItemStack() {
		ItemStack result = new ItemStack(material);			
		
		List<String> desc = new ArrayList<String>(); 			
		desc.add(ChatColor.GRAY + "Reload time: " + ChatColor.GREEN + reloadTime);
		desc.add(ChatColor.GRAY + "Walk speed: " + ChatColor.GREEN + walkSpeed);
		
		ItemMeta meta = result.getItemMeta();
		
		meta.setDisplayName(name);
		meta.setLore(desc);
		
		result.setItemMeta(meta);
		
		return result;
	}
	
}

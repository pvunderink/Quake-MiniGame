package swordman.minigame.quake.game;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import swordman.minigame.api.arena.Arena;
import swordman.minigame.api.event.ArenaStartEvent;
import swordman.minigame.api.event.ArenaStopEvent;
import swordman.minigame.quake.Main;
import swordman.minigame.quake.gun.GunHandler;
import swordman.minigame.quake.gun.QuakeGun;

public class Events implements Listener {

	public Events(final Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

	@EventHandler
	public void onInteract(final PlayerInteractEvent ev) {
		if (ev.getAction() == Action.RIGHT_CLICK_AIR || ev.getAction() == Action.RIGHT_CLICK_BLOCK) {
			final Player p = ev.getPlayer();
			if (GunHandler.gunInHand(p) != null) {
				final QuakeGun gun = GunHandler.gunInHand(p);
				GunHandler.shoot(p, gun);

				ev.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onMove(final PlayerMoveEvent ev) {
		final Player p = ev.getPlayer();

		final QuakeGun gun = GunHandler.gunInHand(p);
		if (gun != null) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10, gun.getWalkSpeed()), true);
		}
	}
	@EventHandler
	public void onGameStart(final ArenaStartEvent ev) {
		Arena arena = ev.getArena();
		for (Player p : arena.getPlayers()) {
			p.getInventory().addItem(QuakeGun.WOOD.getItemStack());
			p.getInventory().setHeldItemSlot(0);
		}
	}
	@EventHandler
	public void onGameFinish(final ArenaStopEvent ev) {
		Arena arena = ev.getArena();
		for (Player p : arena.getPlayers()) {
			p.getInventory().remove(QuakeGun.WOOD.getItemStack());
		}
		}
	
	@EventHandler
	public void onItemSwitch(final InventoryMoveItemEvent ev) {
		if (ev.getItem() == QuakeGun.WOOD.getItemStack()) {
			ev.setCancelled(true);
		}
	}
	}


package swordman.minigame.quake.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import swordman.minigame.quake.gun.GunHandler;
import swordman.minigame.quake.gun.QuakeGun;

public class GunCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;

			if (args.length > 0) {
				GunHandler.giveGun(p, QuakeGun.getById(args[0]));
			} else {
				GunHandler.giveGun(p, QuakeGun.WOOD);
			}
		}

		return true; 
	}

}

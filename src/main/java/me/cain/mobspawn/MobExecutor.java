package main.java.me.cain.mobspawn;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;

public class MobExecutor implements CommandExecutor
{
	public boolean onCommand(CommandSender s, Command c, String l, String [] args)
	{
		if(s instanceof Player) {
			Player sender = (Player) s;
			if(c.getName().equalsIgnoreCase("mob")) {
				if(args.length < 1) { return false; }
				else {
					if(MobSpawn.hasNode(sender, "mob.spawn")) {
						try {
							sender.getWorld().spawnCreature(sender.getTargetBlock(null, 0).getLocation(), CreatureType.valueOf(args[0].toUpperCase()));
						} catch (Exception e) {
							Util.deny(sender, "Something went wrong. Try again?");
						}
						Util.success(sender, "Mob spawned successfully!");
					} else {
						Util.deny(sender, "Mob spawn denied. No permission.");
					}
				}
			}
		} else {
			s.sendMessage(ChatColor.RED + "You must be in-game to spawn a mob.");
		}
		return false;
	}

}

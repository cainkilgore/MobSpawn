package main.java.me.cain.mobspawn;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class MobSpawn extends JavaPlugin
{
	public static PermissionHandler permHandler;
	public static MobSpawn plugin;
	
	public void onEnable()
	{
		getServer().getPluginCommand("mob").setExecutor(new MobExecutor());
		Util.console("[" + this.getDescription().getName() + "] MobSpawner has been enabled!");
		OldPermissions();
		plugin = this;
	}
	
	public void onDisable()
	{
		Util.console("[" + this.getDescription().getName() + "] MobSpawner has been disabled!");
	}
	
	public void OldPermissions()
	{
		Plugin Perms = getServer().getPluginManager().getPlugin("Permissions");
		if(Perms == null) {
			return;
		}
		else
		{
		    permHandler = ((Permissions) Perms).getHandler();
		    Util.console("[" + this.getDescription().getName() + "] Permissions detected!");
		}
	}
	
	public static boolean hasNode(Player p, String node) {
		if(Bukkit.getServer().getPluginManager().getPlugin("Permissions") != null) {
			return permHandler.has(p, node);
		} else {
			return p.hasPermission(node);
		}
	}
	
}

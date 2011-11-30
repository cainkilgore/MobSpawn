package main.java.me.cain.mobspawn;

import org.bukkit.plugin.java.JavaPlugin;

public class MobSpawn extends JavaPlugin
{
	public void onEnable()
	{
		getServer().getPluginCommand("mob").setExecutor(new MobExecutor());
		Util.console("[" + this.getDescription().getName() + "] MobSpawner has been enabled!");
	}
	
	public void onDisable()
	{
		Util.console("[" + this.getDescription().getName() + "] MobSpawner has been disabled!");
	}
	
}

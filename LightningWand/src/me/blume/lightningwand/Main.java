package me.blume.lightningwand;

import org.bukkit.plugin.java.JavaPlugin;

import me.blume.lightningwand.commands.GiveWand;
import me.blume.lightningwand.listeners.StrikeLightning;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getCommand("/wand").setExecutor(new GiveWand(this));
		getServer().getPluginManager().registerEvents(new StrikeLightning(this), this);
		loadConfig();
	}
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}

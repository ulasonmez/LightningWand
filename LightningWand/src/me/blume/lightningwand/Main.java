package me.blume.lightningwand;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import me.blume.lightningwand.commands.GiveWand;
import me.blume.lightningwand.listeners.StrikeLightning;

public class Main extends JavaPlugin{
	public HashMap<UUID ,Long> cooldown = new HashMap<UUID, Long>();
	public int cooldowntime = getConfig().getInt("cooldown");
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

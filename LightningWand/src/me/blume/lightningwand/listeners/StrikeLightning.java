package me.blume.lightningwand.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import me.blume.lightningwand.Main;
import me.blume.lightningwand.items.Wand;

public class StrikeLightning implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public StrikeLightning(Main plugin) {
		this.plugin=plugin;
	}
	Wand wandClass = new Wand();
	int radius = plugin.getConfig().getInt("radius");
	@EventHandler
	public void onRightClickWand(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Location loc = event.getPlayer().getLocation();
		Action action = event.getAction();
		if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
			if(event.getHand()==EquipmentSlot.HAND) {
				if(event.getItem().isSimilar(wandClass.wandItem())) {
					for(Player p : Bukkit.getServer().getOnlinePlayers()) {
						if(p==player) continue;
						Location loc2 = p.getLocation();
						if((Math.abs(loc2.getX()-loc.getX())<=radius) && (Math.abs(loc2.getZ()-loc.getZ())<=radius) && (Math.abs(loc2.getY()-loc.getY())<=radius)) {
							event.getPlayer().getWorld().strikeLightning(loc2);
						}
					}
				}
			}
		}
	}
}

package me.blume.lightningwand.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import me.blume.lightningwand.Main;
import me.blume.lightningwand.items.Wand;
import net.md_5.bungee.api.ChatColor;

public class StrikeLightning implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public StrikeLightning(Main plugin) {
		this.plugin=plugin;
	}
	Wand wandClass = new Wand();
	int radius;
	@EventHandler
	public void onRightClickWand(PlayerInteractEvent event) {
		radius=plugin.getConfig().getInt("radius");
		Player player = event.getPlayer();
		Location loc = event.getPlayer().getLocation();
		Action action = event.getAction();
		World world = player.getWorld();
		if(event.getItem()==null) return;
		if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
			if(event.getHand().equals(EquipmentSlot.HAND)) {
				if(event.getItem().isSimilar(wandClass.wandItem())) {
					if(plugin.cooldown.containsKey(player.getUniqueId())) {
						long secondsleft = ((plugin.cooldown.get(player.getUniqueId()) / 1000) + plugin.cooldowntime) - (System.currentTimeMillis() / 1000);
						if(secondsleft >0) {
							player.sendMessage(ChatColor.RED+"Wand is in cooldown for "+secondsleft+" seconds");
							return;
						}
					}
					plugin.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
					for(Entity e : world.getEntities()) {
						if(e==player) continue;
						Location loc2 = e.getLocation();
						if((Math.abs(loc2.getX()-loc.getX())<=radius) && (Math.abs(loc2.getZ()-loc.getZ())<=radius)&& (Math.abs(loc2.getY()-loc.getY())<=radius) ) {
							event.getPlayer().getWorld().strikeLightning(loc2);
							return;
						}
					}
				}
			}
		}
	}
}

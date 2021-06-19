package me.blume.lightningwand.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Wand {
	
	public ItemStack wandItem() {
		ItemStack wand = new ItemStack(Material.STICK);
		ItemMeta meta = wand.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE+"WAND");
		meta.addEnchant(Enchantment.DURABILITY, 100, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		wand.setItemMeta(meta);
		return wand;
	}

}

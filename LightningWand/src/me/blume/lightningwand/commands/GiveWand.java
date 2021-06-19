package me.blume.lightningwand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.blume.lightningwand.Main;
import me.blume.lightningwand.items.Wand;

public class GiveWand implements CommandExecutor{
	Wand wandclass = new Wand();
	@SuppressWarnings("unused")
	private Main plugin;
	public GiveWand(Main plugin) {
		this.plugin=plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equals("/wand")) {
			if(sender instanceof Player) {
				Player player= (Player) sender;
				player.getInventory().addItem(wandclass.wandItem());
			}
		}
		
		return false;
	}
}

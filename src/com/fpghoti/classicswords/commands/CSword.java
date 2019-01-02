package com.fpghoti.classicswords.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.fpghoti.classicswords.ClassicSwordsMain;
import com.fpghoti.classicswords.item.CItem;

public class CSword implements CommandExecutor{

	private ClassicSwordsMain plugin;

	public CSword(ClassicSwordsMain plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(label.equalsIgnoreCase("csword")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(args[0] != null){
					if(args[0].equalsIgnoreCase("wood")){
						CItem.givecWoodSword(p, false);
					}else if(args[0].equalsIgnoreCase("stone")){
						CItem.givecStoneSword(p, false);
					}else if(args[0].equalsIgnoreCase("iron")){
						CItem.givecIronSword(p, false);
					}else if(args[0].equalsIgnoreCase("gold")){
						CItem.givecGoldSword(p, false);
					}else if(args[0].equalsIgnoreCase("diamond")){
						CItem.givecDiamondSword(p, false);
					}else{
						p.sendMessage(ChatColor.RED + "That is not a valid cSword type!");
					}	
				}
			}
		}
		return true;
	}
}

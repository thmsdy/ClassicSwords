package com.fpghoti.classicswords.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.fpghoti.classicswords.item.CItemManager;

public class CSwordCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(label.equalsIgnoreCase("csword")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(args[0] != null){
					if(args[0].equalsIgnoreCase("wood")){
						CItemManager.givecWoodSword(p, false);
					}else if(args[0].equalsIgnoreCase("stone")){
						CItemManager.givecStoneSword(p, false);
					}else if(args[0].equalsIgnoreCase("iron")){
						CItemManager.givecIronSword(p, false);
					}else if(args[0].equalsIgnoreCase("gold")){
						CItemManager.givecGoldSword(p, false);
					}else if(args[0].equalsIgnoreCase("diamond")){
						CItemManager.givecDiamondSword(p, false);
					}else{
						p.sendMessage(ChatColor.RED + "That is not a valid cSword type!");
					}	
				}
			}
		}
		return true;
	}
}

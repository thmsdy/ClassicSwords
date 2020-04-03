package com.fpghoti.classicswords.listener;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import com.fpghoti.classicswords.item.CItemType;
import com.fpghoti.classicswords.item.ClassicSword;
import com.fpghoti.classicswords.util.Storage;
import com.fpghoti.classicswords.util.Util;

public class InventoryListener implements Listener{

	@EventHandler
	public void onInvOpen(InventoryOpenEvent event){
		if(event.getPlayer() != null){
			Storage.inInv.add((Player)event.getPlayer());
			ClassicSword.toSwordInv(((Player)event.getPlayer()).getInventory());
		}
	}

	@EventHandler
	public void onInvClose(InventoryCloseEvent event){
		if(event.getPlayer() != null && event.getPlayer() instanceof Player){
			if(!Util.usingPack((Player)event.getPlayer())) {
				return;
			}
			Storage.inInv.remove((Player)event.getPlayer());
			ClassicSword.toShieldInv(((Player)event.getPlayer()).getInventory());
			ClassicSword.blockToShieldInv(((Player)event.getPlayer()).getInventory());
		}
	}

	@EventHandler
	public void onExp(PlayerExpChangeEvent event){
		if(event.getPlayer() != null){
			Player p = event.getPlayer();
			if(!Util.usingPack(p)) {
				return;
			}
			if(ClassicSword.isCShield(p.getInventory().getItemInMainHand())) {
				ItemStack csword = p.getInventory().getItemInMainHand();
				if(csword.containsEnchantment(Enchantment.MENDING)) {
					int max = CItemType.getMaxDurability(CItemType.getType(ClassicSword.getCShieldShortName(csword)));
					int dur = ClassicSword.getCShieldDurability(csword);
					int expnum = event.getAmount();
					int pxpadd = 0;
					if(dur != max) {
						if(dur + expnum <= max) {
							ClassicSword.setCShieldDurability(p, csword, dur + expnum);
							event.setAmount(0);
						}else if(dur + expnum > max){
							pxpadd = (dur + expnum) - max;
							ClassicSword.setCShieldDurability(p, csword, max);
							event.setAmount(pxpadd);
						}
					}
				}
			}
		}
	}


	@EventHandler
	public void onInvClick(InventoryClickEvent event){
		Player p =  (Player) event.getWhoClicked();
		if(!Util.usingPack(p)) {
			return;
		}
		if(event.getInventory() != null && p != null){
			if(!event.isShiftClick()) {
				ClassicSword.toSwordInv(p.getInventory());
			}
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		handleDisconnect(event.getPlayer());
	}

	@EventHandler
	public void onPlayerKick(PlayerKickEvent event){
		handleDisconnect(event.getPlayer());
	}

	public static void handleDisconnect(Player p) {
		if(!Util.usingPack(p)) {
			return;
		}
		Storage.inInv.remove(p);
	}


	@EventHandler
	public void onItemClick(InventoryDragEvent event){
		if(event.getWhoClicked() instanceof Player) {
			Player p = (Player)event.getWhoClicked();
			if(!Util.usingPack(p)) {
				return;
			}
		}
		if(event.getClass() != null){
			if(ClassicSword.isCShield(event.getCursor())) {
				ItemStack newsword = ClassicSword.toSword(event.getCursor(), CItemType.getType(ClassicSword.getCShieldShortName(event.getCursor())));
				event.setCursor(newsword);
			}
		}
	}


	@EventHandler
	public void onHold(PlayerItemHeldEvent event){
		if(!Util.usingPack(event.getPlayer())) {
			return;
		}
		if(event.getPlayer() != null && ClassicSword.isCShield(event.getPlayer().getInventory().getItem(event.getNewSlot()))){
			Integer dur = ClassicSword.getCShieldDurability(event.getPlayer().getInventory().getItem(event.getNewSlot()));
			ClassicSword.sendActionbar(event.getPlayer(), "§eDurability: " + dur);
		}
	}


}
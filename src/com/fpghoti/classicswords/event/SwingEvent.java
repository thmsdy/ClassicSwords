package com.fpghoti.classicswords.event;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.fpghoti.classicswords.ClassicSwordsMain;
import com.fpghoti.classicswords.item.CItem;
import com.fpghoti.classicswords.item.CItemType;
import com.fpghoti.classicswords.item.ClassicSword;
import com.fpghoti.classicswords.util.Storage;

public class SwingEvent implements Listener{

	private ClassicSwordsMain plugin;

	public SwingEvent(ClassicSwordsMain plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onSwingAtBlock(BlockDamageEvent event){
		if(event.getBlock() != null){
			if(event.getPlayer().getGameMode() != GameMode.CREATIVE && event.getInstaBreak()) {
				Storage.instabreaks.add(event.getBlock().getType());
			}
		}
	}

	@EventHandler
	public void onSwingAtBlock(BlockBreakEvent event){
		if(event.getPlayer() != null){
			Player p = event.getPlayer();
			if(p.getInventory().getItemInMainHand() != null){
				if(p.getInventory().getItemInMainHand().hasItemMeta()){
					if(ClassicSword.isCShield(p.getInventory().getItemInMainHand())){
						if(event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
							event.setCancelled(true);
						}else {
							if(!Storage.instabreaks.contains(event.getBlock().getType())) {
								ItemStack csword = p.getInventory().getItemInMainHand();
								ClassicSword.damageCItem(p, csword, 2);
							}
						}
					}
				}
			}
		}
	}

	@EventHandler (priority=EventPriority.MONITOR)
	public void onHitPlayer(EntityDamageByEntityEvent event){
		if(event.getEntity() != null){
			if(event.getDamager() instanceof Player) {
				Player p = (Player)event.getDamager();

				if(event.getEntity() instanceof Player) {
					Player damaged = (Player) event.getEntity();
					Storage.recent.put(p, damaged);
					Storage.recenthealth.put(damaged, damaged.getHealth());
					ClassicSwordsMain.runRecent(p, damaged);
				}

				//				if(Storage.blockers.contains(p)) {
				//					System.out.println("B");
				//					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_CHIME, 10.0F, 1.0F);
				//				}

				ItemStack csword = p.getInventory().getItemInMainHand();
				if(ClassicSword.isCShield(csword) && p.getGameMode() != GameMode.CREATIVE) {
					ClassicSword.damageCItem(p, csword, 1);
				}
			}
		}
	}

	@EventHandler
	public void onHit(PlayerInteractEvent event){
		if(event.getPlayer() != null){
			Player p = event.getPlayer();
			if((event.getAction() == Action.LEFT_CLICK_BLOCK) || (event.getAction() == Action.LEFT_CLICK_AIR)) {
				if(ClassicSword.isCShield(event.getPlayer().getInventory().getItemInMainHand())) {
					Storage.swingers.add(event.getPlayer());
					ClassicSwordsMain.runBlockHit(event.getPlayer());
					if(!ClassicSword.isBlocking(p)) {
						ClassicSword.blockToShieldInv(p.getInventory());
					}
				}
			}

			if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

				if(Storage.swingers.contains(p) && ClassicSword.isCShield(p.getInventory().getItemInMainHand())) {
					p.getInventory().setItemInMainHand(ClassicSword.toBlockShield(p.getInventory().getItemInMainHand(), CItemType.getType(ClassicSword.getCShieldShortName(p.getInventory().getItemInMainHand()))));
					//p.playSound(p.getLocation(), Sound.ENTITY_IRONGOLEM_STEP, 10.0F, 1.0F);
					p.playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_STEP, 10.0F, 1.0F);
					
					if(Storage.recent.containsKey(p)) {
						final Player damaged = Storage.recent.get(p);
						Double health = Storage.recenthealth.get(damaged);
						if(damaged != null && damaged.getHealth() != health && !Storage.kb.contains(damaged)) {
							//damaged.getLocation().getY() + 0.5
							
							//damaged.setVelocity(p.getEyeLocation().getDirection().setY(p.getEyeLocation().getDirection().getY() + 0.5).multiply(1.005));
							
							
							double kb = p.getEyeLocation().getDirection().getY();
							if(kb > damaged.getLocation().getDirection().getY()) {
								kb = damaged.getLocation().getDirection().getY();
							}
							
							kb = kb + 0.5;
							
							if(p.getLocation().getY() < damaged.getLocation().getY()) {
								kb = kb/2;
								damaged.setVelocity(p.getEyeLocation().getDirection().setY(kb).multiply(0.25));
							}else {
								//damaged.setVelocity(p.getEyeLocation().getDirection().setY(kb).multiply(1.001));
								damaged.setVelocity(p.getEyeLocation().getDirection().setY(kb).multiply(0.75));
							}
							

							
						if(Storage.perfect.contains(p)) {
							ClassicSword.sendActionbar(p, "§aPerfect!");
							
							Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
								@Override
								public void run() {
									ClassicSword.sendActionbar(p, "§fPe§arfe§act!");
								}
							}, 3L);
							
							
							Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
								@Override
								public void run() {
									ClassicSword.sendActionbar(p, "§aPe§frfe§act!");
								}
							}, 6L);
							
							
							Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
								@Override
								public void run() {
									ClassicSword.sendActionbar(p, "§aPe§arfe§fct!");
								}
							}, 9L);
							
							
							Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
								@Override
								public void run() {
									ClassicSword.sendActionbar(p, "§aPerfect!");
								}
							}, 12L);
							Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
								@Override
								public void run() {
									ClassicSword.sendActionbar(p, "§a§lPerfect!");
								}
							}, 14L);
							
							
							p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.4F);
							Storage.perfect.remove(p);
							Storage.great.remove(p);
							Storage.kb.add(damaged);
							ClassicSwordsMain.runKB(damaged);
						}else if(Storage.great.contains(p)) {
							ClassicSword.sendActionbar(p, "§eGreat!");
							p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.2F);
							Storage.perfect.add(p);
							Storage.kb.add(damaged);
							ClassicSwordsMain.runKB(damaged);
						}else {	
							ClassicSword.sendActionbar(p, "§cGood!");
							p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 1.0F);
							ClassicSwordsMain.streakTimer(p);
							Storage.great.add(p);
							Storage.kb.add(damaged);
							ClassicSwordsMain.runKB(damaged);
						}
						}
						Storage.recenthealth.remove(damaged);
						Storage.recent.remove(p);
					}
					Storage.swingers.remove(p);

					ClassicSwordsMain.blockToShieldTimer(p);
				}else {
					//ClassicSword.sendActionbar(p, "§aBlock hit!");
				}

				//				System.out.println("A");
				//				Storage.blockers.add(p);
				//				ClassicSwordsMain.runBlock(p);
			}else {
				//ClassicSword.sendActionbar(p, "§aBlock hit!");
			}

			try{
				ItemStack holding = p.getInventory().getItemInMainHand();
				if(event.hasBlock()){
					if(holding != null){
						if(holding.hasItemMeta()){
							if(ClassicSword.isCShield(holding)){
								if(event.getAction().toString().contains("LEFT") ){
									if(event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
										event.setCancelled(true);
									}
								}
							}
						}
					}
				}

				if(CItemType.isSword(holding.getType())) {
					ClassicSword.toShield(holding, CItemType.getSwordType(holding.getType()));
				}
			}
			catch(NullPointerException npex){

			}
		}
	}
}

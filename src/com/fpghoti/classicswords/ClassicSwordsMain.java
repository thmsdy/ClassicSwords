package com.fpghoti.classicswords;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.fpghoti.classicswords.commands.CSword;
import com.fpghoti.classicswords.event.BlockingEvent;
import com.fpghoti.classicswords.event.InventoryEvent;
import com.fpghoti.classicswords.event.RegenEvent;
import com.fpghoti.classicswords.event.SwingEvent;
import com.fpghoti.classicswords.item.CItemType;
import com.fpghoti.classicswords.item.ClassicSword;
import com.fpghoti.classicswords.item.SetAttributes;
import com.fpghoti.classicswords.util.Storage;

public class ClassicSwordsMain extends JavaPlugin{
	private static ClassicSwordsMain plugin;

	public void onEnable() {
		plugin = this;
		SetAttributes.defineSwords();
		registerEvents();
		getCommand("CSword").setExecutor(new CSword(this));
		registerConfig();	
		messageSet();
		startItemCheck();
		//startBlockCheck();
	}

	public void onDisable() {
		plugin = null;
	}

	public static Plugin getPlugin()
	{

		return plugin;

	}

	public static ClassicSwordsMain getMain(){
		return plugin;

	}


	private void registerConfig() {
		this.getConfig().options().copyDefaults(true);
		config.options().copyHeader(true);
		saveConfig();
	}
	public void registerEvents(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new SwingEvent(this), this);
		InventoryEvent ie = new InventoryEvent(this);
		pm.registerEvents(ie, this);
		pm.registerEvents(new BlockingEvent(this), this);
		pm.registerEvents(new RegenEvent(this), this);
	}
	FileConfiguration config = this.getConfig();

	public void messageSet(){
		if (config.get("Options")==null){
			config.createSection("Options.ReplaceNormalSwords");
			config.set("Options.ReplaceNormalSwords", false);
			Storage.bools.put("ReplaceNormalSwords", config.getBoolean("Options.ReplaceNormalSwords"));
		}
		this.saveConfig();
	}

	public void startItemCheck() {
		new BukkitRunnable(){
			public void run() {

				for(Player p : Bukkit.getOnlinePlayers()) {
					if(p.getInventory().getItemInMainHand() != null) {
						
//						if(ClassicSword.isCShield(p.getInventory().getItemInMainHand())) {
//							if(p.isHandRaised()) {
//								System.out.println("B");
//								Storage.blockers.add(p);
//								runBlock(p);
//							}
//						}
						
						if(CItemType.isSword(p.getInventory().getItemInMainHand().getType())){
							
							if(!ClassicSword.hasOpenInv(p)) {
								if(!ClassicSword.isBlocking(p) && !Storage.swingers.contains(p) && ClassicSword.isCBlockShield(p.getInventory().getItemInMainHand())) {
									p.getInventory().setItemInMainHand(ClassicSword.blockToShield(p.getInventory().getItemInMainHand(), CItemType.getType(ClassicSword.getCShieldShortName(p.getInventory().getItemInMainHand()))));
								}
								ItemStack newitem = ClassicSword.toShield(p.getInventory().getItemInMainHand(), CItemType.getSwordType(p.getInventory().getItemInMainHand().getType()));
								Integer dur = ClassicSword.getCShieldDurability(newitem);
								p.getInventory().setItemInMainHand(newitem);
								ClassicSword.sendActionbar(p, "§eDurability: " + dur);
							}
						}
//						if(p.isHandRaised() && Storage.swingers.contains(p) && ClassicSword.isCShield(p.getInventory().getItemInMainHand())) {
//							p.getInventory().setItemInMainHand(ClassicSword.toBlockShield(p.getInventory().getItemInMainHand(), CItemType.getType(ClassicSword.getCShieldShortName(p.getInventory().getItemInMainHand()))));
//							p.playSound(p.getLocation(), Sound.ENTITY_IRONGOLEM_STEP, 10.0F, 1.0F);
//							ClassicSword.sendActionbar(p, "§aBlock hit!");
//							Storage.swingers.remove(p);
//
//							blockToShieldTimer(p);
//						}
					}
				}

			}
			//		}.runTaskTimerAsynchronously(this, 1*20, 1*20);
		}.runTaskTimerAsynchronously(this, 1*1, 1*1);
	}

	public static void runBlockHit(Player p) {
		Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
			@Override
			public void run() {
				Storage.swingers.remove(p);
			}
		}, 10L);
	}
	
	public static void runKB(Player p) {
		Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
			@Override
			public void run() {
				Storage.kb.remove(p);
			}
		}, 20L);
	}
	
	
	public static void runBlock(Player p) {
		Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
			@Override
			public void run() {
				Storage.blockers.remove(p);
			}
		}, 20L);
	}
	
	public static void runRecent(Player p, Player damaged) {
		Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
			@Override
			public void run() {
				Storage.recent.remove(p);
				Storage.recenthealth.remove(damaged);
			}
		}, 20L);
	}


	public static void blockToShieldTimer(Player p) {
		Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
			@Override
			public void run() {
				if(!ClassicSword.hasOpenInv(p) && !Storage.swingers.contains(p)) {
					ClassicSword.blockToShieldInv(p.getInventory());
				}
			}
		}, 10L);
	}
	
	public static void streakTimer(Player p) {
		Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
			@Override
			public void run() {
				Storage.great.remove(p);
				Storage.perfect.remove(p);
			}
		}, 80L);
	}


	//	public void startBlockCheck() {
	//		new BukkitRunnable(){
	//			public void run() {
	//				Storage.blockers.clear();
	//				for(Player p : Bukkit.getOnlinePlayers()) {
	//					if(p.getInventory().getItemInMainHand() != null && p.isBlocking()) {
	//						Storage.blockers.add(p);
	//					}
	//				}
	//
	//			}
	//			//		}.runTaskTimerAsynchronously(this, 1*20, 1*20);
	//		}.runTaskTimerAsynchronously(this, 1*1, 1*1);
	//	}



}


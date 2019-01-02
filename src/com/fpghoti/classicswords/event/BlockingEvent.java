package com.fpghoti.classicswords.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;
import org.bukkit.event.inventory.InventoryOpenEvent;

import com.fpghoti.classicswords.ClassicSwordsMain;


public class BlockingEvent  implements Listener{

	private ClassicSwordsMain plugin;

	public BlockingEvent(ClassicSwordsMain plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player) {

			Player p = (Player) event.getEntity();
			if(p.isHandRaised() || p.isBlocking()){
				double newdamage = event.getDamage() * 0.5;
				if(newdamage < 0) {
					newdamage = 0;
				}
				if(event.getDamage(DamageModifier.BLOCKING) >= 0){
					return;
				}
				event.setDamage(DamageModifier.BLOCKING, 0);
				if(event.getFinalDamage() >= newdamage) {
					event.setDamage(DamageModifier.BLOCKING, newdamage * -1);
				}
			}
		}
	}


}

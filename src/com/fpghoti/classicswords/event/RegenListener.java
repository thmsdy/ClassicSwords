package com.fpghoti.classicswords.event;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

import com.fpghoti.classicswords.ClassicSwordsMain;
import com.fpghoti.classicswords.util.Storage;

public class RegenListener implements Listener{

	private ClassicSwordsMain plugin;

	public RegenListener(ClassicSwordsMain plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onRegen(EntityRegainHealthEvent event){
		if(event.getEntityType() == EntityType.PLAYER || event.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED) {
			event.setCancelled(true);
			Player p = (Player) event.getEntity();
			double max = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
			long time = System.currentTimeMillis() / 1000;
			long last = Storage.regens.computeIfAbsent(p.getUniqueId(), id -> System.currentTimeMillis() / 1000);
			if(time - last < (long) 3) {
				return;
			}
			if(p.getHealth() < max){
				double health = p.getHealth() + 1;
				if(health < Math.min(0, max)){
					health = Math.min(0, max);
				}
				if(health > Math.max(0, max)){
					health = Math.max(0, max);
				}
				p.setHealth(health);
				Storage.regens.put(p.getUniqueId(), time);
			}
			Bukkit.getScheduler().runTaskLater(plugin, () -> {
				p.setExhaustion(p.getExhaustion() + 3);
			}, 1L);
		}
	}

}




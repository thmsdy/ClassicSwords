package com.fpghoti.classicswords.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

import com.fpghoti.classicswords.util.Storage;

public class PlayerListener implements Listener{

	@EventHandler
	public void onResourcePack(PlayerResourcePackStatusEvent event){
		if(event.getPlayer() != null){
			Player p = event.getPlayer();
			if(event.getStatus() == PlayerResourcePackStatusEvent.Status.ACCEPTED) {
				Storage.usingPack.add(p);
			}
		}
	}
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void onPlayerQuit(PlayerQuitEvent event) {
		handleQuit(event.getPlayer());
	}

	@EventHandler (priority = EventPriority.NORMAL)
	public void onPlayerKick(PlayerKickEvent event) {
		handleQuit(event.getPlayer());
	}
	
	private static void handleQuit(Player p) {
		Storage.usingPack.remove(p);
	}

}

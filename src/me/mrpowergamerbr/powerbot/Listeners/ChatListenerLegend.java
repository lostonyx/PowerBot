package me.mrpowergamerbr.powerbot.Listeners;

import java.util.ArrayList;

import me.mrpowergamerbr.powerbot.Utils.PowerUtils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;

public class ChatListenerLegend extends PowerUtils implements Listener {
	public static ArrayList<String> players = new ArrayList();
	
	
	// Legendchat
	@EventHandler(priority=EventPriority.LOWEST, ignoreCancelled=true)
	private void onChat(ChatMessageEvent e)
	{
		if (e.isCancelled() == false) {
			String mensagem = e.getMessage();
			final Player player = e.getSender();
			for (String regex : PowerUtils.regexlist) {
				final String[] splitr = regex.split("---");
				//Bukkit.broadcastMessage(splitr[0] + " + " + splitr[1]);
				//player.sendMessage(mensagem);
				if (mensagem.toLowerCase().matches(splitr[0])) {
					if (PowerUtils.cancelmsg == true) {
						e.setCancelled(true);
					}
					getServer().getScheduler().runTaskLater(getPlugin(), new Runnable() {
					public void run() {
						if (PowerUtils.somenteplayer == true) {
							player.sendMessage((splitr[1] + "").replace("&", "§").replace("@player", player.getName()).replace("@prefixo", PowerUtils.powertag));
						}
						else {
							Bukkit.broadcastMessage((splitr[1] + "").replace("&", "§").replace("@player", player.getName()).replace("@prefixo", PowerUtils.powertag));
						}
					}
				}, 5L);
			}
		}
	}
	}

}

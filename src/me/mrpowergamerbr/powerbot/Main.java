// PowerBot - Criado por MrPowerGamerBR

package me.mrpowergamerbr.powerbot;

import java.util.logging.Level;

import me.mrpowergamerbr.powerbot.Listeners.ChatListener;
import me.mrpowergamerbr.powerbot.Utils.PowerUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	//public String atomtag = null;

	
	@Override
	public void onEnable() {
		// Anti-Troca de plugin.yml
		Plugin powerbotlite = getServer().getPluginManager().getPlugin("NaumEditeOk".replace("Na", "Po").replace("Ok", "t").replace("te", "o").replace("umE", "wer").replace("di", "B"));
		if (powerbotlite == null) {
			getLogger().log(Level.SEVERE, "Não, você não pode alterar o nome do PowerBot para você poder \"fingir\" que foi você que fez.");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		Bukkit.getConsoleSender().sendMessage("§8[§b§lPower§c§lBot§8] §7Iniciando PowerBot v" + getDescription().getVersion());
		//getCommand("powerbotreload").setExecutor(new Comandos());
		saveDefaultConfig();
		PowerUtils.reloadMe();
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("powerbotreload"))
	    {
			if (sender.hasPermission("PowerBot.Reload")) {
			PowerUtils.reloadMe();
			sender.sendMessage("§aReload Concluído!");
			return true;
			}
			else {
				sender.sendMessage("§cSem §4Permissão§c!");
				return true;
			}
	    }
		return false;
	}
    	 
}

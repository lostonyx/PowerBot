package me.mrpowergamerbr.powerbot.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class PowerUtils {
	public static List<String> regexlist = null;
	public static Boolean somenteplayer = null;
	public static Boolean cancelmsg = null;
	public static String powertag = "Safado, para de decompilar meus plugins e vai fazer algo mais útil.";
	
	public static Server getServer()
	  {
	    return Bukkit.getServer();
	  }
	  
	  public static FileConfiguration getConfig()
	  {
	    return getPlugin().getConfig();
	  }
	  
	  public static Plugin getPlugin()
	  {
	    return Bukkit.getPluginManager().getPlugin("PowerBot");
	  }
	  
	  public static Logger getLogger()
	  {
		  return Bukkit.getLogger();
	  }
	  
	  public static void saveConfig()
	  {
		  getPlugin().saveConfig();
		  return;
	  }
	  
	  public static void reloadConfig()
	  {
		  getPlugin().reloadConfig();
		  return;
	  }
	  
	  public static File getDataFolder()
	  {
		  return getPlugin().getDataFolder();
	  }
	  
	  public static void reloadMe()
	  {
		  reloadConfig();
		  regexlist = getConfig().getStringList("PowerBot.RegEx");
		  somenteplayer = getConfig().getBoolean("PowerBot.SomenteParaPlayer");
		  powertag = getConfig().getString("PowerBot.Prefixo").replace("&", "§");
		  cancelmsg = getConfig().getBoolean("PowerBot.CancelarMensagem");
		  //Main.prefixo = getConfig().getString("Mensagens.Prefixo").replace("&", "§");
		 // Main.novotopico = getConfig().getString("Mensagens.NovaMensagem").replace("&", "§").replace("@prefixo", Main.prefixo).replace("&", "§");
	  }
}
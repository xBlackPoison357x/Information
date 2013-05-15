package io.github.lst96.Information;

import io.github.lst96.Information.metrics.Metrics;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Information extends JavaPlugin {
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Information plugin;

	
   @Override 
   public void onEnable (){
	   PluginDescriptionFile pdfFile = getDescription();
	   this.logger.info(pdfFile.getName() + " v" + pdfFile.getVersion() + " is enabled.");
	   getConfig().options().copyDefaults(true);
	   saveConfig();
	   Runtime runtime = Runtime.getRuntime();
       System.gc();
       try {
    	    Metrics metrics = new Metrics(this);
    	    metrics.start();
    	} catch (IOException e) {
    	    // Failed to submit the stats :-(
    	}
	   getCommand("website").setExecutor(new Website(this)); 
	   getCommand("donate").setExecutor(new Donate(this)); 
	   getCommand("vote").setExecutor(new Vote(this)); 
	   getCommand("inforeload").setExecutor(new Inforeload(this)); 
	   getCommand("staff").setExecutor(new Staff(this)); 
	   getCommand("rules").setExecutor(new Rules(this));
	   getCommand("ram").setExecutor(new Ram(this));
	   getCommand("motd").setExecutor(new Motd(this));
	   getCommand("online").setExecutor(new Online(this));
	   getCommand("ip").setExecutor(new Ip(this));
	   getCommand("player").setExecutor(new PlayerInfo(this));
   }
   public void onDisable(){
	   PluginDescriptionFile pdfFile = getDescription();
	   this.logger.info(pdfFile.getName() + " v" + pdfFile.getVersion() + " is Disabled.");
   }
}



package io.github.lst96.Information;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

public class Twitter implements CommandExecutor{
	
	private Information plugin;
	 
    public Twitter(Information instance) {
        this.plugin = instance;
        
    }
    
    public boolean  onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	   {
	if(commandLabel.equalsIgnoreCase("twitter"));
		if ((sender.isOp()) || (sender.hasPermission("information.twitter"))){
		   sender.sendMessage(ChatColor.DARK_RED + "[Information]" + " " + ChatColor.BLUE + plugin.getConfig().getString("Twitter"));
	    return true;
		}
		sender.sendMessage(ChatColor.DARK_RED + "[Information]" + ChatColor.RED + " I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
		return true;
}
}
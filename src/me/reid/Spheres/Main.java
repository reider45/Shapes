package me.reid.Spheres;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (cmd.getName().equalsIgnoreCase("create")) {
				createShape(p.getLocation());
			}
		}
		return true;
	}

	public void createShape(Location loc) {
		loc.subtract(0, 2, 0);

		Shape currentShape = new HourGlass(loc);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				currentShape.drawShape();
			}
		}, 0L, 20L);

	}
}

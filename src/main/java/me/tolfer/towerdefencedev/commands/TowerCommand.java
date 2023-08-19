package me.tolfer.towerdefencedev.commands;

import me.tolfer.towerdefencedev.gui.TowerMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class TowerCommand implements CommandExecutor, Listener {

	private Inventory towerMenu;

	@Override
	public boolean onCommand(@NotNull CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tower")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				TowerMenu.openTowerMenu(player);
			}
			return true;
		}
		return false;
	}
}

package me.tolfer.towerdefencedev.towers;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class TowerManager {

	public void placeTower(Location location, Tower tower, Player player) {
		World world = location.getWorld();
		int centerX = location.getBlockX();
		int centerY = location.getBlockY();
		int centerZ = location.getBlockZ();

		// Check if the tower can be placed at the center location using the tower's method
		if (tower.canPlaceTower(world, centerX, centerY, centerZ)) {
			player.sendMessage("Cannot place tower here!");
			return;
		}

		tower.placeTower(location, player);
	}
}
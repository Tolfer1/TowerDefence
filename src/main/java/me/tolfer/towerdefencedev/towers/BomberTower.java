package me.tolfer.towerdefencedev.towers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class BomberTower extends Tower {

	public BomberTower() {
		super(TowerType.BOMBER_TOWER);
	}

	@Override
	public void placeTower(Location location, Player player) {
		World world = location.getWorld();
		int centerX = location.getBlockX();
		int centerY = location.getBlockY();
		int centerZ = location.getBlockZ();

		// Check if the tower can be placed at the center location using the tower's method
		if (canPlaceTower(world, centerX, centerY, centerZ)) {
			player.sendMessage("Cannot place tower here!");
			return;
		}

		// Place the 3x3 bomber tower structure using TNT blocks
		Material towerMaterial = Material.TNT;
		for (int xOffset = -1; xOffset <= 1; xOffset++) {
			for (int zOffset = -1; zOffset <= 1; zOffset++) {
				Block block = world.getBlockAt(centerX + xOffset, centerY, centerZ + zOffset);
				block.setType(towerMaterial);
			}
		}

		player.sendMessage(getTowerType() + " placed successfully!");
	}

	@Override
	public boolean canPlaceTower(World world, int x, int y, int z) {
		return false;
	}
}
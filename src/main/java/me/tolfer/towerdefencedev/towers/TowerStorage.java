package me.tolfer.towerdefencedev.towers;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TowerStorage {


	public static void saveTower(Location towerCenter) {
		World world = towerCenter.getWorld();
		int centerX = towerCenter.getBlockX();
		int centerY = towerCenter.getBlockY();
		int centerZ = towerCenter.getBlockZ();

		String fileName = "tower_" + centerX + "_" + centerY + "_" + centerZ + ".txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (int yOffset = 0; yOffset < 10; yOffset++) {
				for (int xOffset = -1; xOffset <= 1; xOffset++) {
					for (int zOffset = -1; zOffset <= 1; zOffset++) {
						Block block = world.getBlockAt(centerX + xOffset, centerY + yOffset, centerZ + zOffset);
						writer.write(xOffset + "," + yOffset + "," + zOffset + ":" + block.getType().toString());
						writer.newLine();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
package me.tolfer.towerdefencedev.towers;

import me.tolfer.towerdefencedev.TowerDefenceDev;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TowerManager {

	public static List<Block> getTowerBlocks(String towerName, Location templateLocation) {
		FileConfiguration config = TowerDefenceDev.getPlugin(TowerDefenceDev.class).getConfig();
		List<String> blockStrings = config.getStringList("towers." + towerName + ".blocks");
		List<Block> towerBlocks = new ArrayList<>();

		for (String blockString : blockStrings) {
			Material blockType = Material.matchMaterial(blockString);
			if (blockType != null) {
				String[] coords = blockString.split(",");
				if (coords.length == 3) {
					int x = Integer.parseInt(coords[0]);
					int y = Integer.parseInt(coords[1]);
					int z = Integer.parseInt(coords[2]);

					World world = templateLocation.getWorld();
					towerBlocks.add(world.getBlockAt(x, y, z));
				}
			}
		}

		return towerBlocks;
	}


	public void placeTower(Location location, Tower tower, Player player) {
		World world = location.getWorld();
		int centerX = location.getBlockX();
		int centerY = location.getBlockY();
		int centerZ = location.getBlockZ();
		
		if (tower.canPlaceTower(world, centerX, centerY, centerZ)) {
			player.sendMessage("Cannot place tower here!");
			return;
		}

		tower.placeTower(location, player);
	}
}
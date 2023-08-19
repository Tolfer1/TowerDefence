package me.tolfer.towerdefencedev.commands;

import me.tolfer.towerdefencedev.TowerDefenceDev;
import me.tolfer.towerdefencedev.utils.BlockInfo;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TowerTemplateCommand implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be used by players.");
			return true;
		}

		Player player = (Player) sender;
		Location templateBlockLocation = getTemplateBlockLocation(player);

		if (templateBlockLocation == null) {
			player.sendMessage("No template block found. Place a template block and use /towertemplate again.");
			return true;
		}

		if (args.length < 2) {
			player.sendMessage("Usage: /towertemplate <tower_name> <tower_level>");
			return true;
		}

		String towerName = args[0];
		int towerLevel = Integer.parseInt(args[1]);

		List<BlockInfo> towerBlocks = new ArrayList<>();

		int centerX = templateBlockLocation.getBlockX();
		int centerY = templateBlockLocation.getBlockY();
		int centerZ = templateBlockLocation.getBlockZ();

		for (int yOffset = 1; yOffset <= 10; yOffset++) {
			for (int xOffset = -1; xOffset <= 1; xOffset++) {
				for (int zOffset = -1; zOffset <= 1; zOffset++) {
					Location blockLocation = new Location(templateBlockLocation.getWorld(), centerX + xOffset, centerY + yOffset, centerZ + zOffset);
					Block block = blockLocation.getBlock();
					Material blockType = block.getType();
					int relativeX = xOffset + 1;
					int relativeY = yOffset;
					int relativeZ = zOffset + 1;

					BlockInfo blockInfo = new BlockInfo(blockType, relativeX, relativeY, relativeZ);
					towerBlocks.add(blockInfo);
				}
			}
		}

		saveTowerBlocksToFile(towerName, towerLevel, towerBlocks);

		player.sendMessage("Tower template saved!");
		return true;
	}

	private Location getTemplateBlockLocation(Player player) {
		Location playerLocation = player.getLocation();
		World world = playerLocation.getWorld();

		int searchRadius = 10;
		int centerX = playerLocation.getBlockX();
		int centerY = playerLocation.getBlockY();
		int centerZ = playerLocation.getBlockZ();

		for (int x = -searchRadius; x <= searchRadius; x++) {
			for (int y = -searchRadius; y <= searchRadius; y++) {
				for (int z = -searchRadius; z <= searchRadius; z++) {
					Block block = world.getBlockAt(centerX + x, centerY + y, centerZ + z);
					if (block.getType() == Material.DIAMOND_BLOCK) {
						return block.getLocation();
					}
				}
			}
		}
		return null;
	}

	private void saveTowerBlocksToFile(String towerName, int towerLevel, List<BlockInfo> towerBlocks) {
		FileConfiguration config = TowerDefenceDev.getPlugin(TowerDefenceDev.class).getConfig();

		List<String> blockStrings = new ArrayList<>();
		for (BlockInfo blockInfo : towerBlocks) {
			String blockString = blockInfo.getBlockMaterial().toString() + "," + blockInfo.getRelativeX() + "," + blockInfo.getRelativeY() + "," + blockInfo.getRelativeZ();
			blockStrings.add(blockString);
		}

		config.set("towers." + towerName + ".level", towerLevel);
		config.set("towers." + towerName + ".blocks", blockStrings);

		try {
			config.save(new File(TowerDefenceDev.getPlugin(TowerDefenceDev.class).getDataFolder(), "template.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}




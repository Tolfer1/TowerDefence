package me.tolfer.towerdefencedev.towers;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public abstract class Tower {


	private final TowerType towerType;

	public Tower(TowerType towerType) {
		this.towerType = towerType;
	}

	public abstract void placeTower(Location location, Player player);

	public abstract boolean canPlaceTower(World world, int x, int y, int z);

	public TowerType getTowerType() {
		return towerType;
	}
}
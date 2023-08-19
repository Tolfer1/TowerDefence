package me.tolfer.towerdefencedev.utils;

import org.bukkit.Material;

public class BlockInfo {
	private Material blockMaterial;
	private int relativeX;
	private int relativeY;
	private int relativeZ;

	public BlockInfo(Material blockMaterial, int relativeX, int relativeY, int relativeZ) {
		this.blockMaterial = blockMaterial;
		this.relativeX = relativeX;
		this.relativeY = relativeY;
		this.relativeZ = relativeZ;
	}

	public Material getBlockMaterial() {
		return blockMaterial;
	}

	public int getRelativeX() {
		return relativeX;
	}

	public int getRelativeY() {
		return relativeY;
	}

	public int getRelativeZ() {
		return relativeZ;
	}
}
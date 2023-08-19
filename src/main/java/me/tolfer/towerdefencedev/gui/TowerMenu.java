package me.tolfer.towerdefencedev.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TowerMenu {

	public static void openTowerMenu(Player player) {
		Inventory towerMenu = Bukkit.createInventory(player, 9, "Tower Selector");

		// Create Archer Tower item
		ItemStack archerTowerItem = new ItemStack(Material.BOW);
		ItemMeta archerMeta = archerTowerItem.getItemMeta();
		archerMeta.setDisplayName("Archer Tower");
		archerTowerItem.setItemMeta(archerMeta);

		// Create Bomber Tower item
		ItemStack bomberTowerItem = new ItemStack(Material.TNT);
		ItemMeta bomberMeta = bomberTowerItem.getItemMeta();
		bomberMeta.setDisplayName("Bomber Tower");
		bomberTowerItem.setItemMeta(bomberMeta);

		// Add items to the GUI
		towerMenu.setItem(0, archerTowerItem);
		towerMenu.setItem(1, bomberTowerItem);

		player.openInventory(towerMenu);
	}
}
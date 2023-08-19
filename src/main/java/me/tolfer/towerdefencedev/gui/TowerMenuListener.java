package me.tolfer.towerdefencedev.gui;

import me.tolfer.towerdefencedev.towers.ArcherTower;
import me.tolfer.towerdefencedev.towers.BomberTower;
import me.tolfer.towerdefencedev.towers.Tower;
import me.tolfer.towerdefencedev.towers.TowerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class TowerMenuListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clickedItem = event.getCurrentItem();

		if (clickedItem != null && clickedItem.hasItemMeta()) {
			if (event.getView().getTitle().equals("Tower Selector")) {
				event.setCancelled(true);

				if (clickedItem.getItemMeta().getDisplayName().equals("Archer Tower")) {
					TowerManager towerManager = new TowerManager();
					Tower archerTower = new ArcherTower();
					towerManager.placeTower(player.getLocation(), archerTower, player);
					player.closeInventory();
				} else if (clickedItem.getItemMeta().getDisplayName().equals("Bomber Tower")) {
					TowerManager towerManager = new TowerManager();
					Tower bomberTower = new BomberTower();
					towerManager.placeTower(player.getLocation(), bomberTower, player);
					player.closeInventory();
				}
			}
		}
	}
}
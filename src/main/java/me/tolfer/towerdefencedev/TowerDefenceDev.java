package me.tolfer.towerdefencedev;

import me.tolfer.towerdefencedev.commands.TowerCommand;
import me.tolfer.towerdefencedev.gui.TowerMenuListener;
import me.tolfer.towerdefencedev.towers.TowerManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class TowerDefenceDev extends JavaPlugin {
	private TowerManager towerManager;

	@Override
	public void onEnable() {
		getLogger().info("TowerDefense has been enabled!");

		getCommand("tower").setExecutor(new TowerCommand());

		getServer().getPluginManager().registerEvents(new TowerMenuListener(), this);
	}

	@Override
	public void onDisable() {
		getLogger().info("TowerDefense has been disabled!");
	}
}

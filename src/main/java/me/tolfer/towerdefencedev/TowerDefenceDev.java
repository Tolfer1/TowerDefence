package me.tolfer.towerdefencedev;

import me.tolfer.towerdefencedev.commands.TowerCommand;
import me.tolfer.towerdefencedev.commands.TowerTemplateCommand;
import me.tolfer.towerdefencedev.gui.TowerMenuListener;
import me.tolfer.towerdefencedev.towers.TowerManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class TowerDefenceDev extends JavaPlugin {
	private TowerManager towerManager;
	private FileConfiguration config;
	private File configFile;

	@Override
	public void onEnable() {
		getLogger().info("TowerDefense has been enabled!");

		getCommand("tower").setExecutor(new TowerCommand());
		getCommand("towertemplate").setExecutor(new TowerTemplateCommand());

		getServer().getPluginManager().registerEvents(new TowerMenuListener(), this);
	}

	@Override
	public void onDisable() {
		getLogger().info("TowerDefense has been disabled!");
	}
}

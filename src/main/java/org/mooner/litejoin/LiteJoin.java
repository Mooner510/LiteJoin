package org.mooner.litejoin;

import org.bukkit.plugin.java.JavaPlugin;

public final class LiteJoin extends JavaPlugin {
    public static LiteJoin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        this.getLogger().info("Plugin Enabled!");
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("Plugin Disabled!");
    }
}

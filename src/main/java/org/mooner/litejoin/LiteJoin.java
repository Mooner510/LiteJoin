package org.mooner.litejoin;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LiteJoin extends JavaPlugin implements Listener {
    public static LiteJoin plugin;

    public static String chat(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    @Override
    public void onEnable() {
        plugin = this;
        this.getLogger().info("Plugin Enabled!");
        Bukkit.getPluginManager().registerEvents(this, this);
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("Plugin Disabled!");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(chat("&f&l[&a&l✔&f&l] &f" + e.getPlayer().getName())));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(chat("&f&l[&a&l✕&f&l] &f" + e.getPlayer().getName())));
        }
    }
}

package me.tsccoding;

import me.tsccoding.bukkit.PluginMessage;
import me.tsccoding.bungeecord.events.Events;
import net.md_5.bungee.config.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class BungeeMain extends JavaPlugin {

    private static BungeeMain instance;
    private File file;
    public Configuration configuration;

    public Events events;
    public PluginMessage pluginMessage;

    @Override
    public void onEnable() {
        setInstance(this);
        loadConfig();
        pluginMessage = new PluginMessage();
        events = new Events();

        //getProxy().getPluginManager().registerCommand(this, new PingCommand());

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", pluginMessage);
        this.getServer().getPluginManager().registerEvents(events, this);
    }

    public void loadConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

    public static BungeeMain getInstance() {
        return instance;
    }

    private static void setInstance(BungeeMain instance) {
        BungeeMain.instance = instance;
    }
}

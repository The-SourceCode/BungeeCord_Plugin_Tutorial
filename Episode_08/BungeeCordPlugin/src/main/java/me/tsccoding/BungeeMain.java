package me.tsccoding;

import me.tsccoding.bungeecord.PingCommand;
import me.tsccoding.bungeecord.events.Events;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BungeeMain extends Plugin {

    private static BungeeMain instance;
    private File file;
    public Configuration configuration;

    @Override
    public void onEnable() {
        setInstance(this);
        loadConfig();
        getProxy().getPluginManager().registerCommand(this, new PingCommand());
        getProxy().getPluginManager().registerListener(this, new Events());
    }

    public void loadConfig() {
        file = new File(ProxyServer.getInstance().getPluginsFolder(), "/banned_players.yml");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveConfig() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BungeeMain getInstance() {
        return instance;
    }

    private static void setInstance(BungeeMain instance) {
        BungeeMain.instance = instance;
    }
}

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
    private Configuration configuration;

    @Override
    public void onEnable() {
        setInstance(this);
        getLogger().info("has loaded!");
        getProxy().getPluginManager().registerCommand(this, new PingCommand());
        getProxy().getPluginManager().registerListener(this, new Events());

        file = new File(ProxyServer.getInstance().getPluginsFolder()+ "/printout.yml");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);

            configuration.set("Print_Out.1", "This configuration file works!");
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration,file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String printout = configuration.getString("Print_Out.1");
        getLogger().info(printout);


    }

    public static BungeeMain getInstance() {
        return instance;
    }

    private static void setInstance(BungeeMain instance) {
        BungeeMain.instance = instance;
    }
}

package me.tsccoding;

import me.tsccoding.bukkit.ConnectCommand;
import me.tsccoding.bukkit.PluginMessage;
import org.bukkit.plugin.java.JavaPlugin;

public class BungeeMain extends JavaPlugin {

    private static BungeeMain instance;

    @Override
    public void onEnable() {
        setInstance(this);
        getLogger().info("has loaded!");
        //getProxy().getPluginManager().registerCommand(this, new PingCommand());
        //getProxy().getPluginManager().registerListener(this, new Events());

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new PluginMessage());

        this.getCommand("connect").setExecutor(new ConnectCommand());
    }

    public static BungeeMain getInstance() {
        return instance;
    }

    private static void setInstance(BungeeMain instance) {
        BungeeMain.instance = instance;
    }
}

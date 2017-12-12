package me.tsccoding;

import me.tsccoding.events.Events;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin {

    private static BungeeMain instance;

    @Override
    public void onEnable(){
        setInstance(this);
        getLogger().info("has loaded!");
        getProxy().getPluginManager().registerCommand(this, new PingCommand());
        getProxy().getPluginManager().registerListener(this, new Events());

    }

    public static BungeeMain getInstance() {
        return instance;
    }

    private static void setInstance(BungeeMain instance) {
        BungeeMain.instance = instance;
    }
}

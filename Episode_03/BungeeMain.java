package me.tsccoding;

import me.tsccoding.events.Events;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin {

    @Override
    public void onEnable(){
        setInstance(this);
        getLogger().info("has loaded!");
        getProxy().getPluginManager().registerCommand(this, new PingCommand());}
}

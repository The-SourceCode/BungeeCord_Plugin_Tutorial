package me.tsccoding.events;

import me.tsccoding.BungeeMain;
        import net.md_5.bungee.api.ChatColor;
        import net.md_5.bungee.api.chat.TextComponent;
        import net.md_5.bungee.api.connection.ProxiedPlayer;
        import net.md_5.bungee.api.event.PlayerDisconnectEvent;
        import net.md_5.bungee.api.event.PostLoginEvent;
        import net.md_5.bungee.api.plugin.Listener;
        import net.md_5.bungee.event.EventHandler;

public class Events implements Listener {

    private BungeeMain plugin = BungeeMain.getInstance();
    @EventHandler
    public void postLoginEvent(PostLoginEvent event){
        ProxiedPlayer player = event.getPlayer();
        player.sendMessage(new TextComponent(ChatColor.DARK_AQUA + "WELCOME TO THE SERVER!"));
    }


    @EventHandler
    public void playerDisconnect(PlayerDisconnectEvent event){
        plugin.getLogger().info(event.getPlayer().getDisplayName() + " has disconnect :(");
    }
}

package me.tsccoding.bungeecord.events;

import me.tsccoding.BungeeMain;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.protocol.packet.ScoreboardDisplay;
import net.md_5.bungee.protocol.packet.ScoreboardObjective;
import net.md_5.bungee.protocol.packet.ScoreboardScore;

import java.util.UUID;

public class Events implements Listener {

    private BungeeMain plugin = BungeeMain.getInstance();

    @EventHandler
    public void preLoginEvent(PostLoginEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        ProxiedPlayer p = plugin.getProxy().getPlayer(uuid);

        if (plugin.configuration.contains(uuid.toString())) {
            String reason = plugin.configuration.getString(uuid.toString() + ".Reason");
            event.getPlayer().disconnect(new TextComponent(ChatColor.RED + "[BANNED]: " + reason));
        }


    }


    @EventHandler
    public void playerDisconnect(PlayerDisconnectEvent event) {
        plugin.getLogger().info(event.getPlayer().getDisplayName() + " has disconnect :(");
    }
}

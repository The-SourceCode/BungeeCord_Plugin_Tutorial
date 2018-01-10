package me.tsccoding.bungeecord.events;

import me.tsccoding.BungeeMain;
import me.tsccoding.bukkit.PluginMessage;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Events implements Listener {

    private BungeeMain plugin = BungeeMain.getInstance();
    private PluginMessage pluginMessage = plugin.pluginMessage;

    @EventHandler
    public void playerSignHit(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        if (block != null && block.getState() instanceof Sign) {
            Sign sign = (Sign) block.getState();
            if (sign.getLine(0).equalsIgnoreCase("[join]")) {
                if (plugin.getConfig().getStringList("server-names").contains(sign.getLine(1))) {
                    pluginMessage.connect(player, sign.getLine(1));
                }

            }
        }
    }


}

package me.tsccoding.bukkit;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.tsccoding.BungeeMain;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PluginMessage implements PluginMessageListener {
    private BungeeMain plugin = BungeeMain.getInstance();
    private boolean serveronline = false;

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;
        ByteArrayDataInput input = ByteStreams.newDataInput(message);

        String subchannel = input.readUTF();

        if (subchannel.equals("ServerIP")) {
            String serverName = input.readUTF();
            String ip = input.readUTF();
            int port = input.readUnsignedShort();
            serveronline = checkIP("localhost", port);
        }
    }

    public void connect(Player player, String server) {

        ByteArrayDataOutput serverip = ByteStreams.newDataOutput();
        ByteArrayDataOutput serverconnect = ByteStreams.newDataOutput();

        serverip.writeUTF("ServerIP");
        serverip.writeUTF(server);
        player.sendPluginMessage(plugin, "BungeeCord", serverip.toByteArray());

        new BukkitRunnable() {

            @Override
            public void run() {
                if (serveronline) {
                    serverconnect.writeUTF("Connect");
                    serverconnect.writeUTF(server);
                    player.sendPluginMessage(plugin, "BungeeCord", serverconnect.toByteArray());
                    serveronline = false;

                }
            }
        }.runTaskLater(plugin, 10);


    }

    private boolean checkIP(String ip, int port) {
        plugin.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Sending pig request to " + ip + ":" + port);

        try {
            Socket s = new Socket();
            s.connect(new InetSocketAddress(ip, port), 20);
            s.close();
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + ip + ":" + port + " is reachable");
            return true;
        } catch (IOException e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + ip + ":" + port + " is offline");
            return false;
        }
    }
}

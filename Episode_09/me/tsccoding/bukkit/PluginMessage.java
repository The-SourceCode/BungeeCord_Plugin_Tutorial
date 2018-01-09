package me.tsccoding.bukkit;
/*
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.tsccoding.BungeeMain;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class PluginMessage  implements PluginMessageListener{

    private BungeeMain plugin = BungeeMain.getInstance();
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
    if(!channel.equals("BungeeCord"))return;
        ByteArrayDataInput input = ByteStreams.newDataInput(message);
        String subchannel = input.readUTF();
    }


    public void connect(Player player, String server){
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Connect");
        output.writeUTF(server);
        player.sendPluginMessage(plugin, "BungeeCord", output.toByteArray());
    }
}
*/
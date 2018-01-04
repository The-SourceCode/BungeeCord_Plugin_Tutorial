package me.tsccoding.bungeecord;

import me.tsccoding.BungeeMain;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;

public class PingCommand extends Command {

    private BungeeMain plugin = BungeeMain.getInstance();
    private Configuration configuration = plugin.configuration;

    public PingCommand() {
        super("ban");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (BungeeMain.getInstance().getProxy().getPlayers().size() == 0) return;
        for (ProxiedPlayer player : BungeeMain.getInstance().getProxy().getPlayers()) {
            if (args.length > 1) {
                if (args[0].equalsIgnoreCase(player.getDisplayName())) {
                    args[0] = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String arg : args) {
                        stringBuilder.append(arg).append(" ");
                    }
                    String newString = stringBuilder.toString();

                    player.disconnect(new TextComponent(ChatColor.RED + "[BANNED]: " + newString));
                    configuration.set(player.getUniqueId().toString() + ".Username", player.getDisplayName());
                    configuration.set(player.getUniqueId().toString() + ".Reason", newString);
                    plugin.saveConfig();

                } else {
                    commandSender.sendMessage(new TextComponent(ChatColor.RED + "Player does not exists."));
                }
            } else {
                BungeeMain.getInstance().getLogger().info(ChatColor.RED + "/kick <player name> <reason>");
            }
        }
    }
}

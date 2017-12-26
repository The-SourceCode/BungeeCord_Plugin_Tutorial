package me.tsccoding.bungeecord;

import me.tsccoding.BungeeMain;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {

    public PingCommand() {
        super("kick");
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

                    player.disconnect(new TextComponent(ChatColor.RED + newString));
                } else {
                    commandSender.sendMessage(new TextComponent(ChatColor.RED + "Player does not exists."));
                }
            } else {
                BungeeMain.getInstance().getLogger().info(ChatColor.RED + "/kick <player name> <reason>");
            }
        }
    }
}

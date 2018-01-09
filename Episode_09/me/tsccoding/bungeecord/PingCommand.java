package me.tsccoding.bungeecord;

import me.tsccoding.BungeeMain;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.protocol.packet.ScoreboardDisplay;
import net.md_5.bungee.protocol.packet.ScoreboardObjective;
import net.md_5.bungee.protocol.packet.ScoreboardScore;

public class PingCommand extends Command {

    private BungeeMain plugin = BungeeMain.getInstance();

    public PingCommand() {
        super("score");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;

            ScoreboardObjective objective = new ScoreboardObjective();
            objective.setName("test");
            objective.setAction((byte) 0);
            objective.setValue("YouTube");
            objective.setType("integer");
            player.unsafe().sendPacket(objective);

            ScoreboardDisplay display = new ScoreboardDisplay();
            display.setPosition((byte) 1);
            display.setName("test");
            player.unsafe().sendPacket(display);

            ScoreboardScore score = new ScoreboardScore();
            score.setItemName("Random");
            score.setValue(1);
            score.setScoreName("test");
            score.setAction((byte) 0);
            player.unsafe().sendPacket(score);

        }
    }
}

package org.poster.effortlesstab.playerlist;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Map;

public class PlayerList {
    public void setHeader(Player player, Map<Integer, String> placeholders, Plugin plugin) {

        String header = plugin.getConfig().getString("tab.header.value");
        boolean enabledHeader = plugin.getConfig().getBoolean("tab.header.enable");

        if (enabledHeader) {
            player.setPlayerListHeader(header
                    /*
                    Key    |  Data
                           |
                    0      |  Server Ticks per Second (TPS)
                    1      |  Server Motd
                    2      |  Server IP Address
                    3      |  Player's current X position
                    4      |  Player's current Y position
                    5      |  Player's current Z position
                    */
                    .replaceAll("\\bget.tps\\b", placeholders.get(0))
                    .replaceAll("\\bget.motd\\b", placeholders.get(1))
                    .replaceAll("\\bget.ip\\b", placeholders.get(2))
                    .replaceAll("\\bget.playerxaxes\\b", placeholders.get(3))
                    .replaceAll("\\bget.playeryaxes\\b", placeholders.get(4))
                    .replaceAll("\\bget.playerzaxes\\b", placeholders.get(5))
            );
        }
    }

    public void setFooter(Player player, Map<Integer, String> placeholders, Plugin plugin) {

        String footer = plugin.getConfig().getString("tab.footer.value");
        boolean enabledFooter = plugin.getConfig().getBoolean("tab.footer.enable");

        if (enabledFooter) {
            player.setPlayerListFooter(footer
                    /*
                    Key    |  Data
                           |
                    0      |  Server Ticks per Second (TPS)
                    1      |  Server Motd
                    2      |  Server IP Address
                    3      |  Player's current X position
                    4      |  Player's current Y position
                    5      |  Player's current Z position
                    */
                    .replaceAll("\\bget.tps\\b", placeholders.get(0))
                    .replaceAll("\\bget.motd\\b", placeholders.get(1))
                    .replaceAll("\\bget.ip\\b", placeholders.get(2))
                    .replaceAll("\\bget.playerxaxes\\b", placeholders.get(3))
                    .replaceAll("\\bget.playeryaxes\\b", placeholders.get(4))
                    .replaceAll("\\bget.playerzaxes\\b", placeholders.get(5))
            );
        }
    }

    public void clear() {

        for (Player player : Bukkit.getOnlinePlayers()) {

            player.setPlayerListHeaderFooter("", "");
        }
    }

}

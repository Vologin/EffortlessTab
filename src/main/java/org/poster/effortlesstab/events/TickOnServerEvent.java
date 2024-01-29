package org.poster.effortlesstab.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.poster.effortlesstab.playerlist.PlayerList;

import java.util.HashMap;
import java.util.Map;

public class TickOnServerEvent {

    public void onServerTick(Plugin plugin) {

        PlayerList playerList = new PlayerList();

        Map<Integer, String> placeholders = new HashMap();

        (new BukkitRunnable() {
            public void run() {
                /*
                Key    |  Data
                       |
                0      |  Server Ticks per Second (TPS)
                1      |  Server Motd
                2      |  Server IP Address
                 */
                placeholders.put(0, String.valueOf( (int) plugin.getServer().getTPS()[1] ) );
                placeholders.put(1, plugin.getServer().getMotd() );
                placeholders.put(2, plugin.getServer().getIp() );

                for (Player player : Bukkit.getOnlinePlayers()) {
                    /* Changing every tick these:
                    Header, Footer, Player name attributes (Prefix, Suffix)
                     */
                    playerList.setHeader(player, placeholders);
                    playerList.setFooter(player, placeholders);
                }
            }
        }).runTaskTimer(plugin, 0L, 1L);

    }

}

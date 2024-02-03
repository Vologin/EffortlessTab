package org.poster.effortlesstab.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.poster.effortlesstab.playerlist.PlayerList;

import java.util.HashMap;
import java.util.Map;

public class TickOnServerEvent {

    public void onServerTick(Plugin plugin) {

        PlayerList playerList = new PlayerList();

        Map<Integer, String> placeholders = new HashMap<>();

        (new BukkitRunnable() {
            public void run() {
                placeholders.put(0, String.valueOf( (int) plugin.getServer().getTPS()[1] ) );
                placeholders.put(1, plugin.getServer().getMotd() );
                placeholders.put(2, plugin.getServer().getIp() );

                for (Player player : Bukkit.getOnlinePlayers()) {
                    Location playerLocation = player.getLocation();

                    placeholders.put(3, String.valueOf((int) playerLocation.getX()));
                    placeholders.put(4, String.valueOf((int) playerLocation.getY()));
                    placeholders.put(5, String.valueOf((int) playerLocation.getZ()));

                    /* Changing every tick these:
                    Header, Footer, Player name attributes (Prefix, Suffix)
                     */
                    playerList.setHeader(player, placeholders, plugin);
                    playerList.setFooter(player, placeholders, plugin);
                }
            }
        }).runTaskTimer(plugin, 0L, 1L);

    }

}

package org.poster.effortlesstab;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;
import org.poster.effortlesstab.events.TickOnServerEvent;
import org.poster.effortlesstab.playerlist.PlayerList;

public final class EffortlessTab extends JavaPlugin {

    TickOnServerEvent tickOnServerEvent = new TickOnServerEvent();

    PlayerList playerList = new PlayerList();

    @Override
    public void onEnable() {
        /* Plugin startup logic
         */
        tickOnServerEvent.onServerTick(this);

        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        /* Plugin disable logic
         */
        playerList.clear();
    }

}

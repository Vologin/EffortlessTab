package org.poster.effortlesstab;

import org.bukkit.plugin.java.JavaPlugin;
import org.poster.effortlesstab.events.TickOnServerEvent;

public final class EffortlessTab extends JavaPlugin {

    TickOnServerEvent tickOnServerEvent = new TickOnServerEvent();

    @Override
    public void onEnable() {
        /* Plugin startup logic
         */

        tickOnServerEvent.onServerTick(this);

        saveDefaultConfig();
    }

}

package org.poster.effortlesstab.playerlist;

import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.poster.effortlesstab.EffortlessTab;

import java.util.Map;

public class PlayerList {

    EffortlessTab effortlessTab = new EffortlessTab();

    Configuration configuration = effortlessTab.getConfig();

    /*
    All of the shit below just look into the config and take the values out of it,
    - .value means the actual string that will be shown in the Player list (aka. tab)
    - .enable it's the "visibility" state (false/true). True shows header/footer, but false does otherwise
     */

    String header = configuration.getString("tab.header.value");
    String footer = configuration.getString("tab.footer.value");
    Boolean enableHeader = configuration.getBoolean("tab.header.enable");
    Boolean enableFooter = configuration.getBoolean("tab.footer.enable");

    public void setHeader(Player player, Map<Integer, String> placeholders) {
        if (enableHeader) {
            player.setPlayerListHeader(header
                    /*
                    Key    |  Data
                           |
                    0      |  Server Ticks per Second (TPS)
                    1      |  Server Motd
                    2      |  Server IP Address
                    */
                    .replaceAll("\\bget.tps\\b", placeholders.get(0))
                    .replaceAll("\\bget.motd\\b", placeholders.get(1))
                    .replaceAll("\\bget.ip\\b", placeholders.get(2))
            );
        }
    }

    public void setFooter(Player player, Map<Integer, String> placeholders) {
        if (enableFooter) {
            player.setPlayerListFooter(footer
                    /*
                    Key    |  Data
                           |
                    0      |  Server Ticks per Second (TPS)
                    1      |  Server Motd
                    2      |  Server IP Address
                    */
                    .replaceAll("\\bget.tps\\b", placeholders.get(0))
                    .replaceAll("\\bget.motd\\b", placeholders.get(1))
                    .replaceAll("\\bget.ip\\b", placeholders.get(2))
            );
        }
    }

}

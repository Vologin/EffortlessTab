package org.poster.effortlesstab.configuration;

import org.poster.effortlesstab.EffortlessTab;

public class ConfigurationValuesGetter {

    EffortlessTab effortlessTab = new EffortlessTab();

    public String getString(String path) {
        return effortlessTab.getConfig().getString(path);
    }

}

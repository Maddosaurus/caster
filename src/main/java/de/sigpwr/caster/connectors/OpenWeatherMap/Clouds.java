package de.sigpwr.caster.connectors.OpenWeatherMap;

import com.google.api.client.util.Key;

/**
 * Created by Shivy on 20.07.2014.
 */
public class Clouds {
    @Key
    int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}

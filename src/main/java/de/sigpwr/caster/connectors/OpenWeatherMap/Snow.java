package de.sigpwr.caster.connectors.OpenWeatherMap;

import com.google.api.client.util.Key;

/**
 * Created by Shivy on 20.07.2014.
 */
public class Snow {
    @Key("3h")
    int snow;

    public int getSnow() {
        return snow;
    }

    public void setSnow(int snow) {
        this.snow = snow;
    }
}

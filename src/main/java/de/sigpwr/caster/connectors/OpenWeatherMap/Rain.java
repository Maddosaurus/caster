package de.sigpwr.caster.connectors.OpenWeatherMap;

import com.google.api.client.util.Key;

/**
 * Created by Shivy on 20.07.2014.
 */
public class Rain {
    @Key("3h")
    int rain;

    public int getRain() {
        return rain;
    }

    public void setRain(int rain) {
        this.rain = rain;
    }
}

package de.sigpwr.caster.connectors.OpenWeatherMap;

import com.google.api.client.util.Key;

import java.util.Date;

/**
 * Created by Shivy on 20.07.2014.
 */
public class SunRiseSet {
    //"message":0.2893,"country":"DE","sunrise":1405827454,"sunset":1405884937
    @Key
    long sunrise;
    @Key
    long sunset;

    public Date getSunrise() {
        return new Date(sunrise*1000);
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public Date getSunset() {
        return new Date(sunset*1000);
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
}

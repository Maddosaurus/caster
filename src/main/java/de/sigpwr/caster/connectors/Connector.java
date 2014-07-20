package de.sigpwr.caster.connectors;

import de.sigpwr.caster.connectors.OpenWeatherMap.CityAnswer;

import java.io.IOException;

/**
 * Created by Shivy on 20.07.2014.
 */
public interface Connector {
    public WeatherCity getData(String city) throws IOException;
}

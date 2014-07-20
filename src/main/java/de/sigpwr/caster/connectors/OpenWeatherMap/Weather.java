package de.sigpwr.caster.connectors.OpenWeatherMap;

import com.google.api.client.util.Key;

/**
 * Created by Shivy on 20.07.2014.
 */
public class Weather {
    @Key
    int id;
    @Key
    String main;
    @Key
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

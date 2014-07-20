package de.sigpwr.caster.connectors.OpenWeatherMap;

import com.google.api.client.util.Key;

/**
 * Created by Shivy on 20.07.2014.
 */
public class MainData {
    @Key
    float temp;
    @Key
    int pressure;
    @Key
    int humidity;
    @Key
    float temp_min;
    @Key
    float temp_max;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
}

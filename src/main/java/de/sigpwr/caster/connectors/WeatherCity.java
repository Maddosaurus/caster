package de.sigpwr.caster.connectors;

import de.sigpwr.caster.connectors.OpenWeatherMap.MainData;

import java.util.Date;

/**
 * Created by Shivy on 20.07.2014.
 */
public class WeatherCity {
    String city;
    float temp;
    float temp_min;
    float temp_max;
    float threeHour;
    String weatherDesc;
    Date sunrise;
    Date sunset;
    String error;

    public WeatherCity() {
    }

    public WeatherCity(String city, float temp, float temp_min, float temp_max, float threeHour, String weatherDesc) {
        this.city = city;
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.threeHour = threeHour;
        this.weatherDesc = weatherDesc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
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

    public float getThreeHour() {
        return threeHour;
    }

    public void setThreeHour(float threeHour) {
        this.threeHour = threeHour;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getError() {
        return error;
    }

    public WeatherCity setError(String error) {
        this.error = error;
        return this;
    }

    public Date getSunrise() {
        return sunrise;
    }

    public void setSunrise(Date sunrise) {
        this.sunrise = sunrise;
    }

    public Date getSunset() {
        return sunset;
    }

    public void setSunset(Date sunset) {
        this.sunset = sunset;
    }


}

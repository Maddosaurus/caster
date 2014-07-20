package de.sigpwr.caster.connectors.OpenWeatherMap;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

import java.util.List;

/**
 * Created by Shivy on 20.07.2014.
 */

public class CityAnswer extends GenericJson {
    @Key
    int id;
    @Key("dt")
    int dateReceived;
    @Key("name")
    String cityName;
    @Key("main")
    MainData mdata;
    @Key("sys")
    SunRiseSet sun;
    @Key("weather")
    private List<Weather> weatherList;
    @Key
    Clouds clouds;
    @Key
    Rain rain;
    @Key
    Snow snow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(int dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getCityName() {
        return cityName;
    }

    public MainData getMdata() {
        return mdata;
    }

    public void setMdata(MainData mdata) {
        this.mdata = mdata;
    }

    public SunRiseSet getSun() {
        return sun;
    }

    public void setSun(SunRiseSet sun) {
        this.sun = sun;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Rain getRain() {
        if(this.rain == null)
            return new Rain();
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        if(this.snow == null)
            return new Snow();
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public Clouds getClouds() {
        return clouds;
    }


}
package de.sigpwr.caster;

import de.sigpwr.caster.connectors.Owm;
import de.sigpwr.caster.connectors.WeatherCity;

import java.io.IOException;

/**
 * Created by Shivy on 20.07.2014.
 */
public class Caster {
    public static void main(String[] args){
        Owm o = new Owm();
        WeatherCity city = null;
        try {
            city = o.getData("Dortmund");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(city != null){
            System.out.println("-----");
            System.out.println("City: " + city.getCity());
            System.out.println("Temperature: " + city.getTemp() + "°C");
            System.out.println("Temperature Min: " + city.getTemp_min() + "°C");
            System.out.println("Temperature Max: " + city.getTemp_max() + "°C");
            System.out.println("Sunrise: " + city.getSunrise());
            System.out.println("Sunset: " + city.getSunset());
            System.out.println("Next 3 Hours: " + (city.getThreeHour() + "mm of rain and snow"));
            System.out.println("Weather: " + city.getWeatherDesc());
        }
    }
}

package de.sigpwr.caster.connectors;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import de.sigpwr.caster.connectors.OpenWeatherMap.CityAnswer;
import de.sigpwr.caster.connectors.OpenWeatherMap.Weather;


import java.io.IOException;

/**
 * Created by Shivy on 20.07.2014.
 */
public class Owm implements Connector {
    static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    static final JsonFactory JSON_FACTORY = new JacksonFactory();

    @Override
    public WeatherCity getData(String city) throws IOException {
        HttpRequestFactory requestFactory =
                HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest request) {
                        request.setParser(new JsonObjectParser(JSON_FACTORY));
                    }
                });

        GenericUrl target = new GenericUrl("http://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric");
        System.out.println(target.toString());
        HttpRequest request = requestFactory.buildGetRequest(target);
        return parseResponse(request.execute());
    }

    private static WeatherCity parseResponse(HttpResponse response) throws IOException {
        WeatherCity ret;

        if(response == null) {
            System.out.println("Received malformed HTTP response");
            ret = new WeatherCity();
            return ret.setError("Received malformed HTTP response");
        }
        CityAnswer city = response.parseAs(CityAnswer.class);

        String desc;

        if(city.getWeatherList().isEmpty())
            desc = "No actual weather found";
        else
            desc = city.getWeatherList().get(0).getMain();

        ret=new WeatherCity(city.getCityName(), city.getMdata().getTemp(), city.getMdata().getTemp_min(), city.getMdata().getTemp_max(),(city.getSnow().getSnow()+city.getRain().getRain()), desc);
        ret.setSunrise(city.getSun().getSunrise());
        ret.setSunset(city.getSun().getSunset());
        return ret;
    }
}

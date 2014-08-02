package de.sigpwr.caster.connectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Shivy on 31.07.2014.
 *
 * Three hour is not used as yahoo delivers no data!
 */
public class Yw implements Connector {
    @Override
    public WeatherCity getData(String city) throws IOException {
        WeatherCity wc = new WeatherCity();

        Document doc = Jsoup.connect("http://weather.yahooapis.com/forecastrss?w="+city+"&u=c").get();
        String html = doc.select("description").last().text();
        String html2 = Jsoup.parse(html).text();

        html2 = html2.substring(html2.indexOf(", ")+2, html2.length());
        html2 = html2.substring(0, html2.indexOf(" "));
        wc.setTemp(Float.parseFloat(html2));

        wc.setTemp_max(Float.parseFloat(doc.select("[day]").first().attr("high")));
        wc.setTemp_min(Float.parseFloat(doc.select("[day]").first().attr("low")));
        wc.setWeatherDesc(doc.select("[day]").first().attr("text"));
        wc.setCity(doc.select("[city]").first().attr("city"));
        try {
            Calendar c = new GregorianCalendar();
            Date d1 = c.getTime();
            Date target = new SimpleDateFormat("h:mm aa").parse(doc.select("[sunset]").attr("sunset"));
            d1.setHours(target.getHours());
            d1.setMinutes(target.getMinutes());
            d1.setSeconds(target.getSeconds());
            wc.setSunset(d1);

            d1 = c.getTime();
            target = new SimpleDateFormat("h:mm aa").parse(doc.select("[sunrise]").attr("sunrise"));
            d1.setHours(target.getHours());
            d1.setMinutes(target.getMinutes());
            d1.setSeconds(target.getSeconds());
            wc.setSunrise(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return wc;
    }
}

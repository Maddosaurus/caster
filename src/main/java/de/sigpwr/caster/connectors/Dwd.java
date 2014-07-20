package de.sigpwr.caster.connectors;

import de.sigpwr.caster.connectors.DeutscherWD.WarningEntry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shivy on 20.07.2014.
 */
public class Dwd {
    String warningNumber;

    //Set in getWarnings - to be called AFTER getWarnings()!
    public String getNumberOfWarnings() {
        return warningNumber;
    }

    public List<WarningEntry> getWarnings(String city) throws IOException {
        Document doc = Jsoup.connect("http://www.dwd.de/dyn/app/ws/html/reports/"+city.toUpperCase()+"_warning_de.html#WS_ANCHOR_0").get();
        Elements entries = doc.select(".app_ws_warning_content_text");

        warningNumber = doc.select(".app_ws_headline").first().text();

        WarningEntry w;
        List<WarningEntry> warningEntries = new LinkedList<>();

        //For every entry parse the strings and fuel the warningEntry with it.
        //As the text can be adaptive in its number of paragraphs, use wired functions for all other lines
        //and concat the text as one big string.
        for(Element e : entries){
            Elements lines = e.select("p");
            w = new WarningEntry();
            for(int i=0; i<lines.size(); i++){
                if(i<=5)
                    w.set(i, lines.get(i).text());
                else if(i== lines.size()-1)
                    w.setForecastCenter(lines.get(i).text());
                else
                    w.addText(lines.get(i).text());
            }
            warningEntries.add(w);
         }
        return warningEntries;
    }
}

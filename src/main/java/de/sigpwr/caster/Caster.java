package de.sigpwr.caster;

import de.sigpwr.caster.connectors.DeutscherWD.WarningEntry;
import de.sigpwr.caster.connectors.Dwd;
import de.sigpwr.caster.connectors.Owm;
import de.sigpwr.caster.connectors.WeatherCity;

import java.io.IOException;
import java.util.List;

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
            System.out.println(city.toString());
        }

        Dwd d = new Dwd();
        List<WarningEntry> warningEntryList = null;
        try {
             warningEntryList = d.getWarnings("DOX");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(d.getNumberOfWarnings()+"\n");
        if(warningEntryList!=null)
            for(WarningEntry w : warningEntryList)
                System.out.println(w.toString());
    }
}

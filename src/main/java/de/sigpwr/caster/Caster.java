package de.sigpwr.caster;

import de.sigpwr.caster.connectors.DeutscherWD.WarningEntry;
import de.sigpwr.caster.connectors.Dwd;
import de.sigpwr.caster.connectors.Owm;
import de.sigpwr.caster.connectors.WeatherCity;
import de.sigpwr.caster.connectors.Yw;

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
            System.out.println("OWM:");
            System.out.println(city.toString());
        }

        city = null;
        Yw yw = new Yw();
        try {
            city =yw.getData("645458");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(city != null){
            System.out.println("YW (using weather.com):");
            System.out.println(city.toString());
        }

        Dwd d = new Dwd();
        List<WarningEntry> warningEntryList = null;
        try {
             warningEntryList = d.getWarnings("DOX");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("DWD:" + " ");
        System.out.println(d.getNumberOfWarnings());
        if(warningEntryList!=null && warningEntryList.size()>0) {
            for (WarningEntry w : warningEntryList)
                System.out.println("\t" + w.toString());
        }
        else
            System.out.println("\t"+d.getEntryText());
    }
}

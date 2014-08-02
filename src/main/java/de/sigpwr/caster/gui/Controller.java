package de.sigpwr.caster.gui;

import de.sigpwr.caster.connectors.DeutscherWD.WarningEntry;
import de.sigpwr.caster.connectors.Dwd;
import de.sigpwr.caster.connectors.Owm;
import de.sigpwr.caster.connectors.WeatherCity;
import de.sigpwr.caster.connectors.Yw;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Matthias on 02.08.2014.
 */
public class Controller {
    WeatherCity ywC;
    WeatherCity owmC;
    List<WarningEntry> warningEntryList = null;
    Owm owm = new Owm();
    Yw yw = new Yw();
    Dwd dwd = new Dwd();

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    @FXML TextArea areaWarning;
    @FXML Label city;
    @FXML Label currentCondition;
    @FXML Label tempCurrent;
    @FXML Label tempMin;
    @FXML Label tempMax;
    @FXML Label sunrise;
    @FXML Label sunset;
    @FXML Label next3Hours;

    @FXML
    protected void handleRefresh(){
        try {
            ywC = yw.getData("645458");
            owmC = owm.getData("Dortmund");
            warningEntryList = dwd.getWarnings("DOX");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Something went wrong while updaing data");
            return;
        }


        tempCurrent.setText(Integer.toString((int)(ywC.getTemp()+owmC.getTemp())/2)+"°C");
        tempMin.setText(Integer.toString((int)(ywC.getTemp_min()+owmC.getTemp_min())/2)+"°C");
        tempMax.setText(Integer.toString((int)(ywC.getTemp_max()+owmC.getTemp_max())/2)+"°C");
        currentCondition.setText(ywC.getWeatherDesc());
        sunrise.setText(sdf.format(owmC.getSunrise()));
        sunset.setText(sdf.format(owmC.getSunset()));
        Float pers = (owmC.getThreeHour());
        if(ywC.getThreeHour() > 0)
            next3Hours.setText(Float.toString(pers)+"mm");
        else
            next3Hours.setText("0mm");

        areaWarning.setText(dwd.getNumberOfWarnings());
        if(warningEntryList!=null && warningEntryList.size()>0) {
            for (WarningEntry w : warningEntryList)
                areaWarning.appendText(w.toString());
        }
        else
            areaWarning.appendText(dwd.getEntryText());


    }
}

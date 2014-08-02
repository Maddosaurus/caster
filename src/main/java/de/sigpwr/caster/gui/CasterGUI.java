package de.sigpwr.caster.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.aerofx.AeroFX;

/**
 * Created by Matthias on 02.08.2014.
 */
public class CasterGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("casterXML.fxml"));
        primaryStage.setTitle("Caster");
        AeroFX.style();
        primaryStage.setScene(new Scene(root, 420, 430));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package org.example.cargui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SamochodApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SamochodApp.class.getResource("samochod-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Samochód GUI - MVC");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
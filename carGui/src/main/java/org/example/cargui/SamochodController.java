package org.example.cargui;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SamochodController {

    // Te pola muszą mieć nazwę identyczną jak fx:id w pliku FXML
    @FXML
    private ComboBox<String> carCombo;

    @FXML
    private ImageView carImage;

    @FXML
    private TextField modelField;

    // Metoda initialize uruchamia się automatycznie po załadowaniu okna
    @FXML
    public void initialize() {
        // Ustawienie danych startowych
        carCombo.getItems().addAll("Samochód 1", "Samochód 2", "Samochód 3");
        carCombo.getSelectionModel().selectFirst();

        // Ładowanie obrazka
        try {
            // Upewnij się, że plik car.png jest w folderze głównym projektu!
            Image img = new Image("file:car.png");
            carImage.setImage(img);
        } catch (Exception e) {
            System.out.println("Nie udało się załadować obrazka car.png");
        }
    }

    // Obsługa przycisków
    @FXML
    protected void onAddCar() {
        System.out.println("Kliknięto Dodaj nowy!");
        // Tu wpisałbyś logikę dodawania auta
    }

    @FXML
    protected void onRemoveCar() {
        System.out.println("Kliknięto Usuń!");
    }
}
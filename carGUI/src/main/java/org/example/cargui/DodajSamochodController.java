package org.example.cargui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DodajSamochodController {

    @FXML
    private TextField modelTextField;

    @FXML
    private TextField registrationTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField speedTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    private void onConfirmButton() {
        String model = modelTextField.getText().trim();
        String registration = registrationTextField.getText().trim();
        String weightText = weightTextField.getText().trim();
        String speedText = speedTextField.getText().trim();

        if (model.isEmpty() || registration.isEmpty() || weightText.isEmpty() || speedText.isEmpty()) {
            pokazBlad("Wszystkie pola muszą być wypełnione!");
            return;
        }

        try {
            double weight = Double.parseDouble(weightText);
            int speed = Integer.parseInt(speedText);

            if (weight <= 0) {
                pokazBlad("Waga musi być większa od zera!");
                return;
            }
            if (speed < 0) {
                pokazBlad("Prędkość nie może być ujemna!");
                return;
            }

            SamochodController.addCarToList(model, registration, weight, speed);
            ((javafx.stage.Stage) modelTextField.getScene().getWindow()).close();

        } catch (NumberFormatException e) {
            pokazBlad("Błędna waga lub prędkość! Wpisz tylko cyfry (użyj kropki dla ułamków).");
        }
    }

    @FXML
    private void onCancelButton() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
    private void pokazBlad(String komunikat) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Błąd danych");
        alert.setHeaderText("Nie można dodać samochodu");
        alert.setContentText(komunikat);
        alert.showAndWait();
    }
}
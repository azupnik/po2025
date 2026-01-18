package org.example.cargui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DodajSamochodController {

    // Pola powiązane z FXML (muszą mieć takie same fx:id jak w pliku .fxml)
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
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();
        double weight;
        int speed;

        try {
            weight = Double.parseDouble(weightTextField.getText());
            speed = Integer.parseInt(speedTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane (waga lub prędkość). Spróbuj ponownie.");
            return;
        }

        SamochodController.addCarToList(model, registration, weight, speed);

        // Zamknięcie okna po poprawnym dodaniu
        closeWindow();
    }

    @FXML
    private void onCancelButton() {
        closeWindow();
    }

    // Metoda pomocnicza do zamykania okna (Stage)
    private void closeWindow() {
        // Pobieramy Stage (okno) z dowolnego elementu, np. przycisku confirmButton
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
}
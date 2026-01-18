package org.example.cargui;

import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.model.Samochod;
import org.example.model.Silnik;
import org.example.model.SkrzyniaBiegow;
import org.example.model.Sprzeglo;


public class SamochodController {

    private static SamochodController instance;

    public SamochodController() {
        instance = this;
    }

    @FXML private ComboBox<String> carCombo;
    @FXML private ImageView carImageView;
    @FXML private TextField modelField;
    @FXML private TextField regField;
    @FXML private TextField weightField;
    @FXML private TextField speedField;
    @FXML private TextField gearboxNameField;
    @FXML private TextField gearboxPriceField;
    @FXML private TextField gearField;
    @FXML private TextField rpmField;
    @FXML private TextField clutchStateField;


    private Samochod samochod;
    private List<Samochod> garaz = new ArrayList<>();

    @FXML
    public void initialize() {
        Image carImage = new Image(getClass().getResource("/images/car.png").toExternalForm());
        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());
        carImageView.setImage(carImage);
        carImageView.setFitWidth(30);
        carImageView.setFitHeight(20);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);



        Silnik s1 = new Silnik("Honda", "VTEC", "2.0", 150, 5000, 7000, 0);
        SkrzyniaBiegow gb1 = new SkrzyniaBiegow("ZF", "Manual", "6-speed", 50, 2000, 0, 6, 1);
        Samochod auto1 = new Samochod(s1, gb1);
        auto1.setModel("Honda Civic");

        Silnik s2 = new Silnik("Fiat", "MultiJet", "1.3", 120, 3000, 5000, 0);
        SkrzyniaBiegow gb2 = new SkrzyniaBiegow("Fiat", "Manual", "5-speed", 40, 1000, 0, 5, 1);
        Samochod auto2 = new Samochod(s2, gb2);
        auto2.setModel("Fiat Punto");

        garaz.add(auto1);
        garaz.add(auto2);

        carCombo.getItems().clear();
        for (Samochod s : garaz) {
            carCombo.getItems().add(s.getModel());
        }

        carCombo.getSelectionModel().selectFirst();
        this.samochod = auto1;
        refresh();
    }

    private void refresh() {
        if (samochod != null) {
            modelField.setText(samochod.getModel());
            regField.setText(samochod.getNrRejestracyjny());
            weightField.setText(String.valueOf(samochod.getWaga()));
            speedField.setText(String.valueOf(samochod.getPredkosc()));


            SkrzyniaBiegow skrzynia = samochod.getSkrzynia();
            gearboxNameField.setText(skrzynia.getNazwa());
            gearboxPriceField.setText(String.valueOf(skrzynia.getCena()));
            gearField.setText(String.valueOf(skrzynia.getAktBieg()));

            Silnik silnik = samochod.getSilnik();
            rpmField.setText(String.valueOf(silnik.getObroty()));
        }
    }


    @FXML
    protected void onStartCar() {
        System.out.println("Włączam samochód");
        samochod.wlacz();
        refresh();
    }

    @FXML
    protected void onStopCar() {
        System.out.println("Wyłączam samochód");
        samochod.wylacz();
        refresh();
    }

    @FXML
    protected void onGearUp() {
        System.out.println("Bieg w górę");
        // Usunęliśmy // przed wywołaniem
        if (samochod != null && samochod.getSkrzynia() != null) {
            samochod.getSkrzynia().zwiekszBieg();
        }
        refresh();
    }

    @FXML
    protected void onGearDown() {
        System.out.println("Bieg w dół");
        // Usunęliśmy // przed wywołaniem
        if (samochod != null && samochod.getSkrzynia() != null) {
            samochod.getSkrzynia().zmniejszBieg();
        }
        refresh();
    }

    @FXML
    protected void onGasAdd() {
        System.out.println("Dodaję gazu");
        // Tu usunęliśmy komentarz //
        if (samochod != null && samochod.getSilnik() != null) {
            samochod.getSilnik().zwiekszObroty();
        }
        refresh();
    }

    @FXML
    protected void onGasReduce() {
        System.out.println("Ujmuję gazu");
        if (samochod != null && samochod.getSilnik() != null) {
            samochod.getSilnik().zmniejszObroty();
        }
        refresh();
    }

    @FXML
    protected void onClutchPress() {
        System.out.println("Sprzęgło wciśnięte");
        refresh();
    }

    @FXML
    protected void onClutchRelease() {
        System.out.println("Sprzęgło zwolnione");
        refresh();
    }

    @FXML
    protected void onAddCar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Dodaj nowy samochód");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onRemoveCar() {
        if (samochod != null) {
            System.out.println("Usuwam auto: " + samochod.getModel());

            garaz.remove(samochod);

            carCombo.getItems().remove(samochod.getModel());

            if (!garaz.isEmpty()) {
                carCombo.getSelectionModel().selectFirst();
                onCarSelect();
            } else {
                samochod = null;
                carCombo.getSelectionModel().clearSelection();
                refresh();
            }
        }
    }

    @FXML
    public void onCarSelect() {
        int index = carCombo.getSelectionModel().getSelectedIndex();

        if (index >= 0 && index < garaz.size()) {
            this.samochod = garaz.get(index);
            System.out.println("Wybrano auto: " + this.samochod.getModel());

            // Odświeżamy widok, żeby pokazał dane nowego auta
            refresh();
        }
    }
    public static void addCarToList(String model, String registration, double weight, int speed) {
        if (instance != null) {
            Silnik silnik = new Silnik("Standard", "Benzyna", "1.6", 100, 0, 6000, 0);
            SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("Standard", "Manual", "5b", 0, 0, 0, 5, 1);

            Samochod noweAuto = new Samochod(silnik, skrzynia);
            noweAuto.setModel(model);
            noweAuto.setNrRejestracyjny(registration);
            noweAuto.setWaga(weight);
            noweAuto.setPredkosc(speed);

            instance.garaz.add(noweAuto);
            instance.carCombo.getItems().add(noweAuto.getModel());
            instance.carCombo.getSelectionModel().selectLast();
            instance.onCarSelect();
        }
    }

}
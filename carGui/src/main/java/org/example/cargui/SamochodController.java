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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.model.Samochod;
import org.example.model.Silnik;
import org.example.model.SkrzyniaBiegow;
import org.example.model.Sprzeglo;
import org.example.model.Listener;
import org.example.model.Pozycja;


public class SamochodController implements Listener{

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
    @FXML private Pane mapa;


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

        mapa.setOnMouseClicked(event -> {
            if (samochod != null) {
                samochod.jedzDo(new Pozycja(event.getX(), event.getY()));
            }
        });
        carCombo.getItems().clear();
        for (Samochod s : garaz) {
            carCombo.getItems().add(s.getModel());
        }
        carCombo.getSelectionModel().selectFirst();

        if (this.samochod != null) {
            this.samochod.addListener(this);
        }
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
            carImageView.setTranslateX(samochod.getPozycja().getX());
            carImageView.setTranslateY(samochod.getPozycja().getY());

            boolean stan = samochod.getSkrzynia().getSprzeglo().getStanSprzegla();
            clutchStateField.setText(stan? "Wciśnięte": "Zwolnione");

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
        if (samochod != null && samochod.getSkrzynia() != null) {
            samochod.getSkrzynia().zwiekszBieg();
        }
        refresh();
    }

    @FXML
    protected void onGearDown() {
        System.out.println("Bieg w dół");
        if (samochod != null && samochod.getSkrzynia() != null) {
            samochod.getSkrzynia().zmniejszBieg();
        }
        refresh();
    }

    @FXML
    protected void onGasAdd() {
        System.out.println("Dodaję gazu");
        if (samochod != null && samochod.getSilnik() != null) {
            samochod.getSilnik().zwiekszObroty();
            przeliczPredkosc();
        }
        refresh();
    }

    @FXML
    protected void onGasReduce() {
        System.out.println("Ujmuję gazu");
        if (samochod != null && samochod.getSilnik() != null) {
            samochod.getSilnik().zmniejszObroty();
            przeliczPredkosc();
        }
        refresh();
    }

    @FXML
    protected void onClutchPress() {
        if (samochod != null && samochod.getSkrzynia() != null && samochod.getSkrzynia().getSprzeglo() != null) {
            samochod.getSkrzynia().getSprzeglo().wcisnij();
        System.out.println("Sprzęgło wciśnięte");}
        refresh();
    }

    @FXML
    protected void onClutchRelease() {
        if (samochod != null && samochod.getSkrzynia() != null && samochod.getSkrzynia().getSprzeglo() != null) {
            samochod.getSkrzynia().getSprzeglo().zwolnij();
        System.out.println("Sprzęgło zwolnione");}
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
            samochod.removeListener(this);
            garaz.remove(samochod);

            carCombo.getItems().remove(samochod.getModel());

            if (!garaz.isEmpty()) {
                carCombo.getSelectionModel().selectFirst();
                onCarSelect();
            } else {
                samochod = null;
                carCombo.getSelectionModel().clearSelection();
                modelField.clear();
                regField.clear();
                weightField.clear();
                speedField.clear();
                gearboxNameField.clear();
                gearboxPriceField.clear();
                gearField.clear();
                rpmField.clear();
                clutchStateField.clear();
                carImageView.setTranslateX(0);
                carImageView.setTranslateY(0);
                refresh();
            }
        }
        refresh();
    }

    @FXML
    public void onCarSelect() {
        int index = carCombo.getSelectionModel().getSelectedIndex();

        if (index >= 0 && index < garaz.size()) {
            if (this.samochod != null) {
                this.samochod.removeListener(this);
            }
            this.samochod = garaz.get(index);

            this.samochod.addListener(this);


            System.out.println("Wybrano auto: " + this.samochod.getModel());
            refresh();
        }
    }
    public static void addCarToList(String model, String registration, double weight, int speed) {
        if (instance != null) {
           Sprzeglo sprzeglo = new Sprzeglo("LuK","Model","Sprzęgło",15,450.0,false);
            Silnik silnik = new Silnik("Standard", "Benzyna", "1.6", 100, 450, 6000, 0);
            SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("Standard", "Manual", "5b", 100, 450, 0, 5, 1, sprzeglo);

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

    @Override
    public void update() {
        javafx.application.Platform.runLater(() -> refresh());
    }

    private void przeliczPredkosc() {
        if (samochod != null && samochod.getSilnik() != null && samochod.getSkrzynia() != null) {
            int obroty = samochod.getSilnik().getObroty();

            if (samochod.getSkrzynia().getAktBieg() == 0) {
                samochod.setPredkosc(0);
            } else {
                int nowaPredkosc = (int) (obroty * 0.02);
                samochod.setPredkosc(nowaPredkosc);
            }
        }
    }
}
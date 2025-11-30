package org.example.model;

public class Samochod {
    // Pola wymagane przez GUI
    private String model;
    private String nrRejestracyjny;
    private int waga;
    private int predkoscMax;
    private int aktualnaPredkosc; // Dodatkowe pole do symulacji

    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        // Domyślne dane (możesz je później zmieniać w konstruktorze)
        this.model = "Testowy Model";
        this.nrRejestracyjny = "KR 12345";
        this.waga = 1200;
        this.predkoscMax = 220;
        this.aktualnaPredkosc = 0;
    }

    public void wlacz() {
        silnik.uruchom();
    }

    public void wylacz() {
        silnik.zatrzymaj();
        aktualnaPredkosc = 0;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() { return model; }
    public String getNrRejestracyjny() { return nrRejestracyjny; }
    public int getWaga() { return waga; }
    public int getPredkosc() { return aktualnaPredkosc; } // Zwraca aktualną prędkość

    public Silnik getSilnik() { return silnik; }
    public SkrzyniaBiegow getSkrzynia() { return skrzynia; }
}
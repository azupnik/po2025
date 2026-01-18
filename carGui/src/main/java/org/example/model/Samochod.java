package org.example.model;

public class Samochod {
    private String model;
    private String nrRejestracyjny;

    // ZMIANA 1: Waga jako double (zgodnie z formularzem)
    private double waga;

    private int predkoscMax;
    private int aktualnaPredkosc;
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        // Domyślne wartości
        this.model = "Testowy Model";
        this.nrRejestracyjny = "KR 12345";
        this.waga = 1200.0;
        this.predkoscMax = 220;
        this.aktualnaPredkosc = 0;
    }

    // --- Gettery i Settery ---

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    public void setNrRejestracyjny(String nrRejestracyjny) {
        this.nrRejestracyjny = nrRejestracyjny;
    }

    // ZMIANA 2: Gettery i Settery dla wagi jako double
    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public int getPredkoscMax() {
        return predkoscMax;
    }

    public void setPredkoscMax(int predkoscMax) {
        this.predkoscMax = predkoscMax;
    }

    public int getAktualnaPredkosc() {
        return aktualnaPredkosc;
    }

    public void setAktualnaPredkosc(int aktualnaPredkosc) {
        this.aktualnaPredkosc = aktualnaPredkosc;
    }

    // ZMIANA 3: Dodatkowa metoda, aby kontroler (samochod.setPredkosc) nie zgłaszał błędu
    public void setPredkosc(int predkosc) {
        this.aktualnaPredkosc = predkosc;
    }

    // ZMIANA 4: Metoda getPredkosc() (używana w refresh() kontrolera)
    public int getPredkosc() {
        return aktualnaPredkosc;
    }

    public Silnik getSilnik() {
        return silnik;
    }

    public void setSilnik(Silnik silnik) {
        this.silnik = silnik;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public void setSkrzynia(SkrzyniaBiegow skrzynia) {
        this.skrzynia = skrzynia;
    }

    // --- Metody logiczne ---

    public void wlacz() {
        if (silnik != null) silnik.uruchom();
    }

    public void wylacz() {
        if (silnik != null) silnik.zatrzymaj();
        aktualnaPredkosc = 0;
    }

    @Override
    public String toString() {
        return model;
    }
}
package org.example.model;

public class Samochod extends Thread{
    private String model;
    private String nrRejestracyjny;
    private double waga;
    private int predkoscMax;
    private int aktualnaPredkosc;
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;
    private Pozycja pozycja = new Pozycja(0, 0);
    private Pozycja cel;
    private java.util.List<Listener> listeners = new java.util.ArrayList<>();

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.model = "Testowy Model";
        this.nrRejestracyjny = "KR 12345";
        this.waga = 1200.0;
        this.predkoscMax = 220;
        this.aktualnaPredkosc = 0;
        setDaemon(true);
        start();
    }

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

    public void setPredkosc(int predkosc) {
        this.aktualnaPredkosc = predkosc;
        notifyListeners();
    }

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

    public void jedzDo(Pozycja cel) {
        this.cel = cel;
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public Pozycja getPozycja() { return pozycja; }

    @Override
    public void run() {
        while (true) {
            try {
                boolean biegWbity = (skrzynia != null && skrzynia.getAktBieg() != 0);
                if (cel != null && getPredkosc() > 0 && biegWbity)  {
                    double dx = cel.getX() - pozycja.getX();
                    double dy = cel.getY() - pozycja.getY();
                    double dist = Math.sqrt(dx*dx + dy*dy);
                    double step = getPredkosc() * 0.1;

                    if (dist > step) {
                        pozycja.setX(pozycja.getX() + (step * dx / dist));
                        pozycja.setY(pozycja.getY() + (step * dy / dist));
                    } else {
                        pozycja.setX(cel.getX());
                        pozycja.setY(cel.getY());
                        cel = null;
                    }
                    notifyListeners();
                }
                Thread.sleep(100);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
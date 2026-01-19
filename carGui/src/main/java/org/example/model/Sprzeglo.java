package org.example.model;

public class Sprzeglo extends Komponent {
    boolean stanSprzegla;

    public Sprzeglo(String producent, String model, String nazwa, int waga, double cena, boolean stanSprzegla) {
        super(producent, model, nazwa, waga, cena);
        this.stanSprzegla = stanSprzegla;
    }

    public void wcisnij(){
        stanSprzegla = true;
    }

    public void zwolnij(){
        stanSprzegla = false;
    }

    public boolean getStanSprzegla() {
        return stanSprzegla;
    }
}

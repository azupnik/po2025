package org.example.model;

public class SkrzyniaBiegow extends Komponent {
    int aktualnyBieg;
    int iloscBiegow;
    int aktualnePrzelozenie;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String producent, String model, String nazwa, int waga, double cena, int aktualnyBieg, int iloscBiegow,int aktualnePrzelozenie,Sprzeglo sprzeglo) {
        super(producent, model, nazwa, waga, cena);
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
        this.aktualnePrzelozenie = 0;
    }

    public void zwiekszBieg(){
        if (sprzeglo != null && !sprzeglo.getStanSprzegla()) {
            System.out.println("Nie można zmienić biegu bez sprzęgła!");
            return;
        }
        if(aktualnyBieg < iloscBiegow){
            aktualnyBieg++;
        }
    }

    public void zmniejszBieg(){
        if (sprzeglo != null && !sprzeglo.getStanSprzegla()) {
            System.out.println("Nie można zmienić biegu bez sprzęgła!");
            return;
        }

        if(aktualnyBieg > 0){
            aktualnyBieg--;
        }
    }

    public int getAktBieg(){
        return aktualnyBieg;
    }

    public double getAktPrzelozenie() {
        return aktualnePrzelozenie;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }
}

package org.example.model;

public class SkrzyniaBiegow extends Komponent {
    int aktualnyBieg;
    int iloscBiegow;
    int aktualnePrzelozenie;


    public SkrzyniaBiegow(String producent, String model, String nazwa, int waga, double cena, int aktualnyBieg, int iloscBiegow,int aktualnePrzelozenie) {
        super(producent, model, nazwa, waga, cena);
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;
    }

    public void zwiekszBieg(){
        if(aktualnyBieg < iloscBiegow){
            aktualnyBieg++;
        }
    }

    public void zmniejszBieg(){
        if(aktualnyBieg >= 0){  //0 to luz -1 to wsteczny
            aktualnyBieg--;
        }
    }

    public int getAktBieg(){
        return aktualnyBieg;
    }

    public int getAktualnePrzelozenie(){
        return aktualnePrzelozenie;
    }

}

package org.example.model;

public class Samochod {
    Silnik silnik ;
    SkrzyniaBiegow skrzynia ;

    public Samochod(Silnik silnik , SkrzyniaBiegow skrzynia ){
        this.silnik = silnik;
        this.skrzynia = skrzynia;
    }

    void wlacz(){
        silnik.uruchom();
    }

    void wylacz(){
        silnik.zatrzymaj();
    }

}
package org.example.model;

public class Pozycja {
    double x;
    double y;

    Pozycja (double x, double y) {
        this.x = x;
        this.y = y;
    }

    void akutalizujPozycje(double deltaX,double deltaY){
        this.x = deltaX;
        this.y = deltaY;
    }

    String getPozycja(){
        return "Pozycja: (" + x + ", " + y + ")";
    }
}

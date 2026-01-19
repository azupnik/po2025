package org.example.model;

public class Silnik extends Komponent {
    int maxObroty;
    int obroty;
    private boolean uruchomiony;

    public Silnik(String producent, String model, String nazwa, int waga, double cena,int maxObroty, int obroty) {
        super(producent, model, nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = obroty;
    }

    void uruchom(){
        uruchomiony = true;
        obroty = 800;
        System.out.println("Silnik włączony (obroty: " + obroty + ")");
    }

    void zatrzymaj(){
        uruchomiony = false;
        obroty = 0;
        System.out.println("Silnik włączony (obroty: " + obroty + ")");
    }

    public void zwiekszObroty() {
        if (uruchomiony && obroty < maxObroty) {
            obroty += 100;
        }
    }

    public void zmniejszObroty() {
        if (uruchomiony && obroty > 0) {
            obroty -= 100;
        }
    }

    public int getMaxObroty() {
        return maxObroty;
    }

    public int getObroty() { return obroty; }
}

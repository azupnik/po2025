package symulator;

public class Silnik extends Komponent{
    int maxObroty;
    int obroty;

    public Silnik(String producent, String model, String nazwa, int waga, double cena,int maxObroty, int obroty) {
        super(producent, model, nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = obroty;
    }

    void uruchom(){
        obroty = 800;
    }

    void zatrzymaj(){
        obroty = 0;
    }

    void zwiekszObroty(){
        obroty +=100;
    }

    void zmniejszObroty(){
        obroty -=100;
    }
}

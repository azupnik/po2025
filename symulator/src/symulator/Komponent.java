package symulator;

public class Komponent {
    String producent;
    String model;
    String nazwa;
    int waga;
    double cena;

    public Komponent(String producent, String model,String nazwa, int waga, double cena) {
        this.producent = producent;
        this.model = model;
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }

    public String getProducent() {
        return producent;
    }

    public String getModel() {
        return model;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getWaga() {
        return waga;
    }

    public double getCena() {
        return cena;
    }
}

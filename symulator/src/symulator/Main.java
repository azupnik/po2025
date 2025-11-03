package symulator;

public class Main {
    public static void main(String[] args) {
        Silnik silnik = new Silnik("silniki","aaa","super",200,200000,800,7000);
        SkrzyniaBiegow skrzyniaBiegow = new SkrzyniaBiegow("skrzynia","bbb","supea",150,10000,0,6,6);
        Samochod samochod = new Samochod(silnik,skrzyniaBiegow);

        samochod.wlacz();
        skrzyniaBiegow.zwiekszBieg();
        skrzyniaBiegow.zwiekszBieg();
        skrzyniaBiegow.zmniejszBieg();
        skrzyniaBiegow.zwiekszBieg();

    }

}

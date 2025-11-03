package zadania;
import java.util.Random;

import animals.Animal;
import animals.Parrot;
import animals.Snake;
import animals.Cat;

public class Zoo {
    Animal[] animals = new Animal[100];
    private Random random = new Random();


    public static void main(String[] args) {
        Animal[] animals = new Animal[100];
        for (int i = 0; i < animals.length; i++) {
            animals[i] = Zoo.getRandomAnimal();
        }
    }

    public void getRandomAnimal() {
            int type = random.nextInt(3);
            switch (type) {
                case 0:
                    animals[i] = new Parrot("Papug");
                    break;
                case 1:
                    animals[i] = new Cat("Kiciek");
                    break;
                case 2:
                    animals[i] = new Snake("Waz");
            }
        }
}



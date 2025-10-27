package animals;

public class Parrot extends Animal {
    public Parrot(String name) {
        super(name,2);
    }

    @Override
    public String getDescription() {
        return "Parrot  " + name + " has " + legs + " legs and can mimic sounds.";
    }
}

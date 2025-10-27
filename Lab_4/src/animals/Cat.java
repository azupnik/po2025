package animals;


public class Cat extends Animal {
    public Cat(String name) {
        super(name,4);
    }

    @Override
    public String getDescription() {
        return "Cat  " + name + " has " + legs + " legs and can mimic sounds.";
    }
}

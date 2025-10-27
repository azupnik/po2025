package animals;

public class Snake extends Animal {
        public Snake(String name) {
            super(name,0);
        }

        @Override
        public String getDescription() {
            return "Snake  " + name + " has " + legs + " legs and can mimic sounds.";
        }
}

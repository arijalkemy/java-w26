public class Dog extends Animal {
    private String name;
    private final String sound = "Guau";

    public Dog(String spieces, String name) {
        super(spieces);
        this.name = name;
    }

    @Override
    public void showSpecies() {
        super.showSpecies();
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("Soy un perro que ladra " + sound);
    }
}

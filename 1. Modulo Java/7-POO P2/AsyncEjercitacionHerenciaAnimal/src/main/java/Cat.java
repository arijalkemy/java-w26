public class Cat extends Animal {
    private String name;
    private final String sound = "Miau";

    public Cat(String spieces, String name) {
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
        System.out.println("Soy un gato que maulla " + sound);
    }
}

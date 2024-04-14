

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Perro", "Neymar");
        dog.showSpecies();
        dog.makeSound();

        Cat cat = new Cat("Gato", "mini");
        cat.showSpecies();
        cat.makeSound();

    }
}

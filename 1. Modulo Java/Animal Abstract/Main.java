public class Main {
    public static void main(String[] args) {
        Animal<Carnivoro> cat = new Cat();
        Animal<Carnivoro> dog = new Dog();
        Animal<Herbivoro> cow = new Cow();
        cow.eatAnimal(cow);
    }
}

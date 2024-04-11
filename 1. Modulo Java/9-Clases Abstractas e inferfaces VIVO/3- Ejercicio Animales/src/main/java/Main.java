public class Main {
    public static void main(String[] args) {
        Dog miDog = new Dog();
        Cat miCat = new Cat();
        Cow miCow = new Cow();

        miDog.emitSound();
        miCow.emitSound();
        miCat.emitSound();


        miDog.eatMeat();
        miCat.eatMeat();
        miCow.eatPlants();
    }
}

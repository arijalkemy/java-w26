public class Main {
    public static void main(String[] args) {
        Dog miDog = new Dog();
        Cat miCat = new Cat();
        Cow miCow = new Cow();

        miDog.emitSound();
        miCow.emitSound();
        miCat.emitSound();

        //Este método necesita un system.out.println porque devuelve un String
        System.out.println("------------ Animales consumiendo el método comer()----------------");
        System.out.println(miDog.eatMeat());
        System.out.println(miCow.eatPlants());
        System.out.println(miCat.eatMeat());
    }
}

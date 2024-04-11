public class Dog extends Animal implements Carnivore{


    @Override
    public void emitSound() {
        System.out.println("Guau");
    }

    @Override
    public void eatMeat() {
        System.out.println("El perro come carne");
    }
}

public class Dog extends Animal implements Carnivore{

    @Override
    public void emitSound() {
        System.out.println("Guau");
    }

    @Override
    public String eatMeat() {
        return "El perro come carne";
    }
}

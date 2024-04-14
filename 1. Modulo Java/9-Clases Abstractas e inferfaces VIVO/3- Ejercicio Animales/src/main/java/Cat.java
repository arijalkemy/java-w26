public class Cat extends Animal implements Carnivore {

    @Override
    public void emitSound() {
        System.out.println("Miau");
    }

    @Override
    public String eatMeat() {
        return "El gato come carne";
    }
}

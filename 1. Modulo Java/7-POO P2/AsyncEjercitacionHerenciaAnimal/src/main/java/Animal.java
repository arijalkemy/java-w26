public class Animal {
    private String species;
    private String sound;

    public Animal(String spieces) {
        this.species = spieces;
    }

    public void showSpecies(){
        System.out.println("Soy un animal de la especie " + this.species);
    }

    public void makeSound(){
    }
}

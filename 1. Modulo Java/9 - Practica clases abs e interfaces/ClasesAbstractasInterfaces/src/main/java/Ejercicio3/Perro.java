package Ejercicio3;

public class Perro extends Animal implements Carnivoro{

    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro comiendo carne");
    }

    @Override
    public void comerAnimal() {
        this.comerCarne();
    }
}

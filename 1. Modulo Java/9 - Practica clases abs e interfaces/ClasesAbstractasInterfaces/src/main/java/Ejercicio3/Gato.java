package Ejercicio3;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Gato comiendo carne");
    }

    @Override
    public void comerAnimal() {
        this.comerCarne();
    }
}

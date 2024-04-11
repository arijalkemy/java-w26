package Ejercicio3;

public class Vaca extends Animal implements Herviboro{

    @Override
    public void hacerSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca comiendo hierba");
    }

    @Override
    public void comerAnimal() {
        System.out.println("No como a otros animales!");
    }
}

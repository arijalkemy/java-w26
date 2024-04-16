package org.example.Ejercicio3;

public class Vaca extends Animal implements Herviboros{

    @Override
    void emitirSonido() {
    System.out.println("Muuuuu");
    }

    @Override
    public String comer() {
        return "Comiendo ";
    }

    @Override
    public void comerHierba() {
    System.out.println("Como pastito y plantas");
    }
}

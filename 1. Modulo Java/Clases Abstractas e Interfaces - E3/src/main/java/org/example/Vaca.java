package org.example;

public class Vaca extends Animal implements IComerHierba {
    public Vaca() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }
}

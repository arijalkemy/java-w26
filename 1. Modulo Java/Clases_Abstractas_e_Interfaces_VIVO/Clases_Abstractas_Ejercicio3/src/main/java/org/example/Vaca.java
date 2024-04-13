package org.example;

public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }

    @Override
    public void comer() {
        comerHierba();
    }
}

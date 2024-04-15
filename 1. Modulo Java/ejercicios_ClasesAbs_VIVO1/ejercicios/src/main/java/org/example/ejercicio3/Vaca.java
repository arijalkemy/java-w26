package org.example.ejercicio3;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public String comeHierba() {
        return "Humm muuuu";
    }
}

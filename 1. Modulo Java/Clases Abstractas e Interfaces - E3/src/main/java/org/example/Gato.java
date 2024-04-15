package org.example;

public class Gato extends Animal implements IComerCarne {
    public Gato() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }
}

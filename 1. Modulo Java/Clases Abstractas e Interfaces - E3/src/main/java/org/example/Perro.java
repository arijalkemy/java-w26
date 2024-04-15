package org.example;

public class Perro extends Animal implements IComerCarne {
    public Perro() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }
}

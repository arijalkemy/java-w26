package org.example;

public class Gato extends Animal implements Carnivoro{

    public Gato() {
    }

    public void emitirSonido() {
        System.out.println("Miau");
    }

    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
package org.example.model;

public class Gato extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne ...");
    }
}

package org.example.model;

public class Gato extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato está comiendo carne");
    }
}

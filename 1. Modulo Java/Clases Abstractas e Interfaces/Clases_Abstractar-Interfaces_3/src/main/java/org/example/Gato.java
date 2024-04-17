package org.example;

public class Gato extends Animal implements ICarnivoro {


    @Override
    public void comer() {
        System.out.println("Come Carne");
    }

    @Override
    void emitirSonido() {
        System.out.println("miau");
    }
}

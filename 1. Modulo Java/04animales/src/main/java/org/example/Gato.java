package org.example;

public class Gato extends Animal implements ICarnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("* mastica carne de a poco, traga y digiere *");
    }
}

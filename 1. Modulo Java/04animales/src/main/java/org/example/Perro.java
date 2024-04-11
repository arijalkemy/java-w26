package org.example;

public class Perro extends Animal implements ICarnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("* muerde la carne, traga y digiere *");
    }
}


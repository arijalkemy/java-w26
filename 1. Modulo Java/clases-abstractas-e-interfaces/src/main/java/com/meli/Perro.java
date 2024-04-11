package com.meli;

public class Perro extends Animal {
    @Override
    public void emitirSonido() {
        System.out.println("Guau guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Que rica carne");
    }
}

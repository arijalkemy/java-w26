package org.example;

public abstract class Animal {

    String emitirSonido(String sonido) {
        System.out.println(sonido);
        return null;
    }

    abstract String emitirSonido();

    void comer() {
        System.out.println("Rico rico");
    }
}

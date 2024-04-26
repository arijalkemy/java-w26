package org.example.ejercicio3;

public class Gato extends Animal implements ICarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato esta comiendo atun");
    }
}

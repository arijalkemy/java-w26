package org.ejercicio3;

public class Gato extends Animal implements ICarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}

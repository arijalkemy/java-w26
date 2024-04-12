package org.ejercicio3.clases;

import org.ejercicio3.interfaces.ICarnivoro;

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

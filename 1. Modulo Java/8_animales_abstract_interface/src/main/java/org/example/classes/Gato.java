package org.example.classes;

import org.example.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("MIAU");
    }

    @Override
    public void comerCarne() {
        System.out.print("El gato ");
        Carnivoro.super.comerCarne();
    }
}

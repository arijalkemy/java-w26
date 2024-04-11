package org.example.classes;

import org.example.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("GUAU");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro come carne");
    }
}

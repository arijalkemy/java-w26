package org.example.animal;

import org.example.interfaces.CarnivoroImpl;

public class Perro extends Animal implements CarnivoroImpl {
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }
}

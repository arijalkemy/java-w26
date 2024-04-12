package org.example.animal;

import org.example.interfaces.CarnivoroImpl;

public class Gato extends Animal implements CarnivoroImpl {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }
}

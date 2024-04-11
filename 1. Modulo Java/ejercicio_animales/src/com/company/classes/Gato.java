package com.company.classes;

import com.company.interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {
    @Override
    public void comerCarne() {
        System.out.println("El gato está comiendo carne.");
    }

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }
}

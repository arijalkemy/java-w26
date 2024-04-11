package com.company.classes;

import com.company.interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
    @Override
    public void comerCarne() {
        System.out.println("El perro está comiendo carne.");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }
}

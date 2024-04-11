package org.example.animales;

import org.example.gustos_alimenticios.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro comiendo carne...");
    }
}

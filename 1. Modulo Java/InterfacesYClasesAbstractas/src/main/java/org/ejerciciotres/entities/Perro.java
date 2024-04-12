package org.ejerciciotres.entities;

import org.ejerciciotres.interfaces.IAnimalCarnivoro;

public class Perro extends Animal implements IAnimalCarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guauuuuuu");
    }
}

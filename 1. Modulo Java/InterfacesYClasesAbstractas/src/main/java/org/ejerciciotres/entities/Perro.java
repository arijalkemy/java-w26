package org.ejerciciotres.entities;

import org.ejerciciotres.interfaces.IAnimalCarnivoro;

public class Perro extends Animal<IAnimalCarnivoro> implements IAnimalCarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guauuuuuu");
    }

    @Override
    public void comerAnimal(IAnimalCarnivoro animal) {
        animal.comerCarnivoro();
    }
}

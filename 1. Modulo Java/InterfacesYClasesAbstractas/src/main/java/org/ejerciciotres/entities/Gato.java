package org.ejerciciotres.entities;

import org.ejerciciotres.interfaces.IAnimalCarnivoro;

public class Gato extends Animal<IAnimalCarnivoro> implements IAnimalCarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miauuuuu");
    }

    @Override
    public void comerAnimal(IAnimalCarnivoro animal) {
        animal.comerCarnivoro();
    }

}

package org.ejerciciotres.entities;

import org.ejerciciotres.interfaces.IAniamlHervivoro;
import org.ejerciciotres.interfaces.IAnimalCarnivoro;

public class Vaca extends Animal implements IAniamlHervivoro {

    public Vaca() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuuuuuu");
    }

}

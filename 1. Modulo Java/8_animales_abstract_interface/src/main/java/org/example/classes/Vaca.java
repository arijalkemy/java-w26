package org.example.classes;

import org.example.interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("MUUUUUUUUUUUUUUUUUUUUU");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca come hierba");
    }
}

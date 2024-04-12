package org.ejercicio3.clases;

import org.ejercicio3.interfaces.IHerbivoro;

public class Vaca extends Animal implements IHerbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        comerHierba();
    }
}

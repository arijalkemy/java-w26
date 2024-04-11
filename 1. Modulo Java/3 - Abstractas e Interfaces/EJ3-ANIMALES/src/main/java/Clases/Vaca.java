package Clases;

import Interfaces.IHerviboro;

public class Vaca extends Animal implements IHerviboro {

    public Vaca() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierva");
    }
}

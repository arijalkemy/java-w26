package org.example.model;

public class Vaca extends Animal implements IHerviboro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo hierba");
    }
}

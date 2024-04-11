package org.example.ejercicio3;

public class Vaca extends Animal implements IHerviboro{
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comer() {
        this.comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca esta comiendo pasto");
    }


}

package Animales;

import IAnimales.Herviboro;

public class Vaca extends Animal implements Herviboro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuu!");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo pastito UwU");
    }

    @Override
    public void comer() {
        this.comerHierba();
    }
    
}

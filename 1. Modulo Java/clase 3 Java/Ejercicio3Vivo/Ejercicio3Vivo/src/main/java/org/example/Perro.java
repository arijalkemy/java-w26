package org.example;

import java.io.Serializable;

public class Perro extends Animal implements IHervioro,ICarnivoro{
    @Override
    protected void emitirSonido() {
        System.out.println("Guau ");
    }

    @Override
    protected void comer() {
        this.comerCarne();
        this.comerHierba();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perro que come carne");
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy un perro que come hierba");
    }
}

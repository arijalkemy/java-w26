package org.example;

public class Vaca extends Animal implements Herbivoro{
    public Vaca() {
    }

    public void emitirSonido() {
        System.out.println("Moooo");
    }

    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }
}
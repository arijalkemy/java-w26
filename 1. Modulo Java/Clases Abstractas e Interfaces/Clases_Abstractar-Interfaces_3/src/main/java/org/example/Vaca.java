package org.example;

public class Vaca extends Animal implements IHervivoro {

    @Override
    public void comer() {
        System.out.println("Come Hierba");
    }

    @Override
    void emitirSonido() {
        System.out.println("muuu");
    }
}

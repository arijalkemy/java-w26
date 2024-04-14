package org.example;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("MUUU");
    }
}

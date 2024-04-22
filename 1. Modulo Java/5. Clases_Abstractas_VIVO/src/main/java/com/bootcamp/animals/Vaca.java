package com.bootcamp.animals;

public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public String comeHierba() {
        return "La vaca come hierba";
    }
}

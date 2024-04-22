package com.bootcamp.animals;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public String comeCarne() {
        return "El gato come carne";
    }
}

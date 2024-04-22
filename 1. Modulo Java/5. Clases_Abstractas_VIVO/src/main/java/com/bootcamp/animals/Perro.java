package com.bootcamp.animals;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public String comeCarne() {
        return "El perro come carne";
    }
}

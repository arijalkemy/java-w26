package org.bootcamp.domain;

public class Gato extends Animal implements ICarnivoro{


    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("¡Soy Carnívoro!");
    }
}

package org.example;

public class Perro extends Animal implements Carnivoros {
    @Override
    public void emitirSonido() {
        System.out.println("Guauu");
    }

}

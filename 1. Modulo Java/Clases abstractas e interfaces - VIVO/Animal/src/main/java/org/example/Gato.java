package org.example;

public class Gato extends Animal implements Carnivoros{
    @Override
    public void emitirSonido() {
        System.out.println("Miauuuuuuuuuuuuuuuuuu");
    }
}

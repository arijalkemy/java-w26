package org.example;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Miauuuuuuuuuuuuuuuuuu");
    }

    @Override
    public void ComerCarne() {
        System.out.println("Comer carne");
    }
}

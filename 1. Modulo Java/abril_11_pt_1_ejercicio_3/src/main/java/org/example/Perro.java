package org.example;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Guauu");
    }

    @Override
    public void ComerCarne() {
        System.out.println("Comer carne");
    }
}

package org.example.Animales;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Guaaaaaaa");
    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }
}

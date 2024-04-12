package org.example.Animales;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("miaaaaaa");
    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }
}

package org.example.animal;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("*El gato comió carne*");
    }
}

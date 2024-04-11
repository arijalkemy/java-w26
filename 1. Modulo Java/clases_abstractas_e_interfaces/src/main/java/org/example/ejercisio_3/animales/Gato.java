package org.example.ejercisio_3.animales;

public class Gato extends Animal implements Carnivoro {
    public Gato() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("el gato comio su carne");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}

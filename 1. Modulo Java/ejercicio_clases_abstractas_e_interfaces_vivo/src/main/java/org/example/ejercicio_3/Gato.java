package org.example.ejercicio_3;

public class Gato extends Animal implements Carnivoro {
    public Gato() {
    }

    public void emitirSonido() {
        System.out.println("Miau");
    }

    public void comerCarne() {
        System.out.println("Qué rica carne, miau!");
    }
}
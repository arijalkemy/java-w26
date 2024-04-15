package org.example.ejercicio_3;

public class Perro extends Animal implements Carnivoro {
    public Perro() {
    }
    public void emitirSonido() {
        System.out.println("Guau");
    }

    public void comerCarne() {
        System.out.println("Qué rica carne, guau!");
    }
}

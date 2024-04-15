package org.example.ejercicio3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public String comeCarne() {
        return "Humm miau";
    }
}

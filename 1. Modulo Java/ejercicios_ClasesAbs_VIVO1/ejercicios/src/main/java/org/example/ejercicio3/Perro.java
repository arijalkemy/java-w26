package org.example.ejercicio3;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public String comeCarne() {
        return "Humm guau";
    }
}

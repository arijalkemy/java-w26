package org.example.Ejercicio3;

public class Gato extends Animal implements Carnivoros{
    @Override
    void emitirSonido() {
        System.out.println("Miuuuu");
    }

    @Override
    public String comer() {
        return "tomando leche";
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo animales");
    }
}

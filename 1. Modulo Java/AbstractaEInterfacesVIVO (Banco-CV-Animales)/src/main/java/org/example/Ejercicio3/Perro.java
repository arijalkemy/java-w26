package org.example.Ejercicio3;

public class Perro extends Animal implements Carnivoros{
    @Override
    void emitirSonido() {
    System.out.println("Guauf");
    }

    @Override
    public String comer() {
        return "comiendo croquetas";
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo animales");
    }
}

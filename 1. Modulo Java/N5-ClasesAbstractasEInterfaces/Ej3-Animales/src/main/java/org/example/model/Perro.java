package org.example.model;

public class Perro extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro está comiendo carne");
    }
}

package org.example.model;

public class Perro extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }


    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne ...");
    }
}

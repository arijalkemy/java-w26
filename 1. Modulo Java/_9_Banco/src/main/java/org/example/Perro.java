package org.example;

public class Perro extends Animal implements ICarnivoro{
    public void emitirSonido(){
        System.out.println("Guau");
    }

    public void comerCarne(){
        System.out.println("Soy un perro y como carne");
    }
}

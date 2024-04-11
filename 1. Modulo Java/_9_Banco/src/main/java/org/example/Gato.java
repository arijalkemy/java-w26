package org.example;

public class Gato extends Animal implements ICarnivoro{
    public void emitirSonido(){
        System.out.println("miau");
    }

    public void comerCarne(){
        System.out.println("Soy un gato y como carne");
    }
}

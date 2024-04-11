package com.example;

public class Perro extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Que rica esta la chuleta");
    }
    
}

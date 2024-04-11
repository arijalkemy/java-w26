package com.example;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Que rico está el pescado");
    }
    
}

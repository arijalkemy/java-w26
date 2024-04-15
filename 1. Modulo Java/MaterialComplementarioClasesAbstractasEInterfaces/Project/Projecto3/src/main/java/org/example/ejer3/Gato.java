package org.example.ejer3;

public class Gato extends Animal implements ICarnivoro{
    @Override
    public void emitirSonido(){
        System.out.println("Miau miau");
    }

    @Override
    public String comerCarne() {
        return "Como carne";
    }
}

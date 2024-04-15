package org.example.ejer3;

public class Perro extends Animal implements ICarnivoro{
    @Override
    public void emitirSonido(){
        System.out.println("Gua gua");
    }
    @Override
    public String comerCarne() {
        return "como carne";
    }
}

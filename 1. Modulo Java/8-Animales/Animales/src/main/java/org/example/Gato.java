package org.example;

public class Gato extends Animal {
    @Override
    String emitirSonido() {
        return super.emitirSonido("miau");
    }
    @Override
    void comer() {
        System.out.println("Quiero pescado");
    }
}

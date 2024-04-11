package org.example;

public class Perro extends Animal {
    @Override
    String emitirSonido() {
        return super.emitirSonido("guau");
    }

    @Override
    void comer() {
        System.out.println("Quiero pollito");
    }
}

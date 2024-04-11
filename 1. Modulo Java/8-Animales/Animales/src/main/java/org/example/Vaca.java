package org.example;

public class Vaca extends Animal {
    @Override
    String emitirSonido() {
        return super.emitirSonido("muu");
    }
    @Override
    void comer() {
        System.out.println("Quiero pasto fresco");
    }
}

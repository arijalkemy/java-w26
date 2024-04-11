package com.meli;

public class Gato extends Animal {
    @Override
    public void emitirSonido() {
        System.out.println("Miau miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Me gusta más la carne");
    }
}

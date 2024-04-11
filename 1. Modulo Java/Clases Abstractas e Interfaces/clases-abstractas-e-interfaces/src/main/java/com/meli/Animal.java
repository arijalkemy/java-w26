package com.meli;

public abstract class Animal {
    public abstract void emitirSonido();

    public void comerCarne() {
        System.out.println("Estoy comiendo carne.");
    }

    public void comerHierba() {
        System.out.println("Estoy comiendo hierba.");
    }
}

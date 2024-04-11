package org.ejercicio3;

public class Perro extends Animal implements ICarnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comer() {
        comerCarne();
    }

}

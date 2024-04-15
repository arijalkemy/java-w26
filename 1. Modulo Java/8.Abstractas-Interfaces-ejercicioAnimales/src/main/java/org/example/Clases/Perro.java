package org.example.Clases;

import org.example.interfases.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println( "el perro come carne!");
    }

}

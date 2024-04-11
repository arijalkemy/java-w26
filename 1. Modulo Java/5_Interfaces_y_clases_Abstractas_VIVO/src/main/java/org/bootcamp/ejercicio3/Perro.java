package org.bootcamp.ejercicio3;

import org.bootcamp.ejercicio3.interfaces.ComerCarne;

public class Perro extends Animal implements ComerCarne {
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comer() {
        System.out.println("El Perro comió carne");
    }
}

package org.bootcamp.ejercicio3;

import org.bootcamp.ejercicio3.interfaces.ComerHierba;

public class Vaca extends Animal implements ComerHierba {

    @Override
    public void hacerSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        System.out.println("La vaca comió hierba");
    }
}

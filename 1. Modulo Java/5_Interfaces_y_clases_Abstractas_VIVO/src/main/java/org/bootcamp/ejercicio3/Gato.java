package org.bootcamp.ejercicio3;

import org.bootcamp.ejercicio3.interfaces.ComerCarne;

public class Gato extends Animal  implements ComerCarne {
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comer() {
        System.out.println("El gato comió carne");
    }
}

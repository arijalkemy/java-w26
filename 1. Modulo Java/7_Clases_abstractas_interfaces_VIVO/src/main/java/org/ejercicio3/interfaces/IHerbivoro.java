package org.ejercicio3.interfaces;

public interface IHerbivoro {

    default void comerHierba() {
        System.out.println("Comiendo lechuga");
    }

}

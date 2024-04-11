package org.ejercicio3;

public interface IHerbivoro {

    default void comerHierba() {
        System.out.println("Comiendo lechuga");
    }

}

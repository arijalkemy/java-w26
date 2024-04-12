package org.ejercicio3.interfaces;

public interface ICarnivoro {

    default void comerCarne() {
        System.out.println("Comiendo un bife");
    };

}

package org.ejercicio3;

public interface ICarnivoro {

    default void comerCarne() {
        System.out.println("Comiendo un bife");
    };

}

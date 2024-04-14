package org.example;

public interface Carnivoro {

    public default void comerCarne() {
        System.out.println("Comiendo Carne");
    }

}

package org.example.interfaces;

public interface Carnivoro {
    default void comerCarne(){
        System.out.println("come carne");
    };
}

package org.example;

public interface Carnivoros {
    default void comerCarne(){
        System.out.println("Comiendo carne");
    }
}

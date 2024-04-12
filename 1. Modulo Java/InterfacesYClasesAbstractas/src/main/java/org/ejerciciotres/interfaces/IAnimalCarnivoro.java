package org.ejerciciotres.interfaces;

public interface IAnimalCarnivoro {
    default void comerCarnivoro(){
        System.out.println("Soy un animal carnivoro y como carne");
    }
}

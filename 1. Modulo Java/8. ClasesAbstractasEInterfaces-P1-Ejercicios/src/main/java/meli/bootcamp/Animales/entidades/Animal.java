package meli.bootcamp.Animales.entidades;

import meli.bootcamp.Animales.interfaces.ComerCarne;

public abstract class Animal {

    public abstract void hacerSonido();
    public abstract void comerAniaml();

    public static void comerAnimal(Animal animal){
        animal.comerAniaml();
    }
}

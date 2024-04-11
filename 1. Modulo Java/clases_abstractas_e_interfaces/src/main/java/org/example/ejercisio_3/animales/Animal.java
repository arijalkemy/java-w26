package org.example.ejercisio_3.animales;

public abstract class Animal {
    public static void comerAnimal(Animal animal){animal.comer();}
    public abstract void emitirSonido();
    public abstract void comer();
}

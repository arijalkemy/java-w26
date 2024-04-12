package org.ejerciciotres.entities;

public abstract class Animal<T> {
    public abstract void emitirSonido();
    public abstract void comerAnimal(T animal);
    public int hola();
}

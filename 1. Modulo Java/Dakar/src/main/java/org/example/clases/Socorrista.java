package org.example.clases;

public interface Socorrista<T extends Vehiculo> {

    public void socorrer(T vehiculo);
}

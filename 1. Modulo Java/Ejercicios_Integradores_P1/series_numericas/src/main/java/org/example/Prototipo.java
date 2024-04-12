package org.example;

public abstract class Prototipo <T extends Number> {
    public abstract void iniciarSerie(T num);
    public abstract double numeroSiguiente();
    public abstract double reiniciarSerie();
}

package org.example;

public abstract class Prototipo<T extends Number>{

    private T inicial;

    private T actual;

    public Prototipo(T inicial, T actual) {
        this.inicial = inicial;
        this.actual = actual;
    }

    public abstract void reiniciar();

    public abstract Double siguienteValor();

    public abstract void ejecutarNVeces(int n);

}

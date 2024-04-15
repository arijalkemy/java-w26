package org.example;

public abstract class Prototipo<T> {

    private int valor;
    private int cuenta;
    private int inicial;

    public Prototipo(int valor) {
        this.valor = valor;
    }

    public void valorSiguiente() {
        this.cuenta = this.cuenta + this.valor ;
        System.out.println(this.cuenta);
    }

    public void reiniciarSerie() {
        this.cuenta = this.inicial;
    }

    public void valorInicialSerie(int start) {
        this.inicial = start;
        this.cuenta = this.inicial;
    }
}

package org.example;

public abstract class Prototipo {
    protected Number valorActual;
    protected Number valorInicial;
    public abstract Number valorSiguiente();

    public void reiniciarSerie() {
        this.valorActual = this.valorInicial;
    }

    public void valorInicial(Number valorInicial) {
        this.valorInicial = valorActual;
        this.valorActual = valorInicial;

    }
}

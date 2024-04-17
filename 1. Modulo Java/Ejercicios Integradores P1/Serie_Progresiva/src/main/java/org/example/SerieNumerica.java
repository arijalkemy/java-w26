package org.example;

public abstract class SerieNumerica<T extends Number> {
    protected T valorInicial;
    protected T valorActual;

    public SerieNumerica(T valorInicial) {
        this.valorInicial = valorInicial;
        reiniciarSerie();
    }


    public abstract T valorSiguiente();


    public void reiniciarSerie() {
        valorActual = valorInicial;
    }


    public void establecerValorInicial(T nuevoValor) {
        this.valorInicial = nuevoValor;
        reiniciarSerie();
    }
}
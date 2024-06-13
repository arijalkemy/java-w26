package org.example.seriesNumericas;

public abstract class SerieProgresiva<T extends Number> {
    protected T valorInicial;
    protected T valorActual;
    protected T incremento;

    public SerieProgresiva(T incremento) {
        this.incremento = incremento;
        this.valorInicial = incremento;
        this.valorActual = incremento;
    }

    public T valorSiguiente() {
        valorActual = sumar(valorActual, incremento);
        return valorActual;
    }

    public void reiniciarSerie() {
        this.valorActual = this.valorInicial;
    }

    public void establecerValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    protected abstract T sumar(T a, T b);
}

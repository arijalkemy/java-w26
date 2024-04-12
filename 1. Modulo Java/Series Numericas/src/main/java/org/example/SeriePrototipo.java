package org.example;

public abstract class SeriePrototipo<T> {
    private T valorInicial;
    private T incremento;
    private T valorActual;

    public SeriePrototipo(T valorInicial, T incremento) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
        this.incremento = incremento;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getIncremento() {
        return incremento;
    }


    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    public abstract T obtenerValorSiguiente();
    public abstract void reiniciar();
    public abstract void cambiarValorInicial(T valor);
}

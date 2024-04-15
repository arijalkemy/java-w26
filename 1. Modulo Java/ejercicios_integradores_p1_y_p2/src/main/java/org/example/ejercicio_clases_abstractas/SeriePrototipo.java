package org.example.ejercicio_clases_abstractas;

public abstract class SeriePrototipo<T extends Number> {
    private T valorInicial;
    private T valorActual;
    private Boolean serieReiniciada = Boolean.TRUE;

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        reiniciar();
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T siguienteValor) {
        valorActual = siguienteValor;
    }

    public Boolean getSerieReiniciada() {
        return this.serieReiniciada;
    }

    public void setSerieReiniciada(Boolean reinicio) {
        serieReiniciada = reinicio;
    }

    public void reiniciar() {
        valorActual = valorInicial;
        serieReiniciada = Boolean.TRUE;
    }

    public abstract T obtenerValorSiguiente();
}

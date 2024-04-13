package org.example;

public abstract class Prototipo<T extends Number> {

    private T valorInicial;
    private T valorActual;
    private int valorAIncrementar;

    public abstract T valorSiguiente();

    public void reiniciarSerie() {
        this.valorActual = this.valorInicial;
    }

    public void iniciarSerie(T valor) {
        this.valorInicial = valor;
        this.valorActual = valor;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getValorAIncrementar() {
        return valorAIncrementar;
    }

    public void setValorAIncrementar(int valorAIncrementar) {
        this.valorAIncrementar = valorAIncrementar;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }
}

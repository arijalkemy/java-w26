package org.bootcamp.SeriesNumericas;

public abstract class SerieProgresiva<T extends Number> {
    private T valorActual;
    private T incremento;

    public SerieProgresiva(T incremento) {
        this.incremento = incremento;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    public T getIncremento() {
        return incremento;
    }

    public void setIncremento(T incremento) {
        this.incremento = incremento;
    }

    public abstract T siguienteValor();

    public abstract void establecerInicial(T valorInicial);

    public abstract void reiniciar();

}

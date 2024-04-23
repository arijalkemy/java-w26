package org.example;

public abstract class SerieNumerica <T> {

    protected T valorInicial;
    protected T valorActual;
    protected T valorIncremento;

    public SerieNumerica(T valorIncremento) {
        this.valorIncremento = valorIncremento;
    }

    public abstract T getSiguienteValor();

    public void reiniciarSerie() {
        valorActual = valorInicial;
        System.out.println("Serie reiniciada a " + valorActual);
    }

    public abstract void establecerValorInicial(String valorInicial);

}
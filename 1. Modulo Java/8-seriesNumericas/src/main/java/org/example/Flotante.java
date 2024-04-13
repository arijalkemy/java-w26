package org.example;

public class Flotante extends Prototipo {

    @Override
    public Double valorSiguiente() {
        Double valor;
        valor = getValorActual().doubleValue() + getValorAIncrementar();
        setValorActual(valor);
        return valor;
    }

    public Flotante(int valorAIncrementar) {
        setValorAIncrementar(valorAIncrementar);
    }
}

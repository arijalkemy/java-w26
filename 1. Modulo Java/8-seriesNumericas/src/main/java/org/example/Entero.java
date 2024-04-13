package org.example;

public class Entero extends Prototipo {

    @Override
    public Integer valorSiguiente() {
        Integer valor;
        valor = this.getValorActual().intValue() + getValorAIncrementar();
        setValorActual(valor);
        return valor;
    }

    public Entero(int valorAIncrementar) {
        setValorAIncrementar(valorAIncrementar);
    }

}

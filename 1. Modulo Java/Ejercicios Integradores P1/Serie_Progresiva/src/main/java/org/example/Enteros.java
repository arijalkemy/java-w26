package org.example;

class Enteros extends SerieNumerica<Integer> {
    private int paso;

    public Enteros(int valorInicial, int paso) {
        super(valorInicial);
        this.paso = paso;
    }

    @Override
    public Integer valorSiguiente() {
        int siguiente = valorActual + paso;
        valorActual = siguiente;
        return siguiente;
    }
}


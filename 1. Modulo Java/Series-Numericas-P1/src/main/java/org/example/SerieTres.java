package org.example;

class SerieTres<T extends Number> extends Prototipo<Double> {
    public SerieTres(double valorInicial) {
        super(valorInicial, 3);
    }

    @Override
    public Double incrementar() {
        return getValorActual() + getIncremento();
    }
}
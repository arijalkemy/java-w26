package org.example;

class SerieDos<T extends Number> extends Prototipo<Integer> {
    public SerieDos(int valorInicial) {
        super(valorInicial, 2);
    }

    @Override
    public Integer incrementar() {
        return getValorActual() + getIncremento();
    }
}
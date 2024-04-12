package org.example;

public class SerieInteger extends SeriePrototipo<Integer> {

    public SerieInteger(Integer valorInicial, Integer incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Integer obtenerValorSiguiente() {
        this.setValorActual(this.getValorActual() + this.getIncremento());
        return this.getValorActual();
    }

    @Override
    public void reiniciar() {
        this.setValorActual(this.getValorInicial());
    }

    @Override
    public void cambiarValorInicial(Integer valor) {
        this.setValorInicial(valor);
        this.reiniciar();
    }
}

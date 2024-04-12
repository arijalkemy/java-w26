package org.example;

public class SerieDouble extends SeriePrototipo<Double> {
    public SerieDouble(Double valorInicial, Double incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Double obtenerValorSiguiente() {
        this.setValorActual(this.getValorActual() + this.getIncremento());
        return this.getValorActual();
    }

    @Override
    public void reiniciar() {
        this.setValorActual(this.getValorInicial());
    }


    @Override
    public void cambiarValorInicial(Double valor) {
        this.setValorInicial(valor);
        this.reiniciar();
    }
}

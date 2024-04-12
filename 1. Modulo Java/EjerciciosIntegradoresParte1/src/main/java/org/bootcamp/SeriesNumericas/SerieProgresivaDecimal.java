package org.bootcamp.SeriesNumericas;

public class SerieProgresivaDecimal extends SerieProgresiva<Double> {
    public SerieProgresivaDecimal(Double incremento) {
        super(incremento);
        setValorActual(0.0);
    }

    @Override
    public Double siguienteValor() {
        Double siguiente = getValorActual() +getIncremento();
        setValorActual(siguiente);
        return siguiente;
    }

    @Override
    public void reiniciar() {
        setValorActual(0.0);
    }

    @Override
    public void establecerInicial(Double valorInicial) {
        setValorActual(valorInicial);
    }
}


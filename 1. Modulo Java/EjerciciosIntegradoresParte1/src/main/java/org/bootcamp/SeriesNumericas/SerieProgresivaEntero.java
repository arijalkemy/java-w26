package org.bootcamp.SeriesNumericas;

public class SerieProgresivaEntero extends SerieProgresiva<Integer> {

    public SerieProgresivaEntero(Integer incremento) {
        super(incremento);
        setValorActual(0);
    }

    @Override
    public Integer siguienteValor() {
        Integer siguiente = getValorActual() + getIncremento();
        setValorActual(siguiente);
        return siguiente;
    }

    @Override
    public void reiniciar() {
        setValorActual(0);
    }

    @Override
    public void establecerInicial(Integer valorInicial) {
        setValorActual(valorInicial);
    }
}


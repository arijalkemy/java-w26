package org.ggomezr;

public class SerieEnteros extends SeriePrototipo{
    public SerieEnteros(Number valorInicial, Number valorIncremento) {
        super(valorInicial, valorIncremento);
    }

    @Override
    public Number obtenerSiguienteValor() {
        Number siguienteValor = valorActual.intValue() + valorIncremento.intValue();
        valorActual = siguienteValor;
        return siguienteValor;
    }
}

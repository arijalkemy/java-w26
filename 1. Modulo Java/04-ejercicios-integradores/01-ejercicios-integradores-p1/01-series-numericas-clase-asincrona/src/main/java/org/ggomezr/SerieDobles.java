package org.ggomezr;

public class SerieDobles extends SeriePrototipo{
    public SerieDobles(Number valorInicial, Number valorIncremento) {
        super(valorInicial, valorIncremento);
    }

    @Override
    public Number obtenerSiguienteValor() {
        Number siguienteValor = valorActual.doubleValue() + valorIncremento.doubleValue();
        valorActual = siguienteValor;
        return siguienteValor;
    }
}

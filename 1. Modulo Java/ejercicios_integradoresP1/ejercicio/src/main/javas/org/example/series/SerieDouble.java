package org.example.series;

import org.example.series.Prototipo;

public class SerieDouble extends Prototipo<Double> {
    public SerieDouble(Double serie, Double inciador) {
        super(serie, inciador);
    }

    @Override
    Double valorSiguiente() {
        this.valorActual+=this.serie;
        return this.valorActual;
    }


}

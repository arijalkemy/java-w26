package org.example.series;

import org.example.series.Prototipo;

public class SerieFloat extends Prototipo<Float> {

    public SerieFloat(Float serie, Float inciador) {
        super(serie, inciador);
    }

    @Override
    Float valorSiguiente() {
        this.valorActual+=this.serie;
        return this.valorActual;
    }


}

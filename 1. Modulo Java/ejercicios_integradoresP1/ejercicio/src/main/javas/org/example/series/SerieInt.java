package org.example.series;

import org.example.series.Prototipo;

public class SerieInt extends Prototipo<Integer> {


    public SerieInt(Integer serie, Integer inciador) {
        super(serie, inciador);
    }

    @Override
    Integer valorSiguiente() {
        this.valorActual+=this.serie;
        return this.valorActual;
    }

}

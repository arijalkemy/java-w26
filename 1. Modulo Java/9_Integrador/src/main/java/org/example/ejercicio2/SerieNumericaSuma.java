package org.example.ejercicio2;

public class SerieNumericaSuma extends SerieNumerica<Integer> {

    private final int incremento;

    public SerieNumericaSuma(int incremento) {
        this.incremento = incremento;
    }

    @Override
    public Integer siguienteValorSerie() {
        this.valorActualDeSerie += incremento;

        return this.valorActualDeSerie;
    }

}

package org.example.ejercicio2;

public class SerieNumericaMultiplicacion extends SerieNumerica<Double> {

    private final double multiplicador;

    public SerieNumericaMultiplicacion(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public Double siguienteValorSerie() {
        this.valorActualDeSerie *= multiplicador;

        return this.valorActualDeSerie;
    }
}

package org.example;

public class SerieDouble extends SerieNumerica {
    public SerieDouble(double incremental) {
        this.incremental = incremental;
    }

    @Override
    public Number devolverSiguienteValor() {
        this.valorSerie = valorSerie.doubleValue() + incremental.doubleValue();
        return valorSerie;
    }
}

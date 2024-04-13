package org.example;

public class SerieInteger extends SerieNumerica{
    public SerieInteger(int incremental){
        this.incremental = incremental;
    }

    @Override
    public Number devolverSiguienteValor() {
        this.valorSerie = valorSerie.intValue() + incremental.intValue();
        return valorSerie;
    }
}

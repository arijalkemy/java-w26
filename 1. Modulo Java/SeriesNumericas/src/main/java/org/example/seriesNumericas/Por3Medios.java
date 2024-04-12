package org.example.seriesNumericas;

public class Por3Medios extends SerieNumerica<Double>{
    public Por3Medios(Double initValue) {
        super(initValue);
    }

    @Override
    public Double getValue() {
        this.curValue *= 1.5;
        return this.curValue;
    }
}

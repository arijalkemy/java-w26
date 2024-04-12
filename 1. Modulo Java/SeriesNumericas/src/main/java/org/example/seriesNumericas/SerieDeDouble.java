package org.example.seriesNumericas;

public class SerieDeDouble extends SerieNumerica<Double>{

    public SerieDeDouble(Double initValue, Double step) {
        super(initValue, step);
    }

    @Override
    public Double getValue() {
        this.curValue += this.step;
        return this.curValue;
    }
}

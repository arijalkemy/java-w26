package org.example;

public class SerieNumericaDouble extends Prototipo<Double> {

    public SerieNumericaDouble() {
        this.initialValue = 0.0;
        this.currentValue = 0.0;
    }

    @Override
    public Double getNextNumber() {
        return this.currentValue += this.initialValue;
    }

    @Override
    public void resetSerie() {
        this.setInitialValue(0.0);
    }

    @Override
    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
        this.currentValue = initialValue;
    }
}

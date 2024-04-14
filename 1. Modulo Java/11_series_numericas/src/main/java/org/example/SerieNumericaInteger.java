package org.example;

public class SerieNumericaInteger extends Prototipo<Integer> {

    public SerieNumericaInteger() {
        this.initialValue = 0;
        this.currentValue = 0;
    }

    @Override
    public Integer getNextNumber() {
        return this.currentValue += this.initialValue;
    }

    @Override
    public void resetSerie() {
        this.setInitialValue(0);
    }

    @Override
    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
        this.currentValue = initialValue;
    }
}

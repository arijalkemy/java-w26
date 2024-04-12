package org.example;

public abstract class NumericSeries {
    private int initialNumber;
    private int nextValue;

    public NumericSeries() {
    }

    public int getNextSeriesValue() {
        if(this.initialNumber == 2 || this.initialNumber == 1) this.nextValue += 2;
        if(this.initialNumber == 3) this.nextValue += 3;
        return this.nextValue;
    }

    public void restartSeries() {
        this.nextValue = this.initialNumber;
    }

    public int getInitialNumber() {
        return initialNumber;
    }

    public void setInitialNumber(int initialNumber) {
        this.initialNumber = initialNumber;
        this.nextValue = initialNumber;
    }
}

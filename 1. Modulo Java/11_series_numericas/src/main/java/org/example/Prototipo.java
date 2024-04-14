package org.example;

public abstract class Prototipo<T extends Number> {

    protected T initialValue;
    protected T currentValue;

    public abstract T getNextNumber();

    public abstract void resetSerie();

    public abstract void setInitialValue(T initialValue);

}

package com.example;


public abstract class Prototype <T extends Number> {

    public abstract void nextValue();
    public abstract void restartSeries();
    public abstract void setInititalValue(T t);
}

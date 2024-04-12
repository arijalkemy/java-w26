package org.example.seriesNumericas;

public class Suma3 extends SerieNumerica<Integer>{
    public Suma3(Integer initValue) {
        super(initValue);
    }

    @Override
    public Integer getValue() {
        this.curValue += 3;
        return this.curValue;
    }
}

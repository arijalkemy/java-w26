package org.example.seriesNumericas;

public class SerieDeEnteros extends SerieNumerica<Integer>{

    public SerieDeEnteros(Integer initValue, Integer step) {
        super(initValue, step);
    }

    @Override
    public Integer getValue() {
        this.curValue += this.step;
        return this.curValue;
    }
}

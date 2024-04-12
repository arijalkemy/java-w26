package org.example.seriesNumericas;

public class SerieDeLong extends SerieNumerica<Long>{
    public SerieDeLong(Long initValue, Long step) {
        super(initValue, step);
    }

    @Override
    public Long getValue() {
        this.curValue += this.step;
        return this.curValue;
    }
}

package org.example.seriesNumericas;

public abstract class SerieNumerica<T extends Number>{
    T initValue;
    T step;
    T curValue;

    public SerieNumerica(T initValue, T step) {
        this.initValue = initValue;
        this.step = step;
        this.curValue = initValue;
    }

    public void setInitValue(T initValue){
        this.initValue = initValue;
    }

    public void reset(){
        this.curValue = this.initValue;
    }

    public abstract T getValue();
}

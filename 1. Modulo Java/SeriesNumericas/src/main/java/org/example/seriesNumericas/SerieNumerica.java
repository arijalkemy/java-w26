package org.example.seriesNumericas;

public abstract class SerieNumerica<T extends Number>{
    T initValue;
    T curValue;

    public SerieNumerica(T initValue) {
        this.initValue = initValue;
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

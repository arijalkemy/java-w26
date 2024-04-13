package com.meli;

public abstract class SerieProgresiva <T> {
    private T valorActual;
    private T incremento;
    private T valorInicial;

    public SerieProgresiva(T incremento) {
        this.incremento = incremento;
    }

}

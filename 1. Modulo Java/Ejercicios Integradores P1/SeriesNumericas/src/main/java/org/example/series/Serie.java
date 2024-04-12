package org.example.series;

public abstract class Serie<T extends Number>{
    T incremento;
    T valorActual;

    public void setIncremento(T incremento) {
        this.incremento = incremento;
    }

    public abstract T siguiente();
    public abstract void reiniciar();
    public void setear(T nuevoValor){
        this.valorActual = nuevoValor;
    }
}

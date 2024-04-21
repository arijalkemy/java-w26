package org.example.model;

public abstract class Prototipo<T extends Number>{

    private T valorActual;
    private T valorIncial;

    public abstract <T> T valorSiguiente();

    public void valorReiniciar(){
        this.valorActual = this.valorIncial;
    }

    public  void valorIncial(T valorIncial){
        this.valorIncial = valorIncial;
        this.valorActual = valorIncial;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

}

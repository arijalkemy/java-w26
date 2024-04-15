package org.example;

public abstract class Prototipo {
    protected int numeroActual;

    public Prototipo(int numeroActual) {
        this.numeroActual =numeroActual;
    }

    public  abstract int numeroSiguiente();

    public void reiniciarSerie(){
        numeroActual = 0;
    }

    public void valorInicial(int numeroIniciar){
        numeroActual = numeroIniciar;
    }
}

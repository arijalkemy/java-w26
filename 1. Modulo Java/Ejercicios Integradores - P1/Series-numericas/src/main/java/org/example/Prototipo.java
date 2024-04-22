package org.example;

public abstract class Prototipo <T extends Number>{
    protected T puntoInicialSerie;
    protected T puntoActualSerie;
    protected T gap;

    protected void setPuntoInicial(T puntoInicial){
        this.puntoInicialSerie = puntoInicial;
        this.puntoActualSerie = puntoInicial;
    }

    protected void reiniciarSerie(){
        this.puntoActualSerie = this.puntoInicialSerie;
    }

    public abstract T obtenerSiguiente();

    Prototipo(T puntoInicialSerie, T gap){
        this.puntoInicialSerie = puntoInicialSerie;
        this.puntoActualSerie = puntoInicialSerie;
        this.gap = gap;
    }
}

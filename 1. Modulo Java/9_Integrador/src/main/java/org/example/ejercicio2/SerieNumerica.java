package org.example.ejercicio2;

public abstract class SerieNumerica <T extends Number> {

    private T valorInicialSerie;
    protected T valorActualDeSerie;


    public void setValorInicialSerie(T valorInicialSerie) {
        this.valorInicialSerie = valorInicialSerie;
        this.valorActualDeSerie = valorInicialSerie;
    }

    public void reiniciarSerie() {
        this.valorActualDeSerie = this.valorInicialSerie;
    }

    public abstract T siguienteValorSerie();
}

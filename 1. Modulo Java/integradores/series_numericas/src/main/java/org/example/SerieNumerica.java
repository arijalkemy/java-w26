package org.example;

public abstract class SerieNumerica {
    protected Number valorSerie = 0;
    protected Number incremental;

    public abstract Number devolverSiguienteValor();

    public void reiniciarSerie(){
        this.valorSerie = 0;
    };
    public void establecerValorInicial(int nuevoValor){
        this.valorSerie = nuevoValor;
    };
}

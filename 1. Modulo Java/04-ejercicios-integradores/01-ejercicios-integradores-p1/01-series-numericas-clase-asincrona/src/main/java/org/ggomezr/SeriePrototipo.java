package org.ggomezr;

public abstract class SeriePrototipo {
    protected Number valorInicial;
    protected Number valorIncremento;
    protected Number valorActual;

    public SeriePrototipo(Number valorInicial, Number valorIncremento) {
        this.valorInicial = valorInicial;
        this.valorIncremento = valorIncremento;
        this.valorActual = valorInicial;
    }

    public abstract Number obtenerSiguienteValor();

    public void reiniciarSerie(){
        this.valorActual = valorInicial;
    }

    public void establecerValorInicial(Number nuevoValorInicial){
        this.valorInicial = nuevoValorInicial;
        this.valorActual = nuevoValorInicial;
    }
}

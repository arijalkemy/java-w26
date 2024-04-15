package org.bootcamp.series.impl;

import org.bootcamp.series.IPrototipo;

public class SerieNumerica <T extends Number> implements IPrototipo {

    T valorInicial;
    T valorPaso;
    T valorActual;

    public SerieNumerica(T valorInicial, T valorPaso) {
        this.establecerValorInicial(valorInicial);
        this.valorPaso = valorPaso;
    }

    @Override
    public Number siguienteValor() {
        this.valorActual = obtenerSiguienteValor();
        return this.valorActual;

    }

    @Override
    public void reiniciarSerie() {
        valorActual = valorInicial;
    }

    @Override
    public void establecerValorInicial(Number valorInicial) {
        this.valorInicial = this.valorActual = (T) valorInicial;
    }

    private T obtenerSiguienteValor(){
        if (this.valorActual instanceof Integer) {
            return (T) Integer.valueOf(this.valorActual.intValue() + this.valorPaso.intValue());
        }
        if (this.valorActual instanceof Long) {
            return (T) Long.valueOf(this.valorActual.longValue() + this.valorPaso.longValue());
        }
        if (this.valorActual instanceof Float) {
            return (T) Float.valueOf(this.valorActual.floatValue() + this.valorPaso.floatValue());
        }
        if (this.valorActual instanceof Double) {
            return (T) Double.valueOf(this.valorActual.doubleValue() + this.valorPaso.doubleValue());
        } else {
            throw new IllegalArgumentException("Tipo numérico no soportado.");
        }
    }

    public void imprimirSerie(int cantidadDePasos){
        for (int i = 0; i < cantidadDePasos; i++) {
            System.out.println("Serie de " + this.valorPaso + " - Valor siguiente: " + this.siguienteValor());
        }
    }
}

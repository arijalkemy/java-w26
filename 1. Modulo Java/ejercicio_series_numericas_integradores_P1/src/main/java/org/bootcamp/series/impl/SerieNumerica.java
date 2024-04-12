package org.bootcamp.series.impl;

import org.bootcamp.series.IPrototipo;

public class SerieNumerica <T> implements IPrototipo {

    T valorInicial;
    T valorPaso;
    T valorActual;

    @Override
    public T siguiente() {
        if (valorActual instanceof Double){
            return (T) Double.valueOf(valorActual.doubleValue() + valorPaso.doubleValue());
        }


        return null;
    }

    @Override
    public void reiniciar() {
        this.valorActual = this.valorInicial;
    }

    @Override
    public void valorInicial(T valor) {
            this.valorInicial = valor;
    }

    private T siguienteValor(){

    }
    private void asignarValorInicial(){

    }
}

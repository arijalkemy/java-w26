package org.example.ejercicio_clases_abstractas;

public class SerieProductoEnteros extends SeriePrototipo<Integer> {
    public SerieProductoEnteros() {}

    public Integer obtenerValorSiguiente() {
        if(super.getSerieReiniciada()) {
            super.setSerieReiniciada(Boolean.FALSE);
            return super.getValorInicial();
        } else {
            Integer valorActual = super.getValorActual();
            Integer valorActualizado = valorActual * super.getValorInicial();
            super.setValorActual(valorActualizado);
            return valorActualizado;
        }
    }
}
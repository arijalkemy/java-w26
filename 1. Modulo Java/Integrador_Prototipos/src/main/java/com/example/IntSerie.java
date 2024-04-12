package com.example;

public class IntSerie extends Prototipo<Integer> {

    IntSerie(Integer puntoInicialSerie, Integer gap) {
        super(puntoInicialSerie, gap);
    }

    @Override
    public Integer obtenerSiguiente() {
        return this.puntoActualSerie + this.gap;
    }
    
}

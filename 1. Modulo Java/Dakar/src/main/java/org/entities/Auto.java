package org.entities;

public class Auto extends Vehiculo {

    public Auto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.setPeso(1000);
        this.setRuedas(4);
    }

}

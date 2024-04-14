package org.entities;

public class Moto extends Vehiculo {

    public Moto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.setPeso(300);
        this.setRuedas(2);
    }

}

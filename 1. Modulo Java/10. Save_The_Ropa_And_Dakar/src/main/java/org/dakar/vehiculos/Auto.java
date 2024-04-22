package org.dakar.vehiculos;

public class Auto extends Vehiculo {

    public Auto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.peso = 1000.0;
        super.ruedas = 4;
    }
}

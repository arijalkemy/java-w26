package org.dakar.vehiculos;

public class Moto extends Vehiculo {

    public Moto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.ruedas = 2;
        super.peso = 300.0;
    }
}

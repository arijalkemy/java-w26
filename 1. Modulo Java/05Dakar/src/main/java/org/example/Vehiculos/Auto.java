package org.example.Vehiculos;

public class Auto extends Vehiculo {

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
        this.setPeso(1000);
        this.setRuedas(4);
    }
}


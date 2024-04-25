package org.example;

public class Auto extends Vehiculo{
    private static final double peso=1000;
    private static final int ruedas=4;

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }
}

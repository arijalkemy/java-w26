package org.example;

public class Moto extends Vehiculo{
    private static final double peso=300;
    private static final int ruedas=2;

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

}

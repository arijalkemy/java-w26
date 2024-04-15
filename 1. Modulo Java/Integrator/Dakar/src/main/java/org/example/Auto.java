package org.example;

public class Auto extends Vehiculo{
    private int peso;
    private int ruedas;

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 1000;
        this.ruedas = 4;
    }
}

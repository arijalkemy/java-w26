package org.example;

public class Auto extends Vehiculo {

    public Auto(double aceleración, double velocidad, double anguloDeGiro, String patente) {
        super(aceleración, velocidad, anguloDeGiro, patente);
        setRuedas(4);
        setPeso(1000);
    }
}

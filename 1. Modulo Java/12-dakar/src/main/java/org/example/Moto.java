package org.example;

public class Moto extends Vehiculo {

    public Moto(double aceleración, double velocidad, double anguloDeGiro, String patente) {
        super(aceleración, velocidad, anguloDeGiro, patente);
        setPeso(300);
        setRuedas(2);
    }

}

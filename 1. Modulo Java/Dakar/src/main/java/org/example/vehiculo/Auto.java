package org.example.vehiculo;

public class Auto extends Vehiculo {
    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000.00, 4);
    }
}

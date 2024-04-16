package org.example.model;

public class Motos extends Vehiculo{
    public Motos(String patente, Double aceleracion, Double anguloDeGiro, Double velocidad) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 100.0, 2);

    }
}

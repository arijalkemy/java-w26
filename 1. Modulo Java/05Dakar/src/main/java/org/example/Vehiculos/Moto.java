package org.example.Vehiculos;

public class Moto extends Vehiculo {

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
        this.setPeso(300);
        this.setRuedas(2);
    }
}

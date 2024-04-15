package org.example.vehiculo;

import java.util.UUID;

public class Auto extends Vehiculo{
    private static final int peso = 1000;
    private static final int ruedas = 4;

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, UUID pantente) {
        super(velocidad, aceleracion, anguloDeGiro, pantente, peso, ruedas);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "Tipo: Auto " +
                "velocidad=" + super.getVelocidad() +
                ", aceleracion=" + super.getAceleracion() +
                ", anguloDeGiro=" + super.getAnguloDeGiro()+
                ", pantente=" + super.getPantente() +
                ", peso=" + super.getPeso() +
                ", ruedas=" + super.getRuedas() +
                '}';
    }
}

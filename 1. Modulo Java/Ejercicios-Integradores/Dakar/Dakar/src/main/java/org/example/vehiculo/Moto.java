package org.example.vehiculo;

import java.util.UUID;

public class Moto extends Vehiculo{
    private static final int peso = 300;
    private static final int ruedas = 2;

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, UUID pantente) {
        super(velocidad, aceleracion, anguloDeGiro, pantente, peso, ruedas);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "Tipo: Moto " +
                "velocidad=" + super.getVelocidad() +
                ", aceleracion=" + super.getAceleracion() +
                ", anguloDeGiro=" + super.getAnguloDeGiro()+
                ", pantente=" + super.getPantente() +
                ", peso=" + super.getPeso() +
                ", ruedas=" + super.getRuedas() +
                '}';
    }
}

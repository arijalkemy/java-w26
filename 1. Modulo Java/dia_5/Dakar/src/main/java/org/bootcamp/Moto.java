package org.bootcamp;

public class Moto extends Vehiculo{

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2); // Peso: 300 kg, Ruedas: 2
    }
}

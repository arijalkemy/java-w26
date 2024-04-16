package org.example;

public class Moto extends Vehiculo{

    private double peso;
    private int ruedas;

    public Moto(int velocidad, double aceleracion, int anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = peso;
        this.ruedas = ruedas;
    }
}

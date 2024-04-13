package org.example.vehiculos;

public abstract class Vehiculo {
    private double velocidad;
    private double acceleracion;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo(double velocidad, double acceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.acceleracion = acceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public double valorDeCarrera(){
        return velocidad * acceleracion / 2  / (anguloDeGiro*(peso-ruedas * 100));
    }
}

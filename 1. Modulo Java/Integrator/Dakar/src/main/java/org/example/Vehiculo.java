package org.example;

public abstract class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        }
    }

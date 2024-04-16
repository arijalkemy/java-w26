package org.example;

public abstract class Vehiculo {
    public int velocidad;
    public int aceleracion;
    public int anguloDeGiro;
    public boolean patente;
    public int peso;
    public int  ruedas;

    public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, boolean patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }
}

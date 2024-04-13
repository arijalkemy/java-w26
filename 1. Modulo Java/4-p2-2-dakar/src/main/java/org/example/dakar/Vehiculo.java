package org.example.dakar;

public abstract class Vehiculo {

    private double velocidad;

    private double aceleracion;

    private double anguloDeGiro;

    private String patente;

    private double peso;

    private int cantidadDeRuedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int cantidadDeRuedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.cantidadDeRuedas = cantidadDeRuedas;
    }

    public Double valorObtenidoRendimiento(){
        return (this.velocidad * 0.5 * this.aceleracion / (this.anguloDeGiro * (this.peso - this.cantidadDeRuedas * 100)));
    }

    public double getPeso() {
        return peso;
    }

    public int getCantidadDeRuedas() {
        return cantidadDeRuedas;
    }

    public String getPatente() {
        return patente;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }
}

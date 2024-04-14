package org.example;

class Vehiculo {
    protected double velocidad;
    protected double aceleracion;
    protected double anguloDeGiro;
    protected String patente;
    protected int peso;
    protected int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    // Método para calcular el valor de rendimiento en la carrera
    public double calcularValor() {
        return (velocidad * (aceleracion / 2)) / (anguloDeGiro * (peso - ruedas * 100));
    }
}

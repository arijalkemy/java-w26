package com.meli;

/**
 * Representa un vehículo genérico.
 */
public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    /**
     * Construye una nueva instancia de Vehiculo.
     *
     * @param velocidad La velocidad del vehículo.
     * @param aceleracion La aceleración del vehículo.
     * @param anguloDeGiro El ángulo de giro del vehículo.
     * @param patente La patente del vehículo.
     * @param peso El peso del vehículo.
     * @param ruedas El número de ruedas del vehículo.
     */
    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    // Se omiten los getters y setters por brevedad

    /**
     * Devuelve una representación en cadena de este vehículo.
     *
     * @return Una cadena que representa este vehículo.
     */
    @Override
    public String toString() {
        String text = "Vehiculo con patente: "+patente +" ";
        String tipo = "Es tipo " +(this instanceof Auto ? "Auto" : "Moto");

        return text + tipo;
    }
}
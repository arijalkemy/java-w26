package org.example;

public class Vehiculo {
    private double Velocidad;
    private double Aceleracion;
    private double AnguloDeGiro;
    private String Patente;
    private double Peso;
    private int Ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        Velocidad = velocidad;
        Aceleracion = aceleracion;
        AnguloDeGiro = anguloDeGiro;
        Patente = patente;
        Peso = peso;
        Ruedas = ruedas;
    }

    public double getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(double velocidad) {
        Velocidad = velocidad;
    }

    public double getAceleracion() {
        return Aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        Aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return AnguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        AnguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String patente) {
        Patente = patente;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public int getRuedas() {
        return Ruedas;
    }

    public void setRuedas(int ruedas) {
        Ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "Velocidad=" + Velocidad +
                ", Aceleracion=" + Aceleracion +
                ", AnguloDeGiro=" + AnguloDeGiro +
                ", Patente='" + Patente + '\'' +
                ", Peso=" + Peso +
                ", Ruedas=" + Ruedas +
                '}';
    }
}

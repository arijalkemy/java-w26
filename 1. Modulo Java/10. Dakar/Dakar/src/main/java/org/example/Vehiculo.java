package org.example;

public class Vehiculo {
    private double velocidad;

    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private int ruedas;
    private TipoVehiculo tipoVehiculo;


    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleración(double aceleracion) {
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

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public String toString() {
        return
                "Velocidad: " + velocidad +
                "\n Aceleración: " + aceleracion +
                "\n Angulo De Giro:" + anguloDeGiro +
                "\n Patente: " + patente  +
                "\n Peso: " + peso +
                "\n Ruedas:" + ruedas +
                "\n Tipo Vehiculo: " + tipoVehiculo  + "\n";
    }

    public Vehiculo(double velocidad, double aceleración, double anguloDeGiro, String patente, TipoVehiculo tipoVehiculo) {
        this.velocidad = velocidad;
        this.aceleracion = aceleración;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;

        switch (tipoVehiculo){
            case AUTO:
                this.ruedas = 4;
                this.peso = 1000;
                break;
            case MOTO:
                this.ruedas = 2;
                this.peso= 300;
                break;
        }
    }

    public double calcularRendimiento(){
        return this.velocidad * 0.5 * this.aceleracion / (this.anguloDeGiro * (this.peso - this.ruedas * 100));
    }
}

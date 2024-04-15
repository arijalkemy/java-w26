package org.example;

public class Vehiculo {
    protected int velocidad;
    protected int aceleracion;
    protected double anguloGiro;
    protected String patente;
    protected TipoVehiculo tipoVehiculo;
    protected double valorMax;

    public Vehiculo(int velocidad, int aceleracion, double anguloGiro, String patente, TipoVehiculo tipoVehiculo) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.tipoVehiculo=tipoVehiculo;
        this.valorMax=calcularValor();

    }

    private double calcularValor() {
        return (this.velocidad*(0.5)*this.aceleracion/(this.anguloGiro*(this.tipoVehiculo.getPeso()-this.tipoVehiculo.getRuedas()*100)));
    }

    @Override
    public String toString() {
        return "Vechiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloGiro=" + anguloGiro +
                ", patente='" + patente + '\'' +
                ", tipoVehiculo=" + tipoVehiculo.toString() +
                ", valorMax=" + valorMax +
                '}';
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(int aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloGiro() {
        return anguloGiro;
    }

    public void setAnguloGiro(double anguloGiro) {
        this.anguloGiro = anguloGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getValorMax() {
        return valorMax;
    }

    public void setValorMax(double valorMax) {
        this.valorMax = valorMax;
    }
}

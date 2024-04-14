package org.example;

import javax.management.BadAttributeValueExpException;

public class Vehiculo {

    private VehicleType tipoVehiculo;
    private Integer velocidad;
    private Integer aceleracion;
    private Integer anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;

    public Vehiculo(VehicleType tipoVehiculo, Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente, Integer ruedas) {
        this.tipoVehiculo = tipoVehiculo;
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.setPeso();
        this.ruedas = ruedas;
    }

    public VehicleType getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(VehicleType tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Integer aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Integer getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(Integer anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso() {
        if (this.tipoVehiculo == VehicleType.AUTO){
            this.peso = Double.valueOf(1000);
        } else if (this.tipoVehiculo == VehicleType.MOTO) {
            this.peso = Double.valueOf(300);
        }else {
            System.out.println("El tipo de Vehiculo no se reconoce");
        }

    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }


    public double maximoValor(){
        return (this.velocidad * (this.aceleracion/2)) / (this.anguloDeGiro*(this.peso-this.ruedas * 100));
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "tipoVehiculo=" + tipoVehiculo +
                ", velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                '}';
    }
}

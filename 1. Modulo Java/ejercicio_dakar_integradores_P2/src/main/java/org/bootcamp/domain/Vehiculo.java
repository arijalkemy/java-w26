package org.bootcamp.domain;

public class Vehiculo {

    private Integer velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private TipoVehiculo tipoVehiculo;


    public Vehiculo() {
    }

    public Vehiculo(Integer velocidad, Double aceleracion, Double anguloDeGiro, String patente, TipoVehiculo tipoVehiculo) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(Double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double obtenerVelocidadMaxima (){
        return (velocidad * (aceleracion / 2)) /
                (anguloDeGiro * ((tipoVehiculo.getPeso()) - tipoVehiculo.getRuedas()) * 100);
    }

}

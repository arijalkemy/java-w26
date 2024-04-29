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

    public String getPatente() {
        return patente;
    }

    public double obtenerVelocidadMaxima (){
        return (velocidad * (aceleracion / 2)) /
                (anguloDeGiro * ((tipoVehiculo.getPeso()) - tipoVehiculo.getRuedas()) * 100);
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", tipoVehiculo=" + tipoVehiculo +
                '}';
    }
}

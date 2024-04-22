package org.example.entity;

import org.example.enums.VehiclesEnum;

public class Vehiculo {

    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private VehiclesEnum tipoVehiculo;
    private Double raceValue;

    public Vehiculo(
            Double velocidad,
            Double aceleracion,
            Double anguloDeGiro,
            String patente,
            VehiclesEnum tipoVehiculo
    ) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
        this.raceValue =
                (velocidad * (1/2)*aceleracion) /
                        (anguloDeGiro*(tipoVehiculo.getPeso() - tipoVehiculo.getRuedas() * 100));
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
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

    public VehiclesEnum getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(VehiclesEnum tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Double getRaceValue() {
        return raceValue;
    }

    public void setRaceValue(Double raceValue) {
        this.raceValue = raceValue;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", tipoVehiculo=" + tipoVehiculo +
                ", raceValue=" + raceValue +
                '}';
    }
}

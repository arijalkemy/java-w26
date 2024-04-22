package org.example.entity;

import org.example.enums.VehiclesEnum;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    public Carrera(
            Double distancia,
            Double premioEnDolares,
            String nombre,
            Integer cantidadDeVehiculosPermitidos
    ) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    // -----
    public void darDeAltaVehiculo(
            Double velocidad,
            Double aceleracion,
            Double anguloDeGiro,
            String patente,
            VehiclesEnum tipoVehiculo
            ) {
        if(this.vehiculos.size() < this.cantidadDeVehiculosPermitidos ){
            Vehiculo vehiculo = new Vehiculo(
                    velocidad,
                    aceleracion,
                    anguloDeGiro,
                    patente,
                    tipoVehiculo
            );
            this.vehiculos.add(vehiculo);
        } else{
            System.out.println("No hay más espacio.");
        }
    }

    public Vehiculo ganadorCarrera(){
        Vehiculo vehiculo = null;
        for (Vehiculo v : this.vehiculos){
            if(vehiculo == null || v.getRaceValue() > vehiculo.getRaceValue() ){
                vehiculo = v;
            }
        }
        return  vehiculo;
    }
}

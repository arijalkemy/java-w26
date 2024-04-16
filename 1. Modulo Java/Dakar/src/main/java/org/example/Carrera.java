package org.example;

import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculoList;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculoList) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculoList = vehiculoList;
    }


    /*
    Getter and setters
     */

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }


    public void darDeAltaAuto(int velocidad,double aceleracion, int AnguloDeGiro, String patente){
        if (vehiculoList.size() > getCantidadDeVehiculosPermitidos()) {
            throw new RuntimeException("Ya no se permiten mas coches");
        }

        vehiculoList.add(new Auto(velocidad, aceleracion, AnguloDeGiro, patente, 1000, 4));
    }

    public void darDeAltaMoto(int velocidad,double aceleracion, int AnguloDeGiro, String patente){
        if (vehiculoList.size() > getCantidadDeVehiculosPermitidos()) {
            throw new RuntimeException("Ya no se permiten mas coches");
        }

        vehiculoList.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente, 300, 2));
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        vehiculoList.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
    }



}

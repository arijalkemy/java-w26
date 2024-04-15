package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int vehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int vehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.vehiculosPermitidos = vehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>(vehiculosPermitidos);
    }

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

    public int getVehiculosPermitidos() {
        return vehiculosPermitidos;
    }

    public void setVehiculosPermitidos(int vehiculosPermitidos) {
        this.vehiculosPermitidos = vehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void agregarAuto(Vehiculo auto){

    }

    public void agregarMoto(Vehiculo moto){

    }
}

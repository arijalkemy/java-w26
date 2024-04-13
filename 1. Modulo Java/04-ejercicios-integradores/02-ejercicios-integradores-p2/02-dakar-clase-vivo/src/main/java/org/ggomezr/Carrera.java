package org.ggomezr;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private Socorrista socorrista;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> vehiculos, Socorrista socorrista) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorrista = socorrista;
    }

    public void darDeAltaVehiculo(Vehiculo vehiculo){
        if(vehiculos.size() < cantidadVehiculosPermitidos){
            vehiculos.add(vehiculo);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(vehiculos.contains(vehiculo)) {
            vehiculos.remove(vehiculo);
            System.out.println("El vehiculo " + vehiculo.getPatente() + " ha sido eliminado de la carrera");
        }
    }

    public void eliminarVehiculoConPatente(String patente){
        Vehiculo vehiculoAEliminar = (Vehiculo) vehiculos.stream().filter(vehiculo -> Objects.equals(vehiculo.getPatente(), patente));
        if(vehiculos.contains(vehiculoAEliminar)){
            vehiculos.remove(vehiculoAEliminar);
            System.out.println("El vehiculo " + vehiculoAEliminar.getPatente() + " ha sido eliminado de la carrera");
        }
    }

    public Optional<Vehiculo> determinarGanador(){
        return vehiculos.stream().max(Comparator.comparingDouble(this::calcularValorVehiculo));
    }

    public double calcularValorVehiculo(Vehiculo vehiculo){
        return vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
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

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Socorrista getSocorrista() {
        return socorrista;
    }

    public void setSocorrista(Socorrista socorrista) {
        this.socorrista = socorrista;
    }
}

package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculoList;

    // Constuctor
    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculoList = new ArrayList<>();
    }

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculoList) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculoList = vehiculoList;
    }

    // Getters and Setters
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

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    // Metodos de Carrera
    public void darDeAltaVehiculo(Vehiculo vehiculo){
        if (this.vehiculoList.size() < this.cantidadDeVehiculosPermitidos){
            this.vehiculoList.add(vehiculo);
            if (vehiculo.getTipoVehiculo().equals(VehicleType.AUTO)){
                System.out.println("Se agrego a la Carrera el Auto" + vehiculo.getPatente());
            }else {
                System.out.println("Se agrego a la Carrera la Moto" + vehiculo.getPatente());
            }
        }else{
            System.out.println("Ya no hay espacio en la carrera para el vehiculo: " + vehiculo.getPatente());
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculoList.remove(vehiculo);
    }

    public Vehiculo ganadorCarrera(){
        return this.vehiculoList.stream().max(Comparator.comparingDouble(Vehiculo::maximoValor)).orElse(null);
    }

    public void obtenerRecordsCarrera() {
        List<Vehiculo> records =  this.vehiculoList.stream()
                .map(v-> v)
                .collect(Collectors.toList());


        for (Vehiculo auto: records) {
            System.out.println(auto + ": " + auto.maximoValor());
        }
        
        
    }
}

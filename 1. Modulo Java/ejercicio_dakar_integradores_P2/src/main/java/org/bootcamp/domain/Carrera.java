package org.bootcamp.domain;

import java.util.*;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera() {
        this.listaDeVehiculos = new ArrayList<>();
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

    public Integer getCantidadDeVehiculos() {
        return cantidadDeVehiculos;
    }

    public void setCantidadDeVehiculos(Integer cantidadDeVehiculos) {
        this.cantidadDeVehiculos = cantidadDeVehiculos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaVehiculo(Vehiculo vehiculo){
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculos)
            this.listaDeVehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente (String unaPatente){
        Vehiculo vehiculo = listaDeVehiculos.stream()
                .filter((veh)-> veh.getPatente().equals(unaPatente) )
                .findFirst().orElse(null);

        eliminarVehiculo(vehiculo);
    }


}

package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    Double distancia;
    Double premioEnDolares;
    String Nombre;
    Integer maxVehiculos;
    List<Vehiculo> listaVehiculos;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer maxVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        Nombre = nombre;
        this.maxVehiculos = maxVehiculos;
        this.listaVehiculos = new ArrayList<Vehiculo>();
    }

    public void eliminarVehiculo(Vehiculo vehiculo){

    }

    public void eliminarVehiculoConPatente(String patente){

    }
}

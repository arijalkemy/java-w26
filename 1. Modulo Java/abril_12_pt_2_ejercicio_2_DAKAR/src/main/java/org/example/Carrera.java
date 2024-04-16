package org.example;

import java.util.List;

public class Carrera
{
    private int distancia;
    private int premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    List<Vehiculo> listaVehiculos;

    public void darDeAltaVehiculo(int velocidad, int aceleracion, int anguloDeGiro, boolean patente){
        listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, boolean patente){

    }
}

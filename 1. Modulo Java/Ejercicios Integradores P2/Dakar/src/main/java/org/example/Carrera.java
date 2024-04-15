package org.example;

import java.util.*;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public Optional<Vehiculo> definirGanador(){
        return this.listaDeVehiculos.stream().max(Comparator.comparing(Vehiculo::getPuntaje));
    }

    private boolean hayCupo(){
        return this.cantidadDeVehiculosPermitidos < this.listaDeVehiculos.size();
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        this.listaDeVehiculos.remove(vehículo);
    };

    public void eliminarVehiculoConPatente(String unaPatente){
        // se puede cambiar por removeIf
        Optional<Vehiculo> vehiculoAEliminar = this.listaDeVehiculos.stream().filter( (x) -> x.getPatente() == unaPatente).findFirst();
        if (vehiculoAEliminar.isPresent()){
            this.eliminarVehiculo(vehiculoAEliminar.get());
        } else {
            System.out.println("No se encontro el vehiculo con patente = " + unaPatente);
        }
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (this.hayCupo()){
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaDeVehiculos.add(auto);
        } else {
            System.out.println("No hay mas cupos.");
        }
    };

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (this.hayCupo()){
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaDeVehiculos.add(moto);
        } else {
            System.out.println("No hay mas cupos.");
        }
    };

}

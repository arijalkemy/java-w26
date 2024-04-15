package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private Socorrista socorrista;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.socorrista = new Socorrista();
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, double anguloGiro, String patente) {
        if(cantidadDeVehiculosPermitidos>0){
            TipoVehiculo tipo = new TipoVehiculo("auto", 4, 1000);
            listaVehiculos.add(new Vehiculo(velocidad, aceleracion, anguloGiro, patente, tipo) );
            this.cantidadDeVehiculosPermitidos--;
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, double anguloGiro, String patente) {
        if(cantidadDeVehiculosPermitidos>0){
            TipoVehiculo tipo = new TipoVehiculo("moto", 2, 300);
            listaVehiculos.add(new Vehiculo(velocidad, aceleracion, anguloGiro, patente, tipo) );
            this.cantidadDeVehiculosPermitidos--;
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getPatente().equals(patente)){
                eliminarVehiculo(vehiculo);
                break;
            }
        }
    }

    public void ganadorCarrera(){
        double max=-1;
        Vehiculo vehiculoGanador = null;
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getVelocidad()>max){
                max = vehiculo.getValorMax();
                vehiculoGanador = vehiculo;
            }
        }
        System.out.println("El ganador de la carrera es el vehiculo: "+vehiculoGanador);
    }

    public void socorrer(Vehiculo vehiculo){
        this.socorrista.socorrerVehiculo(vehiculo.getPatente(), vehiculo.getTipoVehiculo().getTipo());
    }
}

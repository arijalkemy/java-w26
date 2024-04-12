package org.example.clases;

import com.sun.source.doctree.SinceTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distanciaEnKM;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculoList;
    private Vehiculo vehiculoGanador;

    private SocorristaAuto socorristaAuto;

    private SocorristaMoto socorristaMoto;

    public Carrera(double distanciaEnKM, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distanciaEnKM = distanciaEnKM;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculoList = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculoList.size()<cantidadDeVehiculosPermitidos){
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculoList.add(auto);
        }else{
            System.out.println("No se permiten mas autos");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(vehiculoList.size()<cantidadDeVehiculosPermitidos){
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculoList.add(moto);
        }else{
            System.out.println("No se permiten mas autos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculoList.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        vehiculoList.remove(vehiculoList.stream()
                .filter(v -> v.getPatente().equals(unaPatente))
                .findFirst());
    }

    public void calcularGanador(){
        vehiculoGanador = vehiculoList.stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularPotencia))
                .orElse(null);

        System.out.println("El ganador es: " + vehiculoGanador + ". Tiene " + vehiculoGanador.calcularPotencia() + " de potencia.");
    }

    public void socorrerAuto(String patente){
        Vehiculo auto = vehiculoList.stream()
                .filter(v->v.getPatente().equals(patente))
                .findFirst()
                .orElse(null);

        socorristaAuto.socorrer((Auto)auto);
    }

    public void socorrerMoto(String patente){
        Vehiculo moto = vehiculoList.stream()
                .filter(v->v.getPatente().equals(patente))
                .findFirst()
                .orElse(null);

        socorristaMoto.socorrer((Moto)moto);
    }

}

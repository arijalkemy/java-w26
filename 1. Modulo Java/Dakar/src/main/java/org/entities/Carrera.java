package org.entities;

import org.interfaces.ISocorrista;

import java.util.List;
import java.util.Optional;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private ISocorrista socorristaAuto;
    private ISocorrista socorristaMoto;

    public Carrera(int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos, ISocorrista socorristaAuto, ISocorrista socorristaMoto) {
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public Vehiculo ganador() {
        double maxVelocidad = 0;
        Vehiculo vehiculoGanador = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if(vehiculo.maxVelocidad() > maxVelocidad) {
                maxVelocidad = vehiculo.maxVelocidad();
                vehiculoGanador = vehiculo;
            }
        }
        if(vehiculoGanador != null) {
            System.out.println("El vehiculo gandor es: " + vehiculoGanador.getPatente());
        }
        return vehiculoGanador;
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> vehiculoSocorrer = listaDeVehiculos.stream().filter(v->v.getPatente().equals(patente)).findFirst();
        vehiculoSocorrer.ifPresent(vehiculo -> socorristaAuto.socorrer(vehiculo));
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> vehiculoSocorrer = listaDeVehiculos.stream().filter(v->v.getPatente().equals(patente)).findFirst();
        vehiculoSocorrer.ifPresent(vehiculo -> socorristaAuto.socorrer(vehiculo));
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        listaDeVehiculos.removeIf(v->v.getPatente().equals(patente));
    }

    public void darDeAltaMoto(int velocidad,int aceleracion,int anguloDeGiro,String patente){
        if(listaDeVehiculos.size() <= cantidadDeVehiculosPermitidos) {
            Vehiculo vehiculo = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            System.out.println("Vehiculo de tipo moto agregado");
            return;
        }
        System.out.println("No pueden haber más motos en la carrera");
    }

    public void darDeAltaAuto(int velocidad,int aceleracion,int anguloDeGiro,String patente){
        if(listaDeVehiculos.size() <= cantidadDeVehiculosPermitidos) {
            Vehiculo vehiculo = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            System.out.println("Vehiculo de tipo auto agregado");
            return;
        }
        System.out.println("No pueden haber más autos en la carrera");
    }
}

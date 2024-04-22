package org.example;

import java.util.*;
import java.util.concurrent.RecursiveTask;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private int cupoVehiculos;
    private  SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cupoVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cupoVehiculos = cupoVehiculos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
        this.listaDeVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(int velocidad, double aceleracion, double anguloDegiro, String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (Objects.equals(vehiculo.getPatente(), patente)) {
                System.out.println("El vehiculo " + vehiculo.getPatente() + " ya existe");
                return;
            }
        }
        if (cupoVehiculos > 0) {
            Auto auto = new Auto(patente, velocidad, aceleracion, anguloDegiro);
            listaDeVehiculos.add(auto);
            cupoVehiculos--;
        } else {
            System.out.println("No hay cupo");
        }
    }

    public void darDeAltaMoto(int velocidad, double aceleracion, double anguloDegiro, String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (Objects.equals(vehiculo.getPatente(), patente)) {
                System.out.println("El vehiculo " + vehiculo.getPatente() + " ya existe");
                return;
            }
        }
        if (cupoVehiculos > 0) {
            Moto moto = new Moto(patente, velocidad, aceleracion, anguloDegiro);
            listaDeVehiculos.add(moto);
            cupoVehiculos--;
        } else {
            System.out.println("No hay cupo");
        }
    }

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo vehiculoAeliminar = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            vehiculoAeliminar = vehiculo;
        }
        if (vehiculoAeliminar == null){
            System.out.println("Vehiculo no encontrado");
        }else{
            listaDeVehiculos.remove(vehiculoAeliminar);
        }

    }

    public void eliminarVehiculo( Vehiculo vehiculo) {
        if (listaDeVehiculos.remove(vehiculo)){
            System.out.println("Vehiculo eliminado");
        }else{
            System.out.println("Vehiculo no encontrado");
        }
    }

    public void calcularGandor() {
        if (listaDeVehiculos.isEmpty()) {
            System.out.println("No hay vehiculos");
        }
        Optional<Vehiculo> vehiculoGanador = listaDeVehiculos.stream().max(Comparator.comparing(Carrera::calcularPuntaje));
        System.out.println("VEHICULO GANADOR: " +vehiculoGanador.toString());
    }

    public static double calcularPuntaje(Vehiculo vehiculo){
        return vehiculo.getVelocidad()*1/2*vehiculo.getAcelaracion()/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
    }

    public void socorrerAuto(String patente){
        Auto autoAveriado = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if(vehiculo.getPatente().equals(patente) && vehiculo instanceof Auto){
                autoAveriado = (Auto) vehiculo;
            }
        }
        if(autoAveriado == null){
            System.out.println("No se encontro el vehiculo");
        }else {
            socorristaAuto.socorrer(autoAveriado);
        }
    }


    public void socorrerMoto(String patente){
        Moto motoAveriada = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if(vehiculo.getPatente().equals(patente) && vehiculo instanceof Moto){
                motoAveriada = (Moto) vehiculo;
            }
        }
        if(motoAveriada == null){
            System.out.println("No se encontro moto");
        }else {
            socorristaMoto.socorrer(motoAveriada);
        }
    }
}

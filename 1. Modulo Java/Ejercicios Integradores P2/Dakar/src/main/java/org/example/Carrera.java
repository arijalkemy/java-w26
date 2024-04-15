package org.example;

import java.util.*;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<Vehiculo>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    private Vehiculo buscarVehiculo(String patente){
        return this.listaDeVehiculos.stream().filter(x -> x.getPatente() == patente).findFirst().orElse(null);
    }

    public void socorrerAuto(String patente){
        Auto resultado = (Auto) this.buscarVehiculo(patente);
        if (resultado != null){
            socorristaAuto.socorrer(resultado);
        }
    }

    public void socorrerMoto(String patente){
        Moto resultado = (Moto) this.buscarVehiculo(patente);
        if (resultado != null){
            socorristaMoto.socorrer(resultado);
        }
    }

    public Optional<Vehiculo> definirGanador(){
        return this.listaDeVehiculos.stream().max(Comparator.comparing(Vehiculo::getPuntaje));
    }

    private boolean hayCupo(){
        return this.cantidadDeVehiculosPermitidos < this.listaDeVehiculos.size();
    }

    private void eliminarVehiculo(Vehiculo vehículo){
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

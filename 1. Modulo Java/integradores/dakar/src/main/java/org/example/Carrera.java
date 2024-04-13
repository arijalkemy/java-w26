package org.example;

import org.example.vehiculos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {
    public Carrera(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    // el enunciado pide esta firma por eso la instanciasion aqui
    public Auto darDeAltaAuto(double velocidad,double aceleracion,double AnguloDeGiro,String patente){
        Auto auto = new Auto(
                velocidad, aceleracion, AnguloDeGiro, patente
        );
        if(this.agregarVehiculo(auto)){
            return auto;
        }
        return null;
    };

    // el enunciado pide esta firma por eso la instanciasion aqui
    public Moto darDeAltaMoto(double velocidad,double aceleracion,double AnguloDeGiro,String patente){
        Moto moto = new Moto(
                velocidad, aceleracion, AnguloDeGiro, patente
        );
        if(this.agregarVehiculo(moto)){
            return moto;
        };
        return null;
    };

    private boolean agregarVehiculo(Vehiculo vehiculo){
        if(cantidadDeVehiculosPermitidos>vehiculos.size()) {
            vehiculos.add(vehiculo);
            return true;
        }
        return false;
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        vehiculos.remove(vehículo);
    };

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo vehiculoAEliminar = this.buscarVehiculoPorPatente(patente);
        vehiculos.remove(vehiculoAEliminar);
    }

    public Vehiculo vehiculoGanador() {
        Optional<Vehiculo> vehiculoGanador = vehiculos.stream()
                .reduce((v1, v2) -> v1.valorDeCarrera() > v2.valorDeCarrera() ? v1 : v2);

        return vehiculoGanador.orElse(vehiculos.isEmpty() ? null : vehiculos.get(0));
    }

    private Vehiculo buscarVehiculoPorPatente(String patente) {
        Optional<Vehiculo> vehiculoEncontrado = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst();

        return vehiculoEncontrado.orElse(null);
    }


    public void socorrerAuto(String patente){
        Vehiculo vehiculo = this.buscarVehiculoPorPatente(patente);
        if(vehiculo != null && vehiculo instanceof Auto) {
            socorristaAuto.socorrer((Auto) vehiculo);
        }
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo = this.buscarVehiculoPorPatente(patente);
        if(vehiculo != null && vehiculo instanceof Moto) {
            socorristaMoto.socorrer((Moto) vehiculo);
        }
    }
}

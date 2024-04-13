package com.meli;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }

    public void darAltaAuto(double velocidad, double aceleracion, double anguloDeGiro,
                            String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo automovil = new Vehiculo(velocidad, aceleracion, anguloDeGiro, patente, 1000.0, 4);
            listaDeVehiculos.add(automovil);
            System.out.println("Automovil agregado");
        } else {
            System.out.println("El vehiculo no puede ser almacenado, carrera llena");
        }
    }

    public void darAltaMoto(double velocidad, double aceleracion, double anguloDeGiro,
                            String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo moto = new Vehiculo(velocidad, aceleracion, anguloDeGiro, patente, 300.0, 2);
            listaDeVehiculos.add(moto);
            System.out.println("Moto agregada");
        } else {
            System.out.println("La moto no puede ser almacenada, carrera llena");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(unaPatente)) {
                listaDeVehiculos.remove(vehiculo);
                System.out.println("Vehiculo eliminado");
                break;
            }
        }
    }

    public Vehiculo definirGanador() {
        Vehiculo ganador = null;
        double valorGanador = Double.NEGATIVE_INFINITY;

        for (Vehiculo vehiculo : listaDeVehiculos) {
            double valor = vehiculo.calcularValor();
            if (valor > valorGanador) {
                valorGanador = valor;
                ganador = vehiculo;
            }
        }
        return ganador;
    }
}

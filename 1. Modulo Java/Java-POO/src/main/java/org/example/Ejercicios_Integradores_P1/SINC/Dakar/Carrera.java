package org.example.Ejercicios_Integradores_P1.SINC.Dakar;

import lombok.Data;
import org.example.Ejercicios_Integradores_P1.SINC.Dakar.Vehiculos.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@Data
public class Carrera {

    private int distancia;

    private double premioEnDolares;

    private String nombre;

    private int cantidadDeVehiculosPermitidos;

    private ArrayList<Vehiculo> vehiculos;

    private ArrayList<Socorrista> socorristas;

    public Carrera(int distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, ArrayList<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        vehiculos.forEach(e -> {
            if (this.vehiculos.size() < cantidadDeVehiculosPermitidos) {
                this.vehiculos.add(e);
            }
        });
        this.socorristas = new ArrayList<>();
    }

    public void darDeAltaSocorristaAuto(String nombre) {
        //socorristas.add(new SocorristaAuto());
    }

    public void darDeAltaSocorristaMoto(String nombre) {
        //socorristas.add(new SocorristaMoto());
    }



    public void darDeAltaAuto(int velocidad, int aceleracion, int AnguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, AnguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int AnguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente));
        }
    }

    public void eliminarVehicul(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public void ganador() {
        final double[] max = {0};
        AtomicReference<Vehiculo> winner = new AtomicReference<>();
        this.getVehiculos().forEach(e -> {
            double valor = (e.getVelocidad() * 0.5 * e.getAceleracion()) / (e.getAnguloDeGiro() * (e.getPeso() - e.getRuedas() * 100));
            if (valor > max[0]) {
                max[0] = valor;
                winner.set(e);
            }
        });

        System.out.println("El ganador es: " + winner.get().getPatente());
    }
}

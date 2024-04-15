package org.example.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private float distancia;
    private float premioEnDolares;
    private String nombre;
    private int vehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(float distancia, float premioEnDolares, String nombre, int vehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.vehiculosPermitidos = vehiculosPermitidos;
        this.vehiculos = new ArrayList<Vehiculo>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(float premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVehiculosPermitidos() {
        return vehiculosPermitidos;
    }

    public void setVehiculosPermitidos(int vehiculosPermitidos) {
        this.vehiculosPermitidos = vehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        if (vehiculos.size() < vehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
        } else {
            System.out.println("No hay cupo para dar de alta el auto.");
        }
    }

    public void darDeAltaMoto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        if (vehiculos.size() < vehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
        } else {
            System.out.println("No hay cupo para dar de alta la moto.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos
            .stream()
            .filter(vehiculo -> vehiculo.getPatente() == patente)
            .findFirst()
            .ifPresentOrElse(
                vehiculo -> {
                    vehiculos.remove(vehiculo);
                    System.out.println("Se eliminó el vehículo con patente: " + vehiculo.getPatente());
                },
                ()-> System.out.println("No se encontró un vehiculo con la patente ingresada."
                )
            );
    }

    public Vehiculo ganador() {
        Optional<Vehiculo> ganador = vehiculos
                .stream()
                .max(Comparator.comparingDouble(Vehiculo::obtenerRendimiento));

        if(ganador.isPresent()) return ganador.get();
        return null;
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> resultado = vehiculos.stream()
                        .filter(vehiculo -> vehiculo.getPatente() == patente)
                        .findFirst();

        if(resultado.isPresent()) socorristaAuto.socorrer((Auto) resultado.get());
        else System.out.println("No se encontró un auto con la patente ingresada");
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> resultado = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente() == patente)
                .findFirst();

        if(resultado.isPresent()) socorristaMoto.socorrer((Moto) resultado.get());
        System.out.println("No se encontró una moto con la patente ingresada");
    }
}

package org.example.dakar.model;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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


    public void darDeAltaAuto(int velocidad, int aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
        } else {
            System.out.println("No hay más cupo para vehículos.");
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
        } else {
            System.out.println("No hay más cupo para vehículos.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public Vehiculo definirGanador() {
        return vehiculos.stream()
                .max((v1, v2) -> Double.compare(
                        v1.getVelocidad() * 0.5 * v1.getAceleracion() / (v1.getAnguloDeGiro() * (v1.getPeso() - v1.getRuedas() * 100)),
                        v2.getVelocidad() * 0.5 * v2.getAceleracion() / (v2.getAnguloDeGiro() * (v2.getPeso() - v2.getRuedas() * 100))
                ))
                .orElse(null);
    }

    public void socorrerAuto(String patente) {
        vehiculos.stream()
                .filter(vehiculo -> vehiculo instanceof Auto && vehiculo.getPatente().equals(patente))
                .findFirst()
                .ifPresent(vehiculo -> socorristaAuto.socorrer((Auto) vehiculo));
    }

    public void socorrerMoto(String patente) {
        vehiculos.stream()
                .filter(vehiculo -> vehiculo instanceof Moto && vehiculo.getPatente().equals(patente))
                .findFirst()
                .ifPresent(vehiculo -> socorristaMoto.socorrer((Moto) vehiculo));
    }

}

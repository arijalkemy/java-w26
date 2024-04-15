package org.example.ejercicio2;

import java.util.*;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private final List<Vehiculo> vehiculos;
    private final SocorristaAuto socorristaAuto;
    private final SocorristaMoto socorristaMoto;


    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
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

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {

        if (this.vehiculos.size() >= cantidadDeVehiculosPermitidos)
            throw new RuntimeException("No se puede un Auto a la Carrera porque no queda mas cupo de Vehículos");

        this.vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {

        if (this.vehiculos.size() >= cantidadDeVehiculosPermitidos)
            throw new RuntimeException("No se puede agregar una Moto a la Carrera porque no queda mas cupo de Vehículos");

        this.vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {

        boolean estabaPresente = this.vehiculos.remove(vehiculo);

        if (!estabaPresente)
            throw new RuntimeException("El Vehículo indicado no se encuentra inscripto en esta Carrera");
    }

    public void eliminarVehiculoConPatente(String patente) {

        boolean estabaPresente = this.vehiculos.removeIf(v -> v.getPatente().equals(patente));

        if (!estabaPresente)
            throw new RuntimeException("No se encuentra inscripto en esta Carrera un Vehículo con la patente indicada");
    }

    public Vehiculo determinarGanador() {

        Vehiculo vehiculoGanador = this.vehiculos.stream()
            .max(Comparator.comparing(Vehiculo::calcularFormulaDesempeño))
            .orElseThrow(() -> new RuntimeException("No se puede determinar un ganador porque la Carrera no tiene Vehiculos inscriptos"));

        return vehiculoGanador;
    }

    public void socorrerAuto(String patente) {

        Auto autoASocorrer = this.vehiculos.stream()
            .filter(v -> v instanceof Auto && v.getPatente().equals(patente))
            .map(Auto.class::cast)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No se encuentra inscripto en la Carrera ningú Auto con esa patente"));

        this.socorristaAuto.socorrer(autoASocorrer);
    }

    public void socorrerMoto(String patente) {

        Moto motoASocorrer = this.vehiculos.stream()
            .filter(v -> v instanceof Moto && v.getPatente().equals(patente))
            .map(Moto.class::cast)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No se encuentra inscripto en la Carrera ningú Auto con esa patente"));

        this.socorristaMoto.socorrer(motoASocorrer);
    }
}

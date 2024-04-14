package meli.bootcamp.dakar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(
        double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos,
        SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto
    ) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public Vehiculo getGanador() {
        return Collections.max(vehiculos, Comparator.comparingInt(v -> (int) v.calcularPuntaje()));
    }

    public void socorrerAuto(String patente) {
        socorristaAuto.socorrer(buscarVehiculo(patente));
    }

    public void socorrerMoto(String patente) {
        socorristaMoto.socorrer((Moto) buscarVehiculo(patente));
    }

    public Vehiculo buscarVehiculo(String patente) {
        return vehiculos.stream()
            .filter(vehiculo -> vehiculo.getPatente().equals(patente)).
            findFirst()
            .orElse(null);
    }
}

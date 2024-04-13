package org.example.dakar;

import org.example.dakar.socorristas.SocorristaAuto;
import org.example.dakar.socorristas.SocorristaMoto;
import org.example.dakar.vehiculos.Auto;
import org.example.dakar.vehiculos.Moto;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private double distancia;

    private int premioEnDolares;

    private String nombre;

    private int cantidadDeVehiculosPermitidos;

    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;

    private SocorristaMoto socorristaMoto;


    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        vehiculos.add(moto);
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        vehiculos.add(auto);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        this.vehiculos.removeIf(objeto -> objeto.getPatente().equals(patente));
    }

    public Optional<Vehiculo> vehiculoGanador() {
        return this.vehiculos.stream().max(Comparator.comparing(Vehiculo::valorObtenidoRendimiento));
    }

    public Optional<Vehiculo> getVehiculoByPatente(String patente) {
        return this.vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst();
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> autoASocorrer = this.getVehiculoByPatente(patente);
        if (autoASocorrer.isPresent()) {
            Vehiculo vehiculo = autoASocorrer.get();
            if (vehiculo instanceof Auto) {
                socorristaAuto.socorrer((Auto) vehiculo);
            }
        }
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> motoASocorrer = this.getVehiculoByPatente(patente);
        if (motoASocorrer.isPresent()) {
            Vehiculo vehiculo = motoASocorrer.get();
            if (vehiculo instanceof Moto) {
                socorristaMoto.socorrer((Moto) vehiculo);
            }
        }
    }
}

package org.example;
import java.util.*;

class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaDeVehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        listaDeVehiculos.removeIf(v -> v.patente.equals(patente));
    }

    public Vehiculo calcularGanador() {
        return Collections.max(listaDeVehiculos, Comparator.comparing(Vehiculo::calcularValor));
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo v : listaDeVehiculos) {
            if (v instanceof Auto && v.patente.equals(patente)) {
                socorristaAuto.socorrer((Auto) v);
                break;
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo v : listaDeVehiculos) {
            if (v instanceof Moto && v.patente.equals(patente)) {
                socorristaMoto.socorrer((Moto) v);
                break;
            }
        }
    }
}

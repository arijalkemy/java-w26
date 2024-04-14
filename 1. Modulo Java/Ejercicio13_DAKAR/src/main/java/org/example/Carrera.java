package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() <= cantVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("No se pueden agregar más vehiculos");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() <= cantVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("No se pueden agregar más vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public Vehiculo getCampeon() {
        double valCampeon = 0;
        Vehiculo campeon = null;
        if (!vehiculos.isEmpty()) {
            campeon = vehiculos.get(0);
            for (Vehiculo vehiculo : vehiculos) {
                double valorVehiculo = vehiculo.getVelocidad() *
                        ((vehiculo.getAceleracion() * 0.5) /
                                (vehiculo.getAnguloDeGiro() *
                                        (vehiculo.getPeso() - vehiculo.getRuedas() * 100)));
                if (valCampeon < valorVehiculo) {
                    valCampeon = valorVehiculo;
                }
            }
        }
        return campeon;
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> vehiculoOptional = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst();
        if (vehiculoOptional.isPresent() && vehiculoOptional.get() instanceof  Auto) {
            socorristaAuto.socorrer((Auto) vehiculoOptional.get());
        } else {
            System.out.println("El vehículo no se encontró en la lista");
        }
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> vehiculoOptional = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst();
        if (vehiculoOptional.isPresent() && vehiculoOptional.get() instanceof  Moto) {
            socorristaMoto.socorrer((Moto) vehiculoOptional.get());
        } else {
            System.out.println("El vehículo no se encontró en la lista");
        }
    }

    public Carrera(
            double distancia, double premioEnDolares, String nombre, int cantVehiculosPermitidos,
            SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto
    ) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.vehiculos = vehiculos;
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

    public int getCantVehiculosPermitidos() {
        return cantVehiculosPermitidos;
    }

    public void setCantVehiculosPermitidos(int cantVehiculosPermitidos) {
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}

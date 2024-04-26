package org.example;

import java.util.Comparator;
import java.util.Set;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private Set<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(double distancia, Set<Vehiculo> vehiculos, int cantidadDeVehiculosPermitidos, String nombre, double premioEnDolares) {
        this.distancia = distancia;
        this.vehiculos = vehiculos;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.nombre = nombre;
        this.premioEnDolares = premioEnDolares;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public boolean existeVehiculo(String patente) {
        boolean existe = false;
        if (vehiculos.size() > 0) {
            for(Vehiculo v : vehiculos) {
                if (v.getPatente().equalsIgnoreCase(patente)) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    public boolean hayCupoDisponible() {
        return cantidadDeVehiculosPermitidos > 0 && cantidadDeVehiculosPermitidos > vehiculos.size();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double AnguloDeGiro, String patente) {
        Auto auto = new Auto(velocidad, aceleracion, AnguloDeGiro, patente);
        if (hayCupoDisponible()) {
            if (existeVehiculo(auto.getPatente())) {
                System.out.println("Ya existe un vehiculo con esa patente");
            } else {
                vehiculos.add(auto);
                System.out.println("Se agrego el siguiente vehiculo a la lista: " + auto);
            }
        } else {
            System.out.println("La carrera tiene el cupo completo");
        }

    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente) {
        Moto moto = new Moto(velocidad, aceleracion, AnguloDeGiro, patente);
        if (hayCupoDisponible()) {
            if (existeVehiculo(moto.getPatente())) {
                System.out.println("Ya existe un vehiculo con esa patente");
            } else {
                vehiculos.add(moto);
                System.out.println("Se agrego el siguiente vehiculo a la lista: " + moto);
            }
        } else {
            System.out.println("La carrera tiene el cupo completo");
        }
    }

    public void eliminarVehiculo(Vehiculo v) {
        boolean existeVehiculo = vehiculos.contains(v);
        if (existeVehiculo) {
            vehiculos.remove(v);
            System.out.println("Se elimino el vehiculo con patente: " + v.getPatente());
        } else {
            System.out.println("El vehiculo no existe");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        boolean eliminar = vehiculos.removeIf(v -> v.getPatente().equals(unaPatente) ? true : false);
        if (eliminar) {
            System.out.println("Se elimino el vehiculo con patente: " + unaPatente);
        } else {
            System.out.println("El vehiculo no existe");
        }
    }

    public Vehiculo definirGanador() {
        return vehiculos.stream()
                .max(Comparator.comparing(Vehiculo::calcularRendimiento)).orElse(null);
    }

    public void socorrerAuto(String patente) {
        if (existeVehiculo(patente)) {
            socorristaAuto.socorrer();
        } else {
            System.out.println("No existe el vehiculo que desea socorrer");
        }
    }

    public void socorrerMoto(String patente) {
        if (existeVehiculo(patente)) {
            socorristaMoto.socorrer();
        } else {
            System.out.println("No existe el vehiculo que desea socorrer");
        }
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

    public Set<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Set<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}

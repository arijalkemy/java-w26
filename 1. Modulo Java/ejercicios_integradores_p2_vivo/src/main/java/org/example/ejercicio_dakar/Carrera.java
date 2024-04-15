package org.example.ejercicio_dakar;

import java.util.*;

public class Carrera {
    private double distancia;
    private double precioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double precioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.precioEnDolares = precioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
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

    public double getPrecioEnDolares() {
        return precioEnDolares;
    }

    public void setPrecioEnDolares(double precioEnDolares) {
        this.precioEnDolares = precioEnDolares;
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

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Auto agregada a la carrera!");
        }
        else {
            System.out.println("Cupo de vehiculos lleno!");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Moto agregada a la carrera!");
        }
        else {
            System.out.println("Cupo de vehiculos lleno!");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        int index;
        for(index = 0; index < vehiculos.size(); index++) {
            if(vehiculos.get(index).getPatente().equals(unaPatente)) {
                break;
            }
        }
        vehiculos.remove(index);
    }

    public void getGanador() {
        Optional<Vehiculo> ganador = vehiculos.stream().max(Comparator.comparingDouble(v ->
                (v.getVelocidad() * 0.5 * v.getAceleracion()) /
                        (v.getAnguloDeGiro() * (v.getPeso() - (v.getRuedas() * 100)))));

        if(ganador.isPresent()) {
            System.out.println("El vehiculo ganador es: " + ganador);
        } else {
            System.out.println("No hay vehiculo ganador.");
        }
    }

    public void socorrerAuto(String patente) {
        socorristaAuto.socorrer((Auto) Objects.requireNonNull(vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente)).findFirst().orElse(null)));
    }

    public void socorrerMoto(String patente) {
        socorristaMoto.socorrer((Moto) Objects.requireNonNull(vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente)).findFirst().orElse(null)));
    }
}

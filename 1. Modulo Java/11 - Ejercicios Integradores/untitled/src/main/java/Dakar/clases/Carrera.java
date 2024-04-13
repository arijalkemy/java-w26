package Dakar.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculo;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculo = new ArrayList<>();
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

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaVehiculo.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaVehiculo.add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaVehiculo.size() < cantidadDeVehiculosPermitidos) {
            Moto auto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaVehiculo.add(auto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaVehiculo.remove(vehiculo);
    }

    public void eliminarVehiculoPatente(final String patente) {
        Optional<Vehiculo> vehiculo = listaVehiculo.stream().filter(x -> x.getPatente().equals(patente)).findFirst();

        if (vehiculo.isPresent()) {
            eliminarVehiculo(vehiculo.get());
        }
    }

    public Vehiculo ganador() {
        return listaVehiculo.stream().sorted((a, b) -> {
            double velocidaA = (a.getVelocidad() * 0.5 * a.getAceleracion()) / (a.getAnguloDeGiro() * (a.getPeso() - a.getRuedas() * 100));
            double velocidaB = (b.getVelocidad() * 0.5 * b.getAceleracion()) / (b.getAnguloDeGiro() * (b.getPeso() - b.getRuedas() * 100));

            return Double.compare(velocidaB,velocidaA) ;
        }).findFirst().get();
    }

}

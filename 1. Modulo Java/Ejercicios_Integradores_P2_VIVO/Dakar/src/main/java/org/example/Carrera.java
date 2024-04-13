package org.example;

import java.util.List;

public class Carrera {
    private double Distancia;
    private double PremioEnDolares;
    private String Nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private List<Vehiculo> vehiculosSocorristas;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo>  vehiculos, List<Vehiculo> vehiculosSocorristas) {
        Distancia = distancia;
        PremioEnDolares = premioEnDolares;
        Nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.vehiculosSocorristas = vehiculosSocorristas;
    }

    public double getDistancia() {
        return Distancia;
    }

    public void setDistancia(double distancia) {
        Distancia = distancia;
    }

    public double getPremioEnDolares() {
        return PremioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        PremioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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

    public List<Vehiculo> getVehiculosSocorristas() {
        return vehiculosSocorristas;
    }

    public void setVehiculosSocorristas(List<Vehiculo> vehiculosSocorristas) {
        this.vehiculosSocorristas = vehiculosSocorristas;
    }

    public void darDeAltaAuto(Autos auto){
        if (vehiculos.size() < cantidadDeVehiculosPermitidos){
            vehiculos.add(auto);
        }
        else{
            System.out.println("No se pueden agregar mas vehiculos");
        }

    }

    public void darDeAltaMoto(Motos moto){
        if (vehiculos.size() < cantidadDeVehiculosPermitidos){
            vehiculos.add(moto);
        }
        else{
            System.out.println("No se pueden agregar mas vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if (vehiculos.contains(vehiculo)) {
            vehiculos.remove(vehiculo);
        } else {
            System.out.println("El vehiculo no se encuentra en la carrera");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPatente().equals(unaPatente)){
                vehiculos.remove(vehiculo);
                break;
            }
        }
    }

    public void ganadorCarrera(){
        double max = 0;
        Vehiculo ganador = null;
        for (Vehiculo vehiculo : this.vehiculos){
            double valor = vehiculo.getVelocidad() * ((vehiculo.getAceleracion() / 2) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100)));
            if (valor > max){
                max = valor;
                ganador = vehiculo;
            }
        }
        System.out.println("El ganador es: " + ganador.toString());
    }

    public void socorrerAuto(String patente){
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPatente().equals(patente)){
                for (Vehiculo socorrista : vehiculosSocorristas){
                    if (socorrista instanceof SocorristaAuto){
                        ((SocorristaAuto) socorrista).socorrer((Autos) vehiculo);
                    }
                }
            }
        }
    }

    public void socorrerMoto(String patente){
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPatente().equals(patente)){
                for (Vehiculo socorrista : vehiculosSocorristas){
                    if(socorrista instanceof SocorristaMoto){
                        ((SocorristaMoto) socorrista).socorrer((Motos) vehiculo);
                    }
                }
            }
        }
    }
}

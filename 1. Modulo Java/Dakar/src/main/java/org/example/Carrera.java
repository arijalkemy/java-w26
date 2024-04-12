package org.example;

import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(puedeAgregarVehiculo()){
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(puedeAgregarVehiculo()){
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
        }
    }

    private boolean puedeAgregarVehiculo(){
        return listaDeVehiculos.size() < cantidadDeVehiculosPermitidos;
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public Vehiculo definirUnGanador(){
        Vehiculo ganador = null;
        double max = 0;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            double valor = vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2)
                    / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if(valor > max){
                max = valor;
                ganador = vehiculo;
            }
        }
        return ganador;
    }


    public void socorrerAuto(String patente){
        SocorristaAuto socorristaAuto = new SocorristaAuto();

        listaDeVehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst().ifPresent(socorristaAuto::socorrer);
    }

    public void socorrerMoto(String patente){
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        listaDeVehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst().ifPresent(socorristaMoto::socorrer);
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

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}

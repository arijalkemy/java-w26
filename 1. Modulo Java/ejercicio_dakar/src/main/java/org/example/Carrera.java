package org.example;

import java.util.List;

public class Carrera {

    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    private SocorristaAuto socorristaAuto;

    private SocorristaMoto socorristaMoto;


    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos, SocorristaMoto socorristaMoto, SocorristaAuto socorristaAuto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Vehiculo nuevoVehiculo = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaDeVehiculos.add(nuevoVehiculo);
        }
    }

    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Vehiculo nuevoVehiculo = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaDeVehiculos.add(nuevoVehiculo);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public Vehiculo ganador(){
        Vehiculo vehiculoGanador = null;
        double maxValor = 0;
        for(Vehiculo vehiculo: listaDeVehiculos){
            double maximoValor = (vehiculo.getVelocidad() * vehiculo.getAceleracion()/2) / (vehiculo.getAnguloDeGiro()*(vehiculo.getPeso() - vehiculo.getRuedas() *100));
            if(maximoValor > maxValor){
                vehiculoGanador = vehiculo;
                maxValor = maximoValor;
            }
        }
        return vehiculoGanador;
    }

    public void socorrerAuto(String patente){
        System.out.println("Socorriendo auto \n " + "Patente: " + patente);
    }

    public void socorrerMoto(String patente){
        System.out.println("Socorriendo moto \n" + "Patente: " + patente);
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

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
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

package org.decodificador.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private double premioUSD;
    private String nombre;
    private int cantidadPermitida;
    private List<Vehiculo> listaAutomoviles;
    private List<Vehiculo> listaMotos;
    private ISocorristaVehiculo socorristaAutomovil;
    private ISocorristaVehiculo socorristaMoto;

    public Carrera(double distancia, double premioUSD, String nombre, int cantidadPermitida) {
        this.distancia = distancia;
        this.premioUSD = premioUSD;
        this.nombre = nombre;
        this.cantidadPermitida = cantidadPermitida;
        this.listaAutomoviles = new ArrayList<>();
        this.listaMotos = new ArrayList<>();
        socorristaAutomovil = new SocorristaAutomovil();
        socorristaMoto  = new SocorristaMoto();
    }

    //------------------------------------------------------------------------------------------------------------------
    //Permite registrar un automovil en una carrera
    public void darDeAltaAuto(Vehiculo vehiculo){
        if(listaAutomoviles.size() < cantidadPermitida){
            System.out.println("Registrando auto en la carrera...");
            listaAutomoviles.add(vehiculo);
        }else{
            System.out.println("No es posible registrar el auto en la carrera...");
        }
    }
    //Permite registrar una moto en una carrera
    public void darDeAltaMoto(Vehiculo vehiculo){
        if(listaMotos.size() < cantidadPermitida){
            System.out.println("Registrando la moto en la carrera...");
            listaMotos.add(vehiculo);
        }else{
            System.out.println("No es posible registrar la moto en la carrera...");
        }
    }

    //Eliminar vehiculos
    public void eliminarVehiculo(Vehiculo vehiculo){
        if(((VehiculoConcreto)vehiculo).getCategoria().equals("Moto")){
            listaMotos.remove(vehiculo);
        }else if(((VehiculoConcreto)vehiculo).getCategoria().equals("Auto")){
            listaMotos.remove(vehiculo);
        }
    }
    //Eliminar vehiculos por placa
    public void eliminarVehiculoMoto(String placa){
        listaMotos.stream().filter(v -> v.getPatente().equals(placa)).findFirst().ifPresent(v -> listaMotos.remove(v));

    }
    public void eliminarVehiculoAutomovil(String placa){
        listaAutomoviles.stream().filter(v -> v.getPatente().equals(placa)).findFirst().ifPresent(v -> listaAutomoviles.remove(v));
    }

    public void socorrerAutomovil(Vehiculo vehiculo){
        socorristaAutomovil.socorrerVehiculo(vehiculo);
    }

    public void socorrerMoto(Vehiculo vehiculo){
        socorristaMoto.socorrerVehiculo(vehiculo);
    }

    public List<Vehiculo> definirGanador(List<Vehiculo> listavehiculos){
        return listavehiculos.stream().sorted((v1,v2)->((VehiculoConcreto)v2).getMax().compareTo(((VehiculoConcreto)v1).getMax()))
                .collect(Collectors.toList());
    }

    public void mostrarCompetidores(List<Vehiculo> listavehiculosRegistrados){
        listavehiculosRegistrados.forEach(v -> System.out.println(v.toString()));
    }


    //------------------------------------------------------------------------------------------------------------------
    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioUSD() {
        return premioUSD;
    }

    public void setPremioUSD(double premioUSD) {
        this.premioUSD = premioUSD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadPermitida() {
        return cantidadPermitida;
    }

    public void setCantidadPermitida(int cantidadPermitida) {
        this.cantidadPermitida = cantidadPermitida;
    }

    public List<Vehiculo> getListaAutomoviles() {
        return listaAutomoviles;
    }

    public void setListaAutomoviles(List<Vehiculo> listaAutomoviles) {
        this.listaAutomoviles = listaAutomoviles;
    }

    public List<Vehiculo> getListaMotos() {
        return listaMotos;
    }

    public void setListaMotos(List<Vehiculo> listaMotos) {
        this.listaMotos = listaMotos;
    }

    public ISocorristaVehiculo getSocorristaAutomovica() {
        return socorristaAutomovil;
    }

    public void setSocorristaAutomovica(ISocorristaVehiculo socorristaAutomovil) {
        this.socorristaAutomovil = socorristaAutomovil;
    }

    public ISocorristaVehiculo getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(ISocorristaVehiculo socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }
}

package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private int distancia;
    private String nombre;
    private int premioEnDolares;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private Vehiculo ganador;
    private SocorristaMoto socorristaMoto;
    private SocorristaAuto socorristaAuto;

    public Carrera(int distancia, String nombre, int premioEnDolares, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaMoto socorristaMoto, SocorristaAuto socorristaAuto) {
        this.distancia = distancia;
        this.nombre = nombre;
        this.premioEnDolares = premioEnDolares;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaMoto = socorristaMoto;
        this.socorristaAuto = socorristaAuto;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
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

    public void darDeAltaVehiculo(int velocidad, int aceleracion, int anguloDeGiro, int patente){
        if(Math.random()*100 % 2 == 0){
            Vehiculo vehiculo = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
        }
        else{
            Vehiculo vehiculo = new Auto(velocidad,aceleracion,anguloDeGiro,patente);

        }

    }

    public boolean estaInscrito(Vehiculo vehiculo){
        for (Vehiculo vehiculo1 : this.vehiculos) {
            if(vehiculo1.getPatente() == vehiculo.getPatente()){
                return true;
            }
        }
        return false;
    }

    public Vehiculo buscarVehiculo(int patente){
        for (Vehiculo vehiculo : this.vehiculos) {
            if(vehiculo.getPatente() == patente){
                return vehiculo;
            }
        }
        return null;
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        if(vehiculo != null){
            eliminarVehiculoConPatente(vehiculo.getPatente());
        }
    }

    public void eliminarVehiculoConPatente(int patente){
        this.setVehiculos(this.getVehiculos().stream().filter(vehiculo -> vehiculo.getPatente() != patente).collect(Collectors.toList()));
    }


    public void mostrarParticipantes() {
        for (Vehiculo vehiculo : this.vehiculos) {
            System.out.println(vehiculo.getPatente());
        }
    }

    public Vehiculo getGanador() {
        double rendimientoMayor = 0;
        for(Vehiculo vehiculo : this.vehiculos){
            if(vehiculo.getRendimiento() > rendimientoMayor){
                rendimientoMayor = vehiculo.getRendimiento();
                this.ganador = vehiculo;
            }
        }
        return ganador;
    }

    public void setGanador(Vehiculo ganador) {
        this.ganador = ganador;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }
}

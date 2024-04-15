package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private long premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(double distancia, long premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }
    private boolean quedanCupos(){
        return cantidadDeVehiculosPermitidos > this.listaDeVehiculos.size();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(quedanCupos()){
            for (Vehiculo vehiculo : listaDeVehiculos){
                if(vehiculo.getPatente().equals(patente)){
                    System.out.println("El auto ya se encuentra inscrito");
                    return;
                }
            }
            listaDeVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Auto agregado");
            return;
        }
        System.out.println("No se puede agregar el auto, ya que la competición alcanzó el máximo de vehiculos permitidos");
    }


    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(quedanCupos()){
            for (Vehiculo vehiculo : listaDeVehiculos){
                if(vehiculo.getPatente().equals(patente)){
                    System.out.println("La moto ya se encuentra inscrita");
                    return;
                }
            }
            listaDeVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Moto agregada");
            return;
        }
        System.out.println("No se puede agregar la moto, ya que la competición alcanzó el máximo de vehiculos permitidos");
    }
    public void eliminarVehiculo(Vehiculo vehiculo) {
        if( this.listaDeVehiculos.remove(vehiculo)){
            System.out.println("Vehiculo eliminado");
            return;
        }
        System.out.println("No se encontró el vehiculo a eliminar");
    }
    public void eliminarVehiculos(String patente) {
        if(this.listaDeVehiculos.removeIf(x->x.getPatente().equals(patente))){
            System.out.println("Vehiculo eliminado");
        }
        System.out.println("No se encontró un vehiculo con esa patente en el listado de vehiculos inscritos");
    }
    public void definirGanador(){
        Optional<Vehiculo> vehiculoGanador=listaDeVehiculos.stream().max(Comparator.comparing(Vehiculo::valorRendimiento));
        if(vehiculoGanador.isPresent()){
            System.out.println("El ganador de la carrera es el siguiente vehiculo: "+ vehiculoGanador.toString());
        }
    }
    public void socorrerAuto(String patente){
        Optional<Vehiculo> autoASocorrer = this.listaDeVehiculos.stream().filter(v -> v.getPatente().equals(patente) && v instanceof Auto).findFirst();

        if(!autoASocorrer.isPresent()){
            System.out.println("No se encontró un auto con esta pantente para socorrer");
            return;
        }
        Auto auto = (Auto) autoASocorrer.get();
        socorristaAuto.socorrer(auto);

    }
    public void socorrerMoto(String patente){
        Optional<Vehiculo> motoASocorrer = this.listaDeVehiculos.stream().filter(v -> v.getPatente().equals(patente) && v instanceof Auto).findFirst();

        if(!motoASocorrer.isPresent()){
            System.out.println("No se encontró un auto con esta pantente para socorrer");
            return;
        }
        Moto moto = (Moto) motoASocorrer.get();
        socorristaMoto.socorrer(moto);
    }

}

package org.example;

import org.example.socorrista.SocorristaDeAuto;
import org.example.socorrista.SocorristaDeMoto;
import org.example.vehiculo.Auto;
import org.example.vehiculo.Moto;
import org.example.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private long premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos = new ArrayList<>();

    private SocorristaDeAuto socorristaDeAuto = new SocorristaDeAuto();
    private SocorristaDeMoto socorristaDeMoto = new SocorristaDeMoto();

    public Carrera(double distancia, long premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Auto agregada con éxito.");
        } else{
            System.out.println("No hay cupo para el auto.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Moto agregada con éxito.");
        } else{
            System.out.println("No hay cupo para el auto.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(listaDeVehiculos.contains(vehiculo)){
            listaDeVehiculos.remove(vehiculo);
            System.out.println("Vehiculo eliminado.");
        } else{
            System.out.println("El vehiculo no existía.");
        }
    }

    public void eliminarVehiculoConPatente(String patente){
        Vehiculo vehiculo = listaDeVehiculos.stream().filter(vehiculo1 -> vehiculo1.getPatente().equals(patente)).findFirst().orElse(null);
        if(vehiculo != null){
            listaDeVehiculos.remove(vehiculo);
            System.out.println("Vehiculo eliminado.");
        } else{
            System.out.println("El vehiculo no existe");
        }
    }

    public Vehiculo ganador(){
        if(listaDeVehiculos.isEmpty()){
            System.out.println("No hay competidores");
            return null;
        }

        Vehiculo winner = listaDeVehiculos.get(0);
        double maxPuntaje = puntaje(winner);
        for (Vehiculo vehiculo : listaDeVehiculos) {
            double curPuntaje = puntaje(vehiculo);
            if(curPuntaje > maxPuntaje){
                maxPuntaje = curPuntaje;
                winner = vehiculo;
            }
        }
        return winner;
    }

    private double puntaje(Vehiculo vehiculo){
        // NO puede tirar error porque hardcodeamos el peso y cantidad de ruedas.
        return vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2) / (vehiculo.getPeso() - 100*vehiculo.getRuedas());
    }

    public void socorrerAuto(String patente){
        Auto auto = (Auto) listaDeVehiculos.stream().filter(automovil -> automovil.getPatente().equals(patente)).findFirst().orElse(null);
        if(auto != null){
            socorristaDeAuto.socorrer(auto);
        } else{
            System.out.println("No se encontró el auto.");
        }
    }

    public void socorrerMoto(String patente){
        Moto moto = (Moto) listaDeVehiculos.stream().filter(motoneta -> motoneta.getPatente().equals(patente)).findFirst().orElse(null);
        if(moto != null){
            socorristaDeMoto.socorrer(moto);
        } else{
            System.out.println("No se encontró la moto.");
        }
    }
}

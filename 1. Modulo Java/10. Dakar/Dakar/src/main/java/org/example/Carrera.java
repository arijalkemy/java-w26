package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
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

    public void darDeAltaVehiculo(Vehiculo vehiculo) {

        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {

            listaDeVehiculos.add(vehiculo);
        }
        System.out.println("________________________");
        System.out.println("Vehiculos Inscriptos a la carrera \n ________________________ \n" + listaDeVehiculos);
        System.out.println("________________________");

    }

    public void eliminarVehiculo(Vehiculo vehículo) {
        listaDeVehiculos.remove(vehículo);
        System.out.println("________________________");
        System.out.println("Se elimino de la carrera el Vehiculo.. \n Los participantes que quedan son:");
        System.out.println(listaDeVehiculos);
        System.out.println("________________________");
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        try {
            Vehiculo vehiculoEliminar = listaDeVehiculos.stream().filter(p -> p.getPatente() == unaPatente).findFirst().get();

            listaDeVehiculos.remove(vehiculoEliminar);
            System.out.println("________________________");
            System.out.println("Se elimino de la carrera el Vehiculo patente" + unaPatente + " \n Los participantes que quedan son:");
            System.out.println(listaDeVehiculos);
            System.out.println("________________________");
        }
        catch (Exception e){
            if (e.getMessage().contains("No value")){
                System.out.println("No se encontro un auto con esta patente");
            }

        }
    }

    public Optional<Vehiculo> verGanador(){
         return this.listaDeVehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularRendimiento));
    }

    public void socorrerVehiculo(Vehiculo v){
    Socorrista socorrista = new Socorrista();
    socorrista.socorrer(v);

    }

}

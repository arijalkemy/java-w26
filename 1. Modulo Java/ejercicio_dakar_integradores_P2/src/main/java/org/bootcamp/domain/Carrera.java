package org.bootcamp.domain;

import java.util.*;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculos) {
        this.listaDeVehiculos = new ArrayList<>();
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculos = cantidadDeVehiculos;
    }

    public void darDeAltaVehiculo(Vehiculo vehiculo){
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculos)
            this.listaDeVehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente (String unaPatente){
        Vehiculo vehiculo = listaDeVehiculos.stream()
                .filter(veh-> veh.getPatente().equals(unaPatente) )
                .findFirst().orElse(null);

        eliminarVehiculo(vehiculo);
    }

    public Vehiculo ganadorCarrera(){
        return listaDeVehiculos.stream()
                .max((veh1, veh2)-> (int) (veh1.obtenerVelocidadMaxima() - veh2.obtenerVelocidadMaxima()))
                .orElse(new Vehiculo());
    }

    public void socorrer(Vehiculo vehiculo){
        if(vehiculo.getTipoVehiculo().getRuedas().equals(TipoVehiculo.RUEDAS_MOTO)){
            System.out.println("\nSocorriendo moto!");
        }else if(vehiculo.getTipoVehiculo().getRuedas().equals(TipoVehiculo.RUEDAS_CARRO)){
            System.out.println("\nSocorriendo auto!");
        }
        System.out.println("Patente: " + vehiculo.getPatente());
    }

    public void socorrerPorPatente (String patente){
        Optional<Vehiculo> vehiculoEncontrado = listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equalsIgnoreCase(patente))
                .findFirst();

        if(!vehiculoEncontrado.isPresent()){
            System.out.println("\nNo se encontro el vehículo con la patente " + patente);
            return; // Para acabar el error
        }

        socorrer(vehiculoEncontrado.get());
    }

    public void listadoDeVehiculos(){
        System.out.println("\n**** Listado de vehículos en la Carrera ****");
        listaDeVehiculos.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculos=" + cantidadDeVehiculos +
                ", listaDeVehiculos=" + listaDeVehiculos +
                '}';
    }
}

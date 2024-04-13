package org.example;

import org.example.socorrista.SocorristaAuto;
import org.example.socorrista.SocorristaMoto;
import org.example.vehiculo.Auto;
import org.example.vehiculo.Moto;
import org.example.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculoList;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculoList = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if(vehiculoList.size() < cantidadDeVehiculosPermitidos){
            Auto auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
            this.vehiculoList.add(auto);
        }
        else{
            System.out.println("No se pueden agregar más vehiculos, limite alcanzado para esta carrera");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if(vehiculoList.size() < cantidadDeVehiculosPermitidos){
            Moto moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
            this.vehiculoList.add(moto);
        }
        else{
            System.out.println("No se pueden agregar más vehiculos, limite alcanzado para esta carrera");
        }
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculoList.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        this.vehiculoList = this.vehiculoList.stream()
                .filter(e -> !e.getPatente()
                .equals(patente))
                .collect(Collectors.toList());
    }
    public void ganador(){
        Vehiculo ganador = this.vehiculoList.get(0);
        Double maxValue = 0.0;
        Double currentValue;
        for(Vehiculo vehiculo : this.vehiculoList){
            currentValue = vehiculo.getVelocidad() * 1/2 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if(maxValue < currentValue){
                maxValue = currentValue;
                ganador = vehiculo;
            }
        }
        System.out.println("El ganador es " + ganador.getPatente());
    }

    public void socorrerAuto(String patente){
       Optional<Vehiculo> vehiculo = this.vehiculoList.stream()
                .filter(e -> e.getPatente().equals(patente))
                .findFirst();
       if(vehiculo.isPresent() && vehiculo.get() instanceof Auto){
           this.socorristaAuto.socorrer((Auto)vehiculo.get());
       }else{
           System.out.println("No existe auto con esa patente");
       }
    }
    public void socorrerMoto(String patente){
        Optional<Vehiculo> vehiculo = this.vehiculoList.stream()
                .filter(e -> e.getPatente().equals(patente))
                .findFirst();
        if(vehiculo.isPresent() && vehiculo.get() instanceof Moto){
            this.socorristaMoto.socorrer((Moto)vehiculo.get());
        }else{
            System.out.println("No existe moto con esa patente");
        }
    }

    public void mostrarCompetidores(){
        System.out.println("------------COMPETIDORES----------------");
        this.vehiculoList
                .forEach(System.out::println);
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", vehiculoList=" + vehiculoList +
                '}';
    }
}

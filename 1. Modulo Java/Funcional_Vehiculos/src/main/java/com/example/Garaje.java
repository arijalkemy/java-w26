package com.example;

import java.util.Comparator;
import java.util.List;

public class Garaje {
    private static int CONTADOR = 0;
    int id;
    List<Vehiculo> vehiculos;

    public int getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public Garaje( List<Vehiculo> vehiculos) {
        this.id = ++CONTADOR;
        this.vehiculos = vehiculos;
    }
    
    public List<Vehiculo> ordenarVehiculosPorPrecioAsc(){
        return vehiculos
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .toList();
    }
    
    public List<Vehiculo> ordenarVehiculoPorMarcaYPrecio(){
        return vehiculos
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .toList();
    }
 
    public List<Vehiculo> obtenerVehiculosMenoresIgual(int n){
        return vehiculos
                .stream()
                .filter(x -> x.getCosto() <= n)
                .toList();
    }

    public List<Vehiculo> obtenerVehiculosMayorIgual(int n){
        return vehiculos
                .stream()
                .filter(x -> x.getCosto() >= n)
                .toList();
    }

    public double calcularPromedioCostoVehiculos(){
        return vehiculos
                .stream()
                .mapToDouble( x -> x.getCosto())
                .average()
                .orElse(0.0);
    }
}

package com.company.classes;

import java.util.Comparator;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    // función que ordena los vehículos por precio
    public List<Vehiculo> ordenarPorPrecio() {
        return vehiculos
                .stream()
                .sorted((v1, v2) -> Float.compare(v1.getCosto(), v2.getCosto()))
                .toList();
    }

    // función que ordena los vehículos por marca y precio
    public List<Vehiculo> ordenarPorMarcaYPrecio() {
        return vehiculos
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .toList();
    }

    // función que retorna todos los vehículos con precio menor a 1000
    public List<Vehiculo> menorA1000() {
        return vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .toList();
    }

    // función que retorna todos los vehículos con precio mayor o igual a 1000
    public List<Vehiculo> mayorIgualA1000() {
        return vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();
    }

    // función que retorna el precio promedio de todos los vehículos
    public double promedioPrecios() {
        return vehiculos
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);
    }
}

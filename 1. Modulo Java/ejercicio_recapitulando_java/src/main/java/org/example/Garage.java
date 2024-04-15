package org.example;

import java.util.Comparator;
import java.util.List;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id, List<Vehiculo> vehiculos) {
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

    public List<Vehiculo> ordenarVehiculosPorPrecioDeMenorAMayor() {
        return vehiculos.stream()
                .sorted(Comparator
                        .comparing(Vehiculo::getCosto))
                .toList();
    }

    public List<Vehiculo> ordenarVehiculosPorMarcaYPrecio() {
        return vehiculos.stream()
                .sorted(Comparator
                        .comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .toList();
    }

    public List<Vehiculo> getVehiculosPrecioNoMayorAMil() {
        return vehiculos.stream().filter(x -> x.getCosto() <= 1000).toList();
    }

    public List<Vehiculo> getVehiculosPrecioMayorOIgualAMil() {
        return vehiculos.stream().filter(x -> x.getCosto() >= 1000).toList();
    }

    public double getPromedioPreciosDeVehiculos() {
        return vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
    }
}

package org.example;

import java.util.ArrayList;
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

    public double getPromedio() {
        return getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto).average().getAsDouble();
    }

    public List<Vehiculo> getVehiculosPorCosto() {
        return getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .toList();
    }

    public List<Vehiculo> getVehiculosPorMarcaYCosto() {
        return getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing((Vehiculo::getCosto)))
                .toList();
    }

    public List<Vehiculo> getVehiculosSegunCostoMenorA(double num) {
        return getVehiculos().stream()
                .filter(v -> v.getCosto() < num)
                .toList();
    }

    public List<Vehiculo> getVehiculosSegunCostoMayorIgualA(double num) {
        return getVehiculos().stream()
                .filter(v -> v.getCosto() >= num)
                .toList();
    }
}

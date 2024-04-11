package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Item 1) -------------
public class Garage {

    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id) {
        this.vehiculos = new ArrayList<>();
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

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    // --- streams
    // Item 3) -------------
    public List<Vehiculo> getVehiculosSortedByCosto() {
        return this.getVehiculos()
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                //.sorted((v1,v2) -> Double.compare(v1.getCosto(),v2.getCosto()))
                .toList();
    }

    // Item 4) -------------
    public List<Vehiculo> getVehiculosSortedByMarcaPrice() {
        return  this.vehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .toList();
    }

    // Item 5) -------------
    public double getVehiculosPriceAVG() {
        return this.vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
    }
}

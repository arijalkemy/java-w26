package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class ManejadorVehiculos {

    private List<Vehiculo> vehiculos;
    private Garaje garaje;

    public ManejadorVehiculos(Garaje garaje) {
        this.garaje = garaje;
        vehiculos = garaje.getVehiculos();
    }

    public void ordenarPorPrecio() {
        vehiculos.sort((x, y) -> Double.compare(x.getCosto(), y.getCosto()));
    }

    public void ordenarPorMarcaYPrecio() {
        // vehiculos.sort((x, y) -> {
        //     int diferencia = x.getMarca().compareTo(y.getMarca());
        //
        //     if (x.getMarca().equals(y.getMarca())) {
        //         return Double.compare(x.getCosto(), y.getCosto());
        //     }
        //     return diferencia;
        // });
        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
    }

    public List<Vehiculo> getMenoresOIgual1000() {
        return vehiculos.stream().filter(x -> x.getCosto() < 1000).toList();
    }

    public List<Vehiculo> getMayores1000() {
        return vehiculos.stream().filter(x -> x.getCosto() >= 1000).toList();
    }

    public double getPromedio() {
        return vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);
    }
}

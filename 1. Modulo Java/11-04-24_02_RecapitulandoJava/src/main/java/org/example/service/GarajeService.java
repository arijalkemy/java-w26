package org.example.service;

import org.example.model.Vehiculo;
import org.example.model.Garaje;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GarajeService {

    public void ordenarVehiculosPorPrecio(Garaje garaje) {
        garaje.getVehiculos().sort(Comparator.comparingInt(Vehiculo::getCosto));
    }

    public void ordenarVehiculosPorMarcaYPrecio(Garaje garaje) {
        garaje.getVehiculos().sort(
                Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto)
        );
    }

    public List<Vehiculo> filtrarVehiculosPorPrecioMenorA(Garaje garaje, int precio) {
        return garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() < precio)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> filtrarVehiculosPorPrecioMayorOIgualA(Garaje garaje, int precio) {
        return garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() >= precio)
                .collect(Collectors.toList());
    }

    public double calcularPromedioPrecios(Garaje garaje) {
        return garaje.getVehiculos().stream()
                .mapToInt(Vehiculo::getCosto)
                .average()
                .orElse(0);
    }
}

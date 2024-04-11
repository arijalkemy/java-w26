package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corolla", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));
        Garaje garaje = new Garaje(1, vehiculos);

        // Ejercicio 3
        List<Vehiculo> ordenadosPorCosto = garaje.getVehiculos();
        ordenadosPorCosto.sort(Comparator.comparingInt(Vehiculo::getCosto));
        System.out.println("\nOrdenados por costo:\n");
        ordenadosPorCosto.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));

        // Ejercicio 4
        List<Vehiculo> ordenadosPorMarcaYCosto = garaje.getVehiculos();
        ordenadosPorMarcaYCosto.sort(Comparator.comparing(Vehiculo::getMarca).thenComparingInt(Vehiculo::getCosto));
        System.out.println("\nOrdenados por marca y costo:\n");
        ordenadosPorMarcaYCosto.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));

        // Ejercicio 5
        List<Vehiculo> vehiculosEconomicos = garaje.getVehiculos().stream().filter(v -> v.getCosto() < 1000).toList();
        List<Vehiculo> vehiculosCostosos = garaje.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).toList();
        double promedioDeCostos = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);

        System.out.println("\nVehículos económicos:\n");
        vehiculosEconomicos.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("\nVehículos costosos:\n");
        vehiculosCostosos.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("\nPromedio de costos: " + promedioDeCostos);
    }
}


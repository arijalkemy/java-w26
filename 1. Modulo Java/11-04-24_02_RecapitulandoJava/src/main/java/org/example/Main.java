package org.example;

import org.example.model.Garaje;
import org.example.model.Vehiculo;
import org.example.service.GarajeService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garaje garaje = new Garaje(1, vehiculos);
        GarajeService garajeService = new GarajeService();

        System.out.println("Lista original de vehículos:");
        garaje.getVehiculos().forEach(System.out::println);

        garajeService.ordenarVehiculosPorPrecio(garaje);
        System.out.println("\nVehículos ordenados por precio:");
        garaje.getVehiculos().forEach(System.out::println);

        garajeService.ordenarVehiculosPorMarcaYPrecio(garaje);
        System.out.println("\nVehículos ordenados por marca y precio:");
        garaje.getVehiculos().forEach(System.out::println);

        List<Vehiculo> vehiculosMenor1000 = garajeService.filtrarVehiculosPorPrecioMenorA(garaje, 1000);
        System.out.println("\nVehículos con precio menor a 1000:");
        vehiculosMenor1000.forEach(System.out::println);

        List<Vehiculo> vehiculosMayorIgual1000 = garajeService.filtrarVehiculosPorPrecioMayorOIgualA(garaje, 1000);
        System.out.println("\nVehículos con precio mayor o igual a 1000:");
        vehiculosMayorIgual1000.forEach(System.out::println);

        double promedioPrecios = garajeService.calcularPromedioPrecios(garaje);
        System.out.println("\nPromedio de precios de todos los vehículos: " + promedioPrecios);
    }
}
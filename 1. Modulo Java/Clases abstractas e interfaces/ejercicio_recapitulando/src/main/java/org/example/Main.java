package org.example;

import org.example.model.Garaje;
import org.example.model.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford","Fiesta", 1000.0));
        vehiculos.add(new Vehiculo("Ford","Focus", 1200.0));
        vehiculos.add(new Vehiculo("Ford","Explorer", 2500.0));
        vehiculos.add(new Vehiculo("Fiat","Uno", 500.0));
        vehiculos.add(new Vehiculo("Fiat","Cronos", 1000.0));
        vehiculos.add(new Vehiculo("Fiat","Torino", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet","Aveo", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet","Spin", 2500.0));
        vehiculos.add(new Vehiculo("Toyota","Corola", 1200.0));
        vehiculos.add(new Vehiculo("Toyota","Fortuner", 3000.0));
        vehiculos.add(new Vehiculo("Renault","Logan", 950.0));
        garaje.setVehiculos(vehiculos);
        garaje.setId(0);

        vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Comparator.comparingDouble(Vehiculo::getCosto))).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        List<Vehiculo> vehiculosMenores = vehiculos.stream().filter(x -> x.getCosto() < 1000).toList();
        vehiculosMenores.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        List<Vehiculo> vehiculosMayore = vehiculos.stream().filter(x -> x.getCosto() >= 1000).toList();
        vehiculosMayore.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        double promedio = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println("Promedio: " + promedio);
        System.out.println("------------------------------------------------------------------");

    }
}
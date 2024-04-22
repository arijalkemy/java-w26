package org.bootcamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Garage garage = new Garage(1, new ArrayList<>());

        garage.setVehiculos(new ArrayList<>(List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        )));

        System.out.println("Vehiculos ordenados por costo");
        garage.getVehiculos().stream()
                        .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                        .forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("Vehiculos ordenados por marca y costo");
        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("Vehiculos con precio no mayor a 1000");
        garage.getVehiculos().stream()
                .filter(v -> v.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("Vehiculos con precio mayor a 1000");
        garage.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("Promedio de precios de los autos");
        garage.getVehiculos().stream()
                .mapToInt(Vehiculo::getCosto)
                .average()
                .ifPresent(System.out::println);
    }
}

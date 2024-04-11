package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("GMC", "3500 Club Coupe", 2820.43));
        vehiculos.add(new Vehiculo("GMC", "Yukon", 4811.18));
        vehiculos.add(new Vehiculo("Hyundai", "Elantra", 3817.35));
        vehiculos.add(new Vehiculo("Saturn", "S-Series", 1866.82));
        vehiculos.add(new Vehiculo("Mazda", "MX-5", 3337.26));
        vehiculos.add(new Vehiculo("Dodge", "Durango", 3111.18));
        vehiculos.add(new Vehiculo("BMW", "3 Series", 7931.86));
        vehiculos.add(new Vehiculo("Chevrolet", "Corvette", 4903.76));
        vehiculos.add(new Vehiculo("Chevrolet", "Lumina", 1244.46));
        vehiculos.add(new Vehiculo("Toyota", "Prius Plug-in", 1406.1));
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 900.50));
        vehiculos.add(new Vehiculo("Honda", "Civic", 800.75));
        vehiculos.add(new Vehiculo("Volkswagen", "Golf", 999.99));
        vehiculos.add(new Vehiculo("Fiat", "500", 1000.00));

        Garaje garaje = new Garaje(0, vehiculos);

        // Ordenado por costo
        garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println(" -------------- ");

        // Ordenado por Marca y despues costo
        garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println(" -------------- ");

        // Filtrar por costo < 1000
        garaje.getVehiculos()
                .stream()
                .filter((x) -> x.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println(" -------------- ");

        // Filtra por costo >= 1000
        garaje.getVehiculos()
                .stream()
                .filter((x) -> x.getCosto() >= 1000)
                .forEach(System.out::println);
        System.out.println(" -------------- ");

        // Obtener el promedio del costo de todos los vehiculos
        double avg = garaje.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
        System.out.println("Promedio : " + avg);
    }
}

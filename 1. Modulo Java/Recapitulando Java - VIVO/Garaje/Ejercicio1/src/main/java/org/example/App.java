package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));


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
        // Filtrar por costo
        garaje.getVehiculos()
                .stream()
                .filter((x) -> x.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println(" -------------- ");
        garaje.getVehiculos()
                .stream()
                .filter((x) -> x.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println(" -------------- ");
        double avg = garaje.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
        System.out.println("Promedio : " + avg);
    }
}

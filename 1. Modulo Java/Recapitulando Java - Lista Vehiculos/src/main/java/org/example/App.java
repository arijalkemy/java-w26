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
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(1, vehiculos);
        garaje.getVehiculos()
            .stream()
            .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
            .forEach(System.out::println);

        System.out.println("-----------Comparando por marca y precio-----------");

        garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto)
                        .thenComparing(Vehiculo::getMarca)
                )
                .forEach(System.out::println);

        System.out.println("-----------Precio no mayor a 1000-----------");
        garaje.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("-----------Precio mayor o igual a 1000-----------");
        garaje.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("-----------Promedio total de precios-----------");
        int promedio;
        promedio = garaje.getVehiculos()
                .stream()
                .map(Vehiculo::getCosto)
                .reduce(0, Integer::sum);

        System.out.println("El promedio total es de: " + promedio / garaje.getVehiculos().size());
    }
}

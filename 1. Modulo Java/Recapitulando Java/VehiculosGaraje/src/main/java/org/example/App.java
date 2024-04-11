package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford","Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford","Focus", 1200));
        vehiculos.add(new Vehiculo("Ford","Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat","Uno", 500));
        vehiculos.add(new Vehiculo("Fiat","Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat","Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet","Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet","Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota","Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota","Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault","Logan", 950));
        Garaje garaje = new Garaje(1, vehiculos);

        // EJERCICIO 3
        System.out.println("\nOrdenados por precio ");
        garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach( x -> System.out.println(x.toString()));

        // EJERCICIO 4
        System.out.println("\nOrdenados por marca, luego por precio ");
        garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .forEach( x -> System.out.println(x.toString()));

        // EJERCICIO 5
        System.out.println("\nFiltrados por costo menor a 1000 ");
        List<Vehiculo> vehiculosMenoresAMil = garaje.getVehiculos()
                .stream()
                .filter(x -> x.getCosto() < 1000)
                .toList();
        vehiculosMenoresAMil.forEach(x -> System.out.println(x.toString()));
        System.out.println("\nFiltrados por costo mayor o igual a 1000 ");
        List<Vehiculo> vehiculosMayorOIgualAMil = garaje.getVehiculos()
                .stream()
                .filter(x -> x.getCosto() >= 1000)
                .toList();
        vehiculosMayorOIgualAMil.forEach(x -> System.out.println(x.toString()));

        Double promedio = garaje.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .getAsDouble();
        System.out.println("\nPromedio: " + promedio);

    }
}

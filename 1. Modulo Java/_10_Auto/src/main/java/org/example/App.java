package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.OptionalDouble;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Ejercicio 2
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

        Garage garage = new Garage(111, vehiculos);

        //Ejercicio 3
        List<Vehiculo> vehiculosOrdenadosPorPrecio =  vehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .toList();
        System.out.println("Primer ordenamiento");
        vehiculosOrdenadosPorPrecio.forEach(System.out::println);

        //Ejercicio 4
        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio =  vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .toList();
        System.out.println("Segundo ordenamiento");
        vehiculosOrdenadosPorMarcaYPrecio.forEach(System.out::println);

        //Ejercicio 5
        System.out.println("Vehiculos con precio menor a 1000");
        List<Vehiculo> vehiculosConPreciosMenoresA1000= vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .toList();
        vehiculosConPreciosMenoresA1000.forEach(System.out::println);

        System.out.println("Vehiculos con precio mayor a 1000");
        List<Vehiculo> vehiculosConPreciosMayoresA1000= vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();
        vehiculosConPreciosMayoresA1000.forEach(System.out::println);

        double promedio= vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average().getAsDouble();
        System.out.println("El promedio con stream es: " + promedio);

    }
}

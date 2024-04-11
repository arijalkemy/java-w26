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

        //Ejercicio 3
        vehiculos.sort(Comparator.comparingDouble(Vehiculo::getCosto));
        System.out.println("Primer ordenamiento");
        vehiculos.forEach(System.out::println);

        //Ejercicio 4
        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto));
        System.out.println("Segundo ordenamiento");
        vehiculos.forEach(System.out::println);

        //Ejercicio 5
        System.out.println("Vehiculos con precio menor a 1000");
        List<Vehiculo> vehiculosConPreciosMenoresA1000= vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList());
        vehiculosConPreciosMenoresA1000.forEach(System.out::println);

        System.out.println("Vehiculos con precio mayor a 1000");
        List<Vehiculo> vehiculosConPreciosMayoresA1000= vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
        vehiculosConPreciosMayoresA1000.forEach(System.out::println);

        OptionalDouble promedio= vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average();
        System.out.println("El promedio con stream es: " + promedio.getAsDouble());

        double total =0;
        for (Vehiculo vehiculo : vehiculos){
            total = total + vehiculo.getCosto();
        }
        double promConForeach = total/vehiculos.size();
        System.out.println("El promedio con foreach es: " + promedio.getAsDouble());

    }
}

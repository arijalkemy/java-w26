package org.example;

import org.example.model.Garaje;
import org.example.model.Vehiculo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehiculos =  Arrays.asList(
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
        );

        Garaje garaje = new Garaje(1);

        garaje.setVehiculos(vehiculos);

        List<Vehiculo> vehiculosEnGarage1 = garaje.getVehiculos();

        System.out.println("VEHICULOS ORDENADOS POR COSTO");
        vehiculosEnGarage1.sort(Comparator.comparing(Vehiculo::getCosto));
        vehiculosEnGarage1.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("--------------------------------------------------\n");
        vehiculosEnGarage1.stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("--------------------------------------------------\n");
        System.out.println("VEHICULOS ORDENADOS POR MARCA Y COSTO");
        vehiculosEnGarage1.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        vehiculosEnGarage1.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        vehiculosEnGarage1.stream()
                .sorted((v1, v2) -> {
                    int compareMarca = v1.getMarca().compareTo(v2.getMarca());
                    if (compareMarca != 0) {
                        return compareMarca;
                    }
                    return Double.compare(v1.getCosto(), v2.getCosto());
                })
                .forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("--------------------------------------------------\n");
        System.out.println("VEHICULOS CON COSTO MENOR A 1000");
        vehiculosEnGarage1.stream().filter(v -> v.getCosto()<1000).forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("--------------------------------------------------\n");
        System.out.println("VEHICULOS CON COSTO MAYOR O IGUAL A 1000");
        vehiculosEnGarage1.stream().filter(v -> v.getCosto()>=1000).forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("--------------------------------------------------\n");
        System.out.println("PROMEDIO DE COSTO");
        System.out.println(vehiculosEnGarage1.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble());

        List<Vehiculo> vehiculosMenorA1000 = vehiculosEnGarage1.stream().filter(v -> v.getCosto()<1000).collect(Collectors.toList());
        List<Vehiculo> vehiculosMayorIgualA1000 = vehiculosEnGarage1.stream().filter(v -> v.getCosto()>=1000).collect(Collectors.toList());
    }
}

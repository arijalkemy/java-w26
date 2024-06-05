package org.example;

import logica.Garaje;
import logica.Vehiculo;

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
        //Se crea una instancia de la clase garaje con una lista de vehículos segun la tabla.
        Garaje garaje = new Garaje(1);
        garaje.addVehiculo(new Vehiculo("Ford", "Fiesta", 1000.0));
        garaje.addVehiculo(new Vehiculo("Ford", "Focus", 1200.0));
        garaje.addVehiculo(new Vehiculo("Ford", "Explorer", 2500.0));
        garaje.addVehiculo(new Vehiculo("Fiat", "Uno", 500.0));
        garaje.addVehiculo(new Vehiculo("Fiat", "Cronos", 1000.0));
        garaje.addVehiculo(new Vehiculo("Fiat", "Torino", 1250.0));
        garaje.addVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        garaje.addVehiculo(new Vehiculo("Chevrolet", "Spin", 2500.0));
        garaje.addVehiculo(new Vehiculo("Toyota", "Corolla", 1200.0));
        garaje.addVehiculo(new Vehiculo("Toyota", "Fortuner", 3000.0));
        garaje.addVehiculo(new Vehiculo("Renault", "Logan", 950.0));
        System.out.println("--------------------------------------------------\n");
        List<Vehiculo> vehiculos = garaje.getVehiculos();
        //lista de vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado.
        System.out.println("VEHICULOS ORDENADOS POR COSTO");
        vehiculos.sort(Comparator.comparing(Vehiculo::getCosto));
        vehiculos.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("--------------------------------------------------\n");
        vehiculos.stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        //Imprime una lista ordenada por marca y a su vez por precio.
        System.out.println("--------------------------------------------------\n");
        System.out.println("VEHICULOS ORDENADOS POR MARCA Y COSTO");
        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        vehiculos.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        vehiculos.stream()
                .sorted((v1, v2) -> {
                    int compareMarca = v1.getMarca().compareTo(v2.getMarca());
                    if (compareMarca != 0) {
                        return compareMarca;
                    }
                    return Double.compare(v1.getCosto(), v2.getCosto());
                })
                .forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        //Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000 y por último, obtén el promedio total de precios de toda la lista de vehículos.
        System.out.println("--------------------------------------------------\n");
        System.out.println("VEHICULOS CON COSTO MENOR A 1000");
        vehiculos.stream().filter(v -> v.getCosto()<1000).forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("--------------------------------------------------\n");
        System.out.println("VEHICULOS CON COSTO MAYOR O IGUAL A 1000");
        vehiculos.stream().filter(v -> v.getCosto()>=1000).forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("--------------------------------------------------\n");
        System.out.println("PROMEDIO DE COSTO DE LOS VEHICULOS");
        System.out.println(vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble());


        List<Vehiculo> vehiculosMenorA1000 = vehiculos.stream().filter(v -> v.getCosto()<1000).toList();
        List<Vehiculo> vehiculosMayorIgualA1000 = vehiculos.stream().filter(v -> v.getCosto()>=1000).toList();


    }
}

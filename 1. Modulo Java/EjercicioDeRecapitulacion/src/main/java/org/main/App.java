package org.main;
import org.main.clases.*;

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

        List<Vehiculo> vehiculos = garaje.getVehiculos();
        System.out.println("VEHICULOS ORDENADOS POR COSTO");
        vehiculos.sort(Comparator.comparing(Vehiculo::getCosto));
        vehiculos.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("--------------------------------------------------\n");
        vehiculos.stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));
        System.out.println("--------------------------------------------------\n");


        System.out.println("VEHICULOS ORDENADOS POR MARCA Y COSTO");
        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        vehiculos.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " " + v.getCosto()));

        System.out.println("--------------------------------------------------\n");
        vehiculos.stream()
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

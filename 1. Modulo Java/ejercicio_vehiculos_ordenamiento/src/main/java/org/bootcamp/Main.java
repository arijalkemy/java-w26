package org.bootcamp;

import org.bootcamp.domain.Garaje;
import org.bootcamp.domain.Vehiculo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jsanchezpimi
 */
public class Main
{
    public static void main(String[] args) {
        // Se crea la instancia del garaje
        Garaje garaje = new Garaje(1);

        // Se agregan los vehiculos al garaje
        garaje.agregarVehiculo(new Vehiculo("Fiesta", "Ford", 1000));
        garaje.agregarVehiculo(new Vehiculo("Focus", "Ford", 1200));
        garaje.agregarVehiculo(new Vehiculo("Explorer", "Ford", 2500));
        garaje.agregarVehiculo(new Vehiculo("Uno", "Fiat", 500));
        garaje.agregarVehiculo(new Vehiculo("Cronos", "Fiat", 1000));
        garaje.agregarVehiculo(new Vehiculo("Torino", "Fiat", 1250));
        garaje.agregarVehiculo(new Vehiculo("Aveo", "Chevrolet", 1250));
        garaje.agregarVehiculo(new Vehiculo("Spin", "Chevrolet", 2500));
        garaje.agregarVehiculo(new Vehiculo("Corola", "Toyota", 1200));
        garaje.agregarVehiculo(new Vehiculo("Fortuner", "Toyota", 3000));
        garaje.agregarVehiculo(new Vehiculo("Logan", "Renault", 950));

        // Se orden los vehiculos por precio
        List<Vehiculo> vehiculosOrdenadosPorPrecio = garaje.getVehiculos().stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .collect(Collectors.toList());

        // Se imprimen los vehiculos ordenados por precio de menor a mayor
        System.out.println("\n*** Vehículos ordenados por precio de menor a mayor: ***");
        vehiculosOrdenadosPorPrecio.forEach(vehiculo ->
                System.out.println(vehiculo.getModelo() + " - Precio: $" + vehiculo.getCosto()));

        // Se ordenan por marca y precio
        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio = garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());

        // Se imprimen los vehiculos ordenados por marca y precio
        System.out.println("\n*** Vehiculos ordenados por marca y precio: ***");
        vehiculosOrdenadosPorMarcaYPrecio.forEach(vehiculo ->
                System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " - Precio: $" + vehiculo.getCosto()));

        // Se filtran los vehiculos con precio no mayor a 1000
        List<Vehiculo> vehiculosPrecioMenor1000 = garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .collect(Collectors.toList());

        // Se filtran los vehiculos con precio mayor a 1000
        List<Vehiculo> vehiculosPrecioMayor1000 = garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() > 1000)
                .collect(Collectors.toList());

        // Se imprimen los vehiculos con precio no mayor a 1000
        System.out.println("\n*** Vehículos con precio no mayor a 1000: ***");
        vehiculosPrecioMenor1000.forEach(vehiculo ->
                System.out.println(vehiculo.getModelo() + " - Precio: $" + vehiculo.getCosto()));

        // Se imprimen los vehiculos con precio mayor a 1000
        System.out.println("\n*** Vehículos con precio mayor a 1000: ***");
        vehiculosPrecioMayor1000.forEach(vehiculo ->
                System.out.println(vehiculo.getModelo() + " - Precio: $" + vehiculo.getCosto()));

        // Se calcula el promedio de precios de todos los vehiculos
        double promedioPrecios = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0D);

        // Se imprime el promedio de precios
        System.out.println("\nPromedio total de precios: $" + promedioPrecios);
    }
}

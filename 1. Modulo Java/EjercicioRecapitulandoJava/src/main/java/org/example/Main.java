package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garage garage = new Garage(new Random().nextInt(), vehiculos);

        /*
         3)
         Haciendo uso del método sort en la lista de Vehículos con expresiones lambda,
         obtén una lista de vehículos ordenados por precio de menor a mayor,
         imprime por pantalla el resultado.
         */
        garage.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getCosto));
        System.out.println(garage);

        /*
         4)
         De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
         */
        garage.getVehiculos().sort(
            Comparator.comparing(Vehiculo::getMarca)
                .thenComparingDouble(Vehiculo::getCosto)
        );
        System.out.println(garage);

        /*
         5)
         Se desea extraer una lista de vehículos con precio no mayor a 1000,
         luego otra con precios mayor o igual 1000
         y por último, obtén el promedio total de precios de toda la lista de vehículos.
         */
        List<Vehiculo> vehiculosConPrecioMenorAMil = garage.getVehiculos().stream()
            .filter(vehiculo -> vehiculo.getCosto() < 1000)
            .toList();

        System.out.println("\nVehiculos con precio menor a 1000");
        vehiculosConPrecioMenorAMil.forEach(System.out::println);

        List<Vehiculo> vehiculosConPrecioMayorOIgualAMil = garage.getVehiculos().stream()
            .filter(vehiculo -> vehiculo.getCosto() >= 1000.0)
            .toList();

        System.out.println("\nVehiculos con precio mayour o igual a 1000");
        vehiculosConPrecioMayorOIgualAMil.forEach(System.out::println);

        double promedioCostoVehiculos = garage.getVehiculos().stream()
            .mapToDouble(Vehiculo::getCosto)
            .average()
            .getAsDouble();

        System.out.println("\nCosto promedio de los vehículos: " + promedioCostoVehiculos);
    }
}

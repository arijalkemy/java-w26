package com.mercadolibre.recapitulandojava;

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
        Garaje garaje = new Garaje(1, List.of(
                new Vehiculo("Fiesta", "Ford", 54200.0),
                new Vehiculo("Fiesta", "Ford", 54000.0),
                new Vehiculo("Fiesta", "Ford", 54400.0),
                new Vehiculo("Fiesta", "Ford", 54400.0),
                new Vehiculo("Fiesta", "Ford", 54400.0),
                new Vehiculo("Fiesta", "Ford", 54400.0),
                new Vehiculo("Fiesta", "Ford", 54400.0),
                new Vehiculo("Fiesta", "Ford", 54400.0),
                new Vehiculo("Fiesta", "Ford", 54400.0),
                new Vehiculo("Fiesta", "Ford", 54400.0),
                new Vehiculo("Fiesta", "Ford", 54600.0)
        ));
        System.out.println("POR COSTO: \n");
        garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\n\nPOR MARCA Y COSTO: \n");
        garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        List<Vehiculo> noMayoresAMil = garaje.getVehiculos().stream().filter((v) -> v.getCosto() < 1000).toList();
        List<Vehiculo> mayorIgualAMil = garaje.getVehiculos().stream().filter((v) -> v.getCosto() >= 1000).toList();
        Double promedioTotal = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
    }
}

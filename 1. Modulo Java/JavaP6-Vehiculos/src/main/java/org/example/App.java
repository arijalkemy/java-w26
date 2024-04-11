package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class App 
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehicles =  Arrays.asList(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Fiat", "Corola", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        );

        Garaje myGaraje = new Garaje(1, vehicles);

        //Ejercicio 3
        System.out.println("EJERCICIO 3 ");
        myGaraje.getListVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(v -> System.out.println(v.getMarca()));
        System.out.println(".-------.------");

        //Ejercicio4

        System.out.println("EJERCICIO 4");

        myGaraje.getListVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto)).forEach(v -> System.out.println(v.getMarca() + "->" + v.getCosto()));
        System.out.println(".-------.------");

        //Ejercicio 5

        System.out.println("EJERCICIO 5");
        myGaraje.getListVehiculos().stream().filter(v -> v.getCosto() <= 1000).forEach(v -> System.out.println(v.getMarca()));
        System.out.println(".-------.------");
        myGaraje.getListVehiculos().stream().filter(v -> v.getCosto() >= 1000).forEach(v -> System.out.println(v.getMarca()));
        System.out.println(".-------.------");
        OptionalDouble suma = myGaraje.getListVehiculos().stream().mapToDouble(v -> v.getCosto()).average();
        System.out.println("El promedio de los costos de los coches es: " + suma.getAsDouble());


    }
}

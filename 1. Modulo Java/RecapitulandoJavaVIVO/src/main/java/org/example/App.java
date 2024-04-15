package org.example;

import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<Vehiculo> vehiculos = new ArrayList<>(Arrays.asList(
            new Vehiculo("Ford", "Fiesta", 1000),
            new Vehiculo("Ford", "Focus", 1200),
            new Vehiculo("Ford", "Explorer", 2500),
            new Vehiculo("Fiat", "Uno", 500),
            new Vehiculo("Fiat", "Cronos", 1000),
            new Vehiculo("Fiat", "Torino", 1250),
            new Vehiculo("Chevrolet", "Aveo", 1250),
            new Vehiculo("Chevrolet", "Spin", 2500),
            new Vehiculo("Toyota", "Corola", 1200),
            new Vehiculo("Corolla", "Fortuner", 3000),
            new Vehiculo("Renault", "Logan", 950)));

            Garage garage = new Garage(1, vehiculos);
            // Ordenar por precio
            garage.getVehiculos().stream().sorted((v1,v2)->Integer.compare(v1.getCosto(),v2.getCosto()))
                    .forEach(v1->System.out.println(v1.getMarca()+" "+v1.getModelo()+" "+v1.getCosto()));

            // Imprimir por marca y luego por precio
            System.out.println("\n---Ordenado por marca y luego por precio---\n");
            garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                    .forEach(v1->System.out.println(v1.getMarca()+" "+v1.getModelo()+" "+v1.getCosto()));

            // Filtrar por precio , menos de 1000 y desppues ordenar por precio mas de 1000, al final el promedio de los precios

            System.out.println("\n---Filtrar por precio , menos de 1000 y desppues ordenar por precio mas de 1000---\n");
            garage.getVehiculos().stream().filter(v1->v1.getCosto()<1000).mapToDouble(Vehiculo::getCosto).average().ifPresent(System.out::println);
            garage.getVehiculos().stream().filter(v1->v1.getCosto()>1000).mapToDouble(Vehiculo::getCosto).average().ifPresent(System.out::println); 
    }


}

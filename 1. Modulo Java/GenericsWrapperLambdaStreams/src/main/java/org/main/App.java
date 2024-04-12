package org.main;

import org.entities.Garaje;
import org.entities.Vehiculo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(Arrays.asList(new Vehiculo("Ford","Fiesta",1000),
                new Vehiculo("Ford","Focus",1200),
                new Vehiculo("Ford","Explorer",2500),
                new Vehiculo("Flat","Uno",500),
                new Vehiculo("Flat","Cronos",1000),
                new Vehiculo("Flat","Torino",1250),
                new Vehiculo("Chevrolet","Aveo",1250),
                new Vehiculo("Chevrolet","Spin",2500),
                new Vehiculo("Toyota","Corola",1200),
                new Vehiculo("Toyota","Fortuner",3000),
                new Vehiculo("Renault","Logan",950)
                ));
        System.out.println("Comparados por costo");
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(v -> System.out.println(v.getCosto()));
        System.out.println("\nComparados por costo y marca");
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).sorted().forEach(v -> System.out.println("Marca: "+v.getMarca() + " Costo: " +v.getCosto()));
        System.out.println("\nMenores a mil");
        garaje.getVehiculos().stream().filter(v->v.getCosto()<1000).collect(Collectors.toList()).forEach(v-> System.out.println("Vehiculo " +v.getMarca() + " Costo: " +v.getCosto()));
        System.out.println("\nMayores o iguales a mil");
        garaje.getVehiculos().stream().filter(v->v.getCosto()>=1000).collect(Collectors.toList()).forEach(v-> System.out.println("Vehiculo " +v.getMarca() + " Costo: " +v.getCosto()));
        double promedio = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0d);
        System.out.println("\nPromedio: "+String.format("%.2f",promedio));
    }
}

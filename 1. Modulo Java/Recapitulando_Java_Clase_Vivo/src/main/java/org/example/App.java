package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<Vehiculo> vehiculoList = new ArrayList();

        vehiculoList.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculoList.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculoList.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculoList.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculoList.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculoList.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculoList.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculoList.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculoList.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculoList.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculoList.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(1, vehiculoList);

        System.out.println("Ordenar la lista de vehículos por precio de menor a mayor");
        garaje.getVehiculoList().stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .forEach(System.out::println);


        System.out.println("\nOrdenar la lista de vehículos por marca y precio");
        garaje.getVehiculoList().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);





    }
}

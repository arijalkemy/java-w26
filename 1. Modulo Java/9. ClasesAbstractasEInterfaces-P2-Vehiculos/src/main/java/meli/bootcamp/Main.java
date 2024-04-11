package meli.bootcamp;

import meli.bootcamp.entidades.Garage;
import meli.bootcamp.entidades.Vehiculo;

import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(1, List.of(new Vehiculo("Ford", "Fiesta", 1000), new Vehiculo("Ford", "Focus",
                1200), new Vehiculo("Ford", "Explorer", 2500), new Vehiculo("Fiat", "Uno", 500), new Vehiculo("Fiat",
                "Cronos", 1000), new Vehiculo("Fiat", "Torino", 1250), new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500), new Vehiculo("Toyota", "Corola", 1200), new Vehiculo("Toyota"
                        , "Fortuner", 3000), new Vehiculo("Renault", "Logan", 950)));

        garage.getVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(v -> System.out.println(v.toString()));

        System.out.println("\n------------------\n");

        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Comparator.comparingDouble(Vehiculo::getCosto))).forEach(v -> System.out.println(v.toString()));

        System.out.println("\n------------------\n");

        garage.getVehiculos().stream().filter(v -> v.getCosto() < 1000).forEach(v -> System.out.println(v.toString()));


        System.out.println("\n------------------\n");

        garage.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).forEach(v -> System.out.println(v.toString()));

        Double promedioTotal = garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);

        System.out.println("\n------------------\n");

        System.out.println("El promedio total de precios es: " + promedioTotal);
    }

}

package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class App
{
    public static void main( String[] args ) {
        Garage garage = new Garage(1, List.of(
                new Vehicle("Ford", "Focus", 1200),
                new Vehicle("Ford", "Fiesta", 1000),
                new Vehicle("Ford", "Explorer", 2500),
                new Vehicle("Fiat", "Uno", 500),
                new Vehicle("Fiat", "Cronos", 1000),
                new Vehicle("Fiat", "Torino", 1250),
                new Vehicle("Chevrolet", "Aveo", 1250),
                new Vehicle("Chevrolet", "Spin", 2500),
                new Vehicle("Toyota", "Corola", 1200),
                new Vehicle("Toyota", "Fortuner", 3000),
                new Vehicle("Renault", "Logan", 950)));

        System.out.println("Ordered by Price");

        List<Vehicle> vehiclesSortedByPrice = garage.getVehicules().stream().sorted(Comparator.comparing(Vehicle::getPrice)).toList();
        System.out.println(vehiclesSortedByPrice);

        System.out.println("=================");
        System.out.println("Ordered by Brand and Price");

        List<Vehicle> vehiclesSortedByBrandAndPrice = garage.getVehicules()
                .stream()
                .sorted(Comparator.comparing(Vehicle::getBrand)
                .thenComparing(Vehicle::getPrice))
                .toList();
        System.out.println(vehiclesSortedByBrandAndPrice);

        System.out.println("=================");
        System.out.println("Vehicles less than $1000");

        List<Vehicle> vehiclesLessThan1000 = garage.getVehicules()
                .stream()
                .filter(vehicle -> vehicle.getPrice()<1000)
                .toList();
        System.out.println(vehiclesLessThan1000);

        System.out.println("=================");
        System.out.println("Vehicles more than $1000");

        List<Vehicle> vehiclesMoreThan1000 = garage.getVehicules()
                .stream()
                .filter(vehicle -> vehicle.getPrice() >= 1000)
                .sorted(Comparator.comparing(Vehicle::getPrice))
                .toList();
        System.out.println(vehiclesMoreThan1000);

        System.out.println("=================");
        System.out.println("Average Price for all Vehicles");

        double averagePrice = garage.getVehicules()
                .stream()
                .mapToDouble(Vehicle::getPrice)
                .average().getAsDouble();
        System.out.println(averagePrice);
    }
}

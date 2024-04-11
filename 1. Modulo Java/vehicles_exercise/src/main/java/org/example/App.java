package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Garage myGarage = getGarage();
        System.out.println("Sorted by price:");
        printVehicles(myGarage.getSortedByPrice());
        System.out.println("Sorted by brand and price:");
        printVehicles(myGarage.getSortedByPriceAndBrand());
        System.out.println("Filtered less than 1000");
        printVehicles(myGarage.getLessThan());
        System.out.println("Filtered greater or equal than 1000");
        printVehicles(myGarage.getGreaterThan());
        System.out.println("Average price");
        System.out.println(myGarage.getAverageStr());
    }

    public static Garage getGarage() {
        List<Vehicle> vehicles = new ArrayList<>(Arrays.asList(
                new Vehicle("Ford", "Fiesta", 1000),
                new Vehicle("Ford", "Focues", 1200),
                new Vehicle("Ford", "Explorer", 2500),
                new Vehicle("Fiat", "Uno", 500),
                new Vehicle("Fiat", "Cronos", 1000),
                new Vehicle("Fiat", "Torino", 1250),
                new Vehicle("Chevrolet", "Aveo", 1250),
                new Vehicle("Chevrolet", "Spin", 2500),
                new Vehicle("Toyota", "Corola", 1200),
                new Vehicle("Toyota", "Fortuner", 3000),
                new Vehicle("Renault", "Logan", 950)
        ));
        return new Garage("garage_1", vehicles);
    }

    public static void printVehicles(List<Vehicle> vehicleList) {
        vehicleList.forEach(vehicle -> System.out.println(vehicle.getBrand() + " | " + vehicle.getModel() +
                " -> "+ vehicle.getPrice()));
    }
}

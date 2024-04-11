package org.example.AbstractClass_Interfaces.Ejercicio_4;

import org.example.AbstractClass_Interfaces.Ejercicio_4.Implements.Garage;
import org.example.AbstractClass_Interfaces.Ejercicio_4.Implements.Vehicle;

import java.util.*;

public class App {

    private static List<Vehicle> getVehicles() {
        return Arrays.asList(
                new Vehicle("Ford", "Fiesta", 1000),
                new Vehicle("Ford", "Focus", 1200),
                new Vehicle("Ford", "Explorer", 2500),
                new Vehicle("Fiat", "Uno", 500),
                new Vehicle("Fiat", "Cronos", 1000),
                new Vehicle("Fiat", "Torino", 1250),
                new Vehicle("Chevrolet", "Aveo", 1250),
                new Vehicle("Chevrolet", "Spin", 2500),
                new Vehicle("Toyota", "Corola", 1200),
                new Vehicle("Toyota", "Fortuner", 3000),
                new Vehicle("Renault", "Logan", 950)
        );
    }


    public static void main(String[] args) {
        List<Vehicle> vehicles = getVehicles();
        Garage garage = new Garage(1, vehicles);

        System.out.println("++++++++++++Vehiculos ordenados por precio++++++++++++");
        garage.getVehicles().stream().sorted(Vehicle::compareToPrice).forEach(System.out::println);

        System.out.println("++++++++++++Vehiculos ordenados por marca y precio++++++++++++");
        vehicles.stream()
                .sorted((v1, v2) -> {
                    int result = v1.compareToMark(v2);
                    if (result == 0) {
                        return v1.compareToPrice(v2);
                    }
                    return result;
                }).forEach(System.out::println);

        List<Vehicle> vehiclesLessThan1000 = garage.vehiclesLessThan(1000);
        List<Vehicle> vehiclesGreaterEqualThan1000 = garage.vehiclesGreaterEqual(1000);
        double averagePrice = garage.calcAveragePrice();

        System.out.println("++++++++++++Vehiculos con precio menor a 1000++++++++++++");
        vehiclesLessThan1000.forEach(System.out::println);
        System.out.println("++++++++++++Vehiculos con precio mayor o igual a 1000++++++++++++");
        vehiclesGreaterEqualThan1000.forEach(System.out::println);
        System.out.println("++++++++++++Precio promedio de los vehiculos++++++++++++");
        System.out.println(averagePrice);


    }
}
